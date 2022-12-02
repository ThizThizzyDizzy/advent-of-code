package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.ArrayList;
import java.util.Collections;
public class Day1 extends Day{
    public Day1(){
        super(1);
    }
    @Override
    public void run() {
        ArrayList<Integer> elves = new ArrayList<>();
        String[] strs = input.split("\n");
        int current = 0;
        for(String s : strs){
            try{
                int i = Integer.parseInt(s);
                current+=i;
            }catch(NumberFormatException ex){
                elves.add(current);
                current = 0;
            }
        }
        if(current>0)elves.add(current);
        current = 0;
        Collections.sort(elves);
        System.out.println(elves.get(elves.size()-1));
        System.out.println(elves.get(elves.size()-1)+elves.get(elves.size()-2)+elves.get(elves.size()-3));
    }
}