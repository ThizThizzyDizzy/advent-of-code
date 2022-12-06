package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.HashSet;
public class Day6 extends Day{
    public Day6(){
        super(6);
    }
    @Override
    public void run() {
        char[] chars = input.toCharArray();
        boolean part1 = false;
        for(int i = 3; i<chars.length; i++){
            HashSet<Character> set = new HashSet<>();
            set.add(chars[i]);
            set.add(chars[i-1]);
            set.add(chars[i-2]);
            set.add(chars[i-3]);
            if(set.size()>=4&&!part1){
                System.out.println(i+1);
                part1 = true;
            }
            if(i>13){
                set.add(chars[i-4]);
                set.add(chars[i-5]);
                set.add(chars[i-6]);
                set.add(chars[i-7]);
                set.add(chars[i-8]);
                set.add(chars[i-9]);
                set.add(chars[i-10]);
                set.add(chars[i-11]);
                set.add(chars[i-12]);
                set.add(chars[i-13]);
                if(set.size()>=14){
                    System.out.println(i+1);
                    return;
                }
            }
        }
    }
}