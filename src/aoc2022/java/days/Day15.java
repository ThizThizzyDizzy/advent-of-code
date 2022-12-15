package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.ArrayList;
public class Day15 extends Day{
    private static int taxi(int x, int y, int x0, int y0){
        return Math.abs(x-x0)+Math.abs(y-y0);
    }
    public Day15(){
        super(15);
    }
    static int xmin = Integer.MAX_VALUE, xmax = Integer.MIN_VALUE, ymin = Integer.MAX_VALUE, ymax = Integer.MIN_VALUE;
    static ArrayList<Sensor> sensors = new ArrayList<>();
    @Override
    public void run(){
        for(String s : input.split("\n")){
            String[] str = s.replace(",", "").replace(":", "").split(" ");
            int sx = Integer.parseInt(str[2].substring(2));
            int sy = Integer.parseInt(str[3].substring(2));
            int bx = Integer.parseInt(str[8].substring(2));
            int by = Integer.parseInt(str[9].substring(2));
            new Sensor(sx, sy, taxi(sx, sy, bx, by), bx, by);
        }
        int i = 0;
        for(int x = xmin; x<=xmax; x++){
            if(has(x,2000000))i++;
        }
        System.out.println(i);
        for(int y = 0; y<=4000000; y++){
            for(int x = 0; x<=4000000; x++){
                Sensor s = get(x,y);
                if(s==null){
                    System.out.println(x*4000000l+y);
                }else{
                    x = s.maxX(y);
                }
            }
        }
    }
    public static boolean has(int x, int y){
        if(x<xmin||x>xmax||y<ymin||y>ymax)return false;
        for(Sensor s : sensors){
            if(s.bx==x&&s.by==y)return false;
        }
        for(Sensor s : sensors){
            if(taxi(s.x,s.y,x,y)<=s.radius){
                return true;
            }
        }
        return false;
    }
    public static Sensor get(int x, int y){
        for(Sensor s : sensors){
            if(taxi(s.x,s.y,x,y)<=s.radius){
                return s;
            }
        }
        return null;
    }
    private static class Sensor {
        private final int x, y, radius;
        private final int bx;
        private final int by;
        public Sensor(int x, int y, int radius, int bx, int by){
            this.x = x;
            this.y = y;
            this.radius = radius;
            xmin = Math.min(xmin, x-radius);
            ymin = Math.min(ymin, y-radius);
            xmax = Math.max(xmax, x+radius);
            ymax = Math.max(ymax, y+radius);
            sensors.add(this);
            this.bx = bx;
            this.by = by;
        }
        private int overlap(Sensor other){
            int totalDist = taxi(x, y, other.x, other.y);
            int depth = (radius+other.radius)-totalDist+1;
            int width = (totalDist-depth+1)/2-Math.abs(radius-other.radius)*2+Math.max(radius,other.radius);
            int odds = ((width+1)/2)*((depth+1)/2);
            int evens = (width/2)*(depth/2);
            System.out.println(width+" "+depth);
            return odds+evens;
        }
        private int maxX(int y){
            int width = (radius-Math.abs(this.y-y))*2+1;
            return x+width/2;
        }
    }
}