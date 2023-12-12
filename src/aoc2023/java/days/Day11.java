package aoc2023.java.days;
import aoc2023.java.Day;
import java.util.ArrayList;
public class Day11 extends Day{
    public Day11(){
        super(11);
    }
    @Override
    public void run(){
        ArrayList<Galaxy> galaxies = new ArrayList<>();
        ArrayList<Integer> xGaps = new ArrayList<>();
        ArrayList<Integer> yGaps = new ArrayList<>();
        String[] lines = input.split("\n");
        for(int y = 0; y<lines.length; y++){
            String line = lines[y];
            for(int x = 0; x<line.length(); x++){
                char c = line.charAt(x);
                if(c=='#'){
                    galaxies.add(new Galaxy(x,y));
                }
            }
        }
        X:for(int x = 0; x<lines[0].length()*2; x++){
            for(Galaxy galaxy : galaxies)if(galaxy.x==x)continue X;
            xGaps.add(x);
        }
        Y:for(int y = 0; y<lines.length*2; y++){
            for(Galaxy galaxy : galaxies)if(galaxy.y==y)continue Y;
            yGaps.add(y);
        }
        long gapSize = 1;
        long total = 0;
        G:for(Galaxy g1 : galaxies){
            for(Galaxy g2 : galaxies){
                if(g1==g2)continue G;
                long dist = Math.abs(g1.x-g2.x)+Math.abs(g1.y-g2.y);
                int x1 = Math.min(g1.x,g2.x);
                int x2 = Math.max(g1.x,g2.x);
                int y1 = Math.min(g1.y,g2.y);
                int y2 = Math.max(g1.y,g2.y);
                for(int X = x1; X<=x2; X++)if(xGaps.contains(X))dist+=gapSize;
                for(int Y = y1; Y<=y2; Y++)if(yGaps.contains(Y))dist+=gapSize;
                total+=dist;
            }
        }
        System.out.println(total);
        gapSize = 999999;
        total = 0;
        G:for(Galaxy g1 : galaxies){
            for(Galaxy g2 : galaxies){
                if(g1==g2)continue G;
                long dist = Math.abs(g1.x-g2.x)+Math.abs(g1.y-g2.y);
                int x1 = Math.min(g1.x,g2.x);
                int x2 = Math.max(g1.x,g2.x);
                int y1 = Math.min(g1.y,g2.y);
                int y2 = Math.max(g1.y,g2.y);
                for(int X = x1; X<=x2; X++)if(xGaps.contains(X))dist+=gapSize;
                for(int Y = y1; Y<=y2; Y++)if(yGaps.contains(Y))dist+=gapSize;
                total+=dist;
            }
        }
        System.out.println(total);
    }
    private static class Galaxy{
        private int x;
        private int y;
        private Galaxy(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}