package aoc2023.java.days;
import aoc2023.java.Day;
import java.util.ArrayList;
public class Day13 extends Day{
    public Day13(){
        super(13);
    }
    @Override
    public void run(){
        int total = 0;
        String[] patterns = input.split("\n\n");
        int[] was = new int[patterns.length];
        for(int i = 0; i<patterns.length; i++){
            String pattern = patterns[i];
            String[] lines = pattern.split("\n");
            for(int y = 1; y<lines.length; y++){
                boolean yMatches = true;
                for(int dy = 0; dy<lines.length; dy++){
                    int left = y-dy-1;
                    int right = y+dy;
                    if(left<0||right>=lines.length)break;
                    yMatches &= lines[left].equals(lines[right]);
                }
                if(yMatches){
                    was[i] = y*100;
                    total+=y*100;
                    break;
                }
            }
            String[] cols = transpose(lines);
            for(int x = 1; x<cols.length; x++){
                boolean xMatches = true;
                for(int dx = 0; dx<cols.length; dx++){
                    int left = x-dx-1;
                    int right = x+dx;
                    if(left<0||right>=cols.length)break;
                    xMatches &= cols[left].equals(cols[right]);
                }
                if(xMatches){
                    was[i] = x;
                    total+=x;
                    break;
                }
            }
        }
        System.out.println(total);
        total = 0;
        for(int i = 0; i<patterns.length; i++){
            SMUDGE:for(String pattern : smudge(patterns[i])){
                String[] lines = pattern.split("\n");
                for(int y = 1; y<lines.length; y++){
                    boolean yMatches = true;
                    for(int dy = 0; dy<lines.length; dy++){
                        int left = y-dy-1;
                        int right = y+dy;
                        if(left<0||right>=lines.length)break;
                        yMatches &= lines[left].equals(lines[right]);
                    }
                    if(yMatches){
                        if(was[i]==y*100)continue;
                        total+=y*100;
                        break SMUDGE;
                    }
                }
                String[] cols = transpose(lines);
                for(int x = 1; x<cols.length; x++){
                    boolean xMatches = true;
                    for(int dx = 0; dx<cols.length; dx++){
                        int left = x-dx-1;
                        int right = x+dx;
                        if(left<0||right>=cols.length)break;
                        xMatches &= cols[left].equals(cols[right]);
                    }
                    if(xMatches){
                        if(was[i]==x)continue;
                        total+=x;
                        break SMUDGE;
                    }
                }
            }
        }
        System.out.println(total);
    }
    private String[] transpose(String[] lines){
        String[] cols = new String[lines[0].length()];
        for(String s : lines){
            for(int i = 0; i<s.length(); i++)cols[i]+=s.charAt(i);
        }
        return cols;
    }
    private ArrayList<String> smudge(String pattern){
        ArrayList<String> smudged = new ArrayList<>();
        for(int i = 0; i<pattern.length(); i++){
            String left = pattern.substring(0, i);
            String right = pattern.substring(i+1);
            char c = pattern.charAt(i);
            if(c=='.')smudged.add(left+'#'+right);
            if(c=='#')smudged.add(left+'.'+right);
        }
        return smudged;
    }
}