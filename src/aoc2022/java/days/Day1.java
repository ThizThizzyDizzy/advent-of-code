package aoc2022.java.days;
import aoc2022.java.Day;
public class Day1 extends Day{
    public Day1(String input){
        super(input);
    }
    @Override
    public void run() {
        int max = 0;
        String[] strs = input.split("\n");
        int current = 0;
        for(String s : strs){
            try{
                int i = Integer.parseInt(s);
                current+=i;
            }catch(NumberFormatException ex){
                if(current>max)max = current;
                current = 0;
            }
        }
        if(current>max)max = current;
        current = 0;
        System.out.println(max);
    }
}