package aoc2022.java.days;
import aoc2022.java.Day;
public class Day4 extends Day{
    public Day4(){
        super(4);
    }
    @Override
    public void run() {
        int count = 0;
        for(String s : input.split("\n")){
            String[] ranges = s.split(",");
            String[] r1 = ranges[0].split("-");
            String[] r2 = ranges[1].split("-");
            int r1a = Integer.parseInt(r1[0]);
            int r1b = Integer.parseInt(r1[1]);
            int r2a = Integer.parseInt(r2[0]);
            int r2b = Integer.parseInt(r2[1]);
            if(r2a>=r1a&&r2b<=r1b||r1a>=r2a&&r1b<=r2b)count++;
        }
        System.out.println(count);
    }
}