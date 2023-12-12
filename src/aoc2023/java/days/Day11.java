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
            for(Galaxy galaxy : galaxies)if(galaxy.x>x)galaxy.x++;
            x++;
        }
        Y:for(int y = 0; y<lines.length*2; y++){
            for(Galaxy galaxy : galaxies)if(galaxy.y==y)continue Y;
            for(Galaxy galaxy : galaxies)if(galaxy.y>y)galaxy.y++;
            y++;
        }
        long total = 0;
        G:for(Galaxy g1 : galaxies){
            for(Galaxy g2 : galaxies){
                if(g1==g2)continue G;
                int dist = Math.abs(g1.x-g2.x)+Math.abs(g1.y-g2.y);
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