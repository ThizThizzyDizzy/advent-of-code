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
        days[6] = new Day7();
        days[7] = new Day8();
        days[8] = new Day9();
        days[9] = new Day10();
        days[10] = new Day11();
        days[11] = new Day12();
        days[12] = new Day13();
        days[13] = new Day14();
    }
    public static void main(String[] args){
        for(int i = 0; i<25; i++){
            if(i<24&&days[i+1]!=null||days[i]==null)continue;//last day only!
            days[i].run();
        }
    }
}