package aoc2022.java;
public abstract class Day{
    private final String input1;
    private final String input2;
    public Day(String puzzle1, String puzzle2){
        this.input1 = puzzle1;
        this.input2 = puzzle2;
    }
    public abstract void run();
}