package aoc2022.java.days;
import aoc2022.java.Day;
public class Day10 extends Day{
    public Day10(){
        super(10);
    }
    int cycleCounter = 0;
    int x = 1;
    int out = 0;
    String output = "";
    @Override
    public void run(){
        for(String s : input.split("\n")){
            cycleCounter++;
            checkCycle();
            if(s.startsWith("addx")){
                cycleCounter++;
                checkCycle();
                x+=Integer.parseInt(s.substring(5));
            }
        }
        System.out.println(out);
        System.out.println(output.strip());
    }
    public void checkCycle(){
        if(Math.abs((cycleCounter-1)%40-x)<=1)output+="#";
        else output+=".";
        if(cycleCounter%40==0)output+="\n";
        if(cycleCounter%40==20){
            out+=x*cycleCounter;
            System.out.println(x+" "+cycleCounter+" "+x*cycleCounter);
        }
    }
}