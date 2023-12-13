package aoc2023.java.days;
import aoc2023.java.Day;
import java.util.Arrays;
import java.util.HashMap;
public class Day12 extends Day{
    public Day12(){
        super(12);
    }
    @Override
    public void run(){
        long total = 0;
        for(String line : input.split("\n")){
            String[] parts = line.split(" ");
            String pattern = parts[0];
            String[] key = parts[1].split(",");
            int[] nums = new int[key.length];
            for(int i = 0; i<key.length; i++)nums[i] = Integer.parseInt(key[i]);
            total+=calcPossibilities(pattern, nums, 0, 0);
        }
        System.out.println(total);
        total = 0;
        long n = 0;
        for(String line : input.split("\n")){
            n++;
            String[] parts = line.split(" ");
            String pattern = ("?"+parts[0]).repeat(5).substring(1);
            String[] key = (","+parts[1]).repeat(5).substring(1).split(",");
            int[] nums = new int[key.length];
            for(int i = 0; i<key.length; i++)nums[i] = Integer.parseInt(key[i]);
            total+=calcPossibilities(pattern, nums, 0, 0);
        }
        System.out.println(total);
    }
    HashMap<String, Long> calcCache = new HashMap<>();
    private long calcPossibilities(String pattern, int[] key, int patternOffset, int keyOffset){
        String str = pattern+"|"+Arrays.toString(key)+"|"+patternOffset+"|"+keyOffset;
        Long l = calcCache.get(str);
        if(l!=null)return l;
        if(keyOffset==key.length){
            long result = pattern.substring(Math.min(patternOffset, pattern.length())).contains("#")?0:1;
            calcCache.put(str, result);
            return result;
        }
        int totalLen = -1;
        for(int k = keyOffset; k<key.length; k++)totalLen+=key[k]+1;
        if(totalLen+patternOffset>pattern.length()){
            calcCache.put(str, 0l);
            return 0;
        }
        long possibilities = 0;
        int idx = -1;
        if(patternOffset<pattern.length()){
            String shorterPattern = pattern.substring(patternOffset);
            int id = shorterPattern.indexOf("#");
            idx = id==-1?-1:(patternOffset+Math.min(shorterPattern.length(), id+1));
        }
        for(int x = patternOffset; x<(idx==-1?pattern.length():idx); x++){
            if(fits(pattern, x, key[keyOffset])){
                possibilities+=calcPossibilities(pattern, key, x+key[keyOffset]+1, keyOffset+1);
            }
        }
        calcCache.put(str, possibilities);
        return possibilities;
    }
    private boolean fits(String fullPattern, int patternOffset, int num){
        if(patternOffset>0&&fullPattern.charAt(patternOffset-1)=='#')return false;
        String pattern = fullPattern.substring(patternOffset);
        if(pattern.length()<num)return false;
        if(pattern.length()>num&&pattern.charAt(num)=='#')return false;
        for(int i = 0; i<num; i++){
            if(pattern.charAt(i)=='.')return false;
        }
        return true;
    }
}