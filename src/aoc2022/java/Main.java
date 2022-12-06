package aoc2022.java;
import aoc2022.java.days.*;
public class Main{
    public static Day[] days = new Day[25];
    static{
        days[0] = new Day1();
        days[1] = new Day2();
        days[2] = new Day3();
        days[3] = new Day4();
        days[4] = new Day5();
        days[5] = new Day6();
    }
    public static void main(String[] args){
        for(int i = 0; i<25; i++){
            if(i<24&&days[i+1]!=null||days[i]==null)continue;//last day only!
            days[i].run();
        }
    }
}