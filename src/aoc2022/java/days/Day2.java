package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.ArrayList;
import java.util.Collections;
public class Day2 extends Day{
    public Day2(){
        super(2);
    }
    @Override
    public void run() {
        String[] games = input.split("\n");
        int total = 0;
        for(String s : games){
            int result = rps(s);
            total+=result;
        }
        System.out.println(total);
    }
    private int rps(String s) {
        int opponent = switch(s.charAt(0)){
            case 'A' -> 1;
            case 'B' -> 2;
            case 'C' -> 3;
            default -> 0;
        };
        int me = switch(s.charAt(2)){
            case 'X' -> 1;
            case 'Y' -> 2;
            case 'Z' -> 3;
            default -> 0;
        };
        int roundScore = 0;
        if(me==opponent+1||me==opponent-2)roundScore = 6;
        else if(me==opponent)roundScore = 3;
        else roundScore = 0;
        return roundScore+me;
    }
}