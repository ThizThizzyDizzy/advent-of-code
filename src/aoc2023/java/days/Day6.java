package aoc2023.java.days;
import aoc2023.java.Day;
public class Day6 extends Day{
    public Day6(){
        super(6);
    }
    @Override
    public void run(){
        String[] strs = input.split("\n");
        String[] times = strs[0].substring("Time:".length()).trim().split(" +");
        String[] distances = strs[1].substring("Distance:".length()).trim().split(" +");
        long total = 1;
        for(int i = 0; i<times.length; i++){
            long time = Long.parseLong(times[i]);
            long dist = Long.parseLong(distances[i]);
            total*=calc(time, dist);
        }
        System.out.println(total);
        long time = Long.parseLong(strs[0].substring("Time:".length()).replace(" ", ""));
        long dist = Long.parseLong(strs[1].substring("Distance:".length()).replace(" ", ""));
        System.out.println(calc(time, dist));
    }
    public long calc(long time, long dist){
        long firstWin = -1;
        for(long l = dist/time; l<time; l++){
            long d = (time-l)*l;
            if(firstWin==-1&&d>dist){
                firstWin = l;
                break;
            }
        }
        long lastWin = -1;
        for(long l = time-1; l>0; l--){
            long d = (time-l)*l;
            if(lastWin==-1&&d>dist){
                lastWin = l;
                break;
            }
        }
        return lastWin-firstWin+1;
    }
}