package aoc2023.java.days;
import aoc2023.java.Day;
import java.util.ArrayList;
import java.util.Collections;
public class Day18 extends Day{
    public Day18(){
        super(18);
    }
    ArrayList<Trench> map = new ArrayList<>();
    ArrayList<Point> points = new ArrayList<>();
    @Override
    public void run(){
        int x = 0, y = 0;
        int minX = 0, minY = 0, maxX = 0, maxY = 0;
        for(String line : input.split("\n")){
            String[] args = line.split(" ");
            Direction d = Direction.valueOf(args[0]);
            for(int i = 0; i<Integer.parseInt(args[1]); i++){
                map.add(new Trench(x+=d.x,y+=d.y, d));
                if(x<minX)minX = x;
                if(y<minY)minY = y;
                if(x>maxX)maxX = x;
                if(y>maxY)maxY = y;
            }
        }
        minX--;
        minY--;
        maxX++;
        maxY++;
        System.out.println(((maxX-minX+1)*(maxY-minY+1))-floodfill(minX,minY,minX,minY,maxX,maxY));
        
        map.clear();
        
        x = y = 0;
        ArrayList<Integer> xValues = new ArrayList<>();
        ArrayList<Integer> yValues = new ArrayList<>();
        for(String line : input.split("\n")){
            String[] args = line.split(" ");
            int dist = Integer.parseInt(args[2].substring(2, 7), 16);
            Direction d = Direction.values()[Integer.parseInt(args[2].substring(7, 8))];
            x+=dist*d.x;
            y+=dist*d.y;
            if(!xValues.contains(x))xValues.add(x);
            if(!yValues.contains(y))yValues.add(y);
            points.add(new Point(x, y));
        }
        Collections.sort(xValues);
        Collections.sort(yValues);
        for(int i = 0; i<=xValues.size(); i+=2)xValues.add(i, null);
        for(int i = 0; i<=yValues.size(); i+=2)yValues.add(i, null);
        for(int ix = 0; ix<xValues.size(); ix++){
            for(int iy = 0; iy<yValues.size(); iy++){
                Integer currentX = xValues.get(ix);
                Integer currentY = yValues.get(iy);
                long width = currentX==null?0:1;
                long height = currentY==null?0:1;
                if(width==0&&ix>0&&ix<xValues.size()-1){
                    width = xValues.get(ix+1)-xValues.get(ix-1)-1;
                }
                if(height==0&&iy>0&&iy<yValues.size()-1){
                    height = yValues.get(iy+1)-yValues.get(iy-1)-1;
                }
                map.add(new Trench(ix, iy, null, width*height));
            }
        }
        x = y = 0;
        for(Point p : points){
            if(p.x==x){
                int y1 = Math.min(p.y,y);
                int y2 = Math.max(p.y,y);
                for(int i = yValues.indexOf(y1); i<=yValues.indexOf(y2); i++){
                    getTrench(xValues.indexOf(x), i).d = Direction.D;//not actually that direction, it's just nonsense data
                }
            }
            if(p.y==y){
                int x1 = Math.min(p.x,x);
                int x2 = Math.max(p.x,x);
                for(int i = xValues.indexOf(x1); i<=xValues.indexOf(x2); i++){
                    getTrench(i, yValues.indexOf(y)).d = Direction.D;//not actually that direction, it's just nonsense data
                }
            }
            x = p.x;
            y = p.y;
        }
        long total = (xValues.get(xValues.size()-2)-xValues.get(1)+1L)*(yValues.get(yValues.size()-2)-yValues.get(1)+1L);
        System.out.println(total-floodfill(0,0,0,0,xValues.size(),yValues.size()) /* WHY DOES THIS WORK -> */ +xValues.size()+yValues.size()+1);
    }
    private long floodfill(int x, int y, int minX, int minY, int maxX, int maxY){
        long total = getTrench(x, y).area;
        ArrayList<Trench> last = new ArrayList<>();
        ArrayList<Trench> current = new ArrayList<>();
        current.add(getTrench(x, y));
        ArrayList<Trench> next;
        while(!(next = floodfill(last, current, minX, minY, maxX, maxY)).isEmpty()){
            for(Trench t : next)total+=t.area;
            last = current;
            current = next;
        }
        return total;
    }
    private ArrayList<Trench> floodfill(ArrayList<Trench> last, ArrayList<Trench> current, int minX, int minY, int maxX, int maxY){
        ArrayList<Trench> next = new ArrayList<>();
        for(Trench t : current){
            for(Direction d : Direction.values()){
                int X = t.x+d.x;
                int Y = t.y+d.y;
                if(X<minX||X>maxX||Y<minY||Y>maxY)continue;
                Trench adj = getTrench(X, Y);
                if(adj.d!=null)continue;
                if(last.contains(adj)||current.contains(adj)||next.contains(adj))continue;
                next.add(adj);
            }
        }
        return next;
    }
    public Trench getTrench(int x, int y){
        for(Trench t : map){
            if(t.x==x&&t.y==y)return t;
        }
        var t = new Trench(x, y, null);
        map.add(t);
        return t;
    }
    public class Trench{
        private final int x;
        private final int y;
        private Direction d;
        private final long area;
        public Trench(int x, int y, Direction d){
            this(x, y, d, 1);
        }
        public Trench(int x, int y, Direction d, long area){
            this.x = x;
            this.y = y;
            this.d = d;
            this.area = area;
        }
    }
    public enum Direction{
        R(1,0),
        D(0,1),
        L(-1,0),
        U(0,-1);
        private final int x;
        private final int y;
        private Direction(int dx, int dy){
            this.x = dx;
            this.y = dy;
        }
    }
    private static class Point{
        private final int x;
        private final int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}