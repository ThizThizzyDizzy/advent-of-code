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
        for(int i = 3; i<chars.length; i++){
            HashSet<Character> set = new HashSet<>();
            set.add(chars[i]);
            set.add(chars[i-1]);
            set.add(chars[i-2]);
            set.add(chars[i-3]);
            if(set.size()==4){
                System.out.println(i+1);
                break;
            }
        }
    }
}