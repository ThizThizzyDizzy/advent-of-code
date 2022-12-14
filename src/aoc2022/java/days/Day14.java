package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.HashMap;
import java.util.function.BiConsumer;
public class Day14 extends Day{
    public Day14(){
        super(14);
    }
    HashMap<Integer, HashMap<Integer, Character>> map = new HashMap<>();
    int xmin = Integer.MAX_VALUE, xmax = Integer.MIN_VALUE, ymin = Integer.MAX_VALUE, ymax = Integer.MIN_VALUE;
    @Override
    public void run(){
        for(String s : input.split("\n")){
            String[] points = s.split(" -> ");
            int[] last = null;
            for(int i = 0; i<points.length; i++){
                String[] pt = points[i].split(",");
                int[] point = new int[]{Integer.parseInt(pt[0]), Integer.parseInt(pt[1])};
                if(point[0]<xmin)xmin = point[0];
                if(point[0]>xmax)xmax = point[0];
                if(point[1]<ymin)ymin = point[1];
                if(point[1]>ymax)ymax = point[1];
                if(i>0){
                    forLine(last[0], last[1], point[0], point[1], (x,y)->{
                        set(x,y,'#');
                    });
                }
                last = point;
            }
        }
//        printMap();
        int sand = 0;
        while(dropSand(500, 0))sand++;
//        printMap();
        System.out.println(sand);
    }
    public void forLine(int x1, int y1, int x2, int y2, BiConsumer<Integer, Integer> func){
        int dx = x2-x1;
        int dy = y2-y1;
        int d = Math.max(Math.abs(dx), Math.abs(dy));
        if(dx!=0)dx=dx/Math.abs(dx);
        if(dy!=0)dy=dy/Math.abs(dy);
        for(int i = 0; i<=d; i++){
            func.accept(x1+dx*i, y1+dy*i);
        }
    }
    public char get(int x, int y){
        if(x<xmin||x>xmax||y>ymax)return ' ';
        return map.getOrDefault(x, new HashMap<>()).getOrDefault(y, '.');
    }
    public void set(int x, int y, char c){
        var xMap = map.get(x);
        if(xMap==null){
            xMap = new HashMap<>();
            map.put(x, xMap);
        }
        xMap.put(y, c);
    }
    private boolean dropSand(int x, int y){
        while(true){
            y = raycastDown(x,y);//snap to bottom
            if(get(x,y+1)==' ')return false;
            if(get(x-1,y+1)==' ')return false;
            if(get(x+1,y+1)==' ')return false;
            if(get(x-1,y+1)=='.'){
                x--;
                y++;
                continue;
            }
            if(get(x+1,y+1)=='.'){
                x++;
                y++;
                continue;
            }
            break;
        }
        if(get(x,y)=='.'){
            set(x, y, 'o');
            return true;
        }
        return false;
    }
    private int raycastDown(int x, int y){
        while(get(x, y+1)=='.')y++;
        return y;
    }

    private void printMap() {
        for(int y = Math.min(0, ymin); y<=ymax; y++){
            for(int x = xmin; x<=xmax; x++){
                if(x==500&&y==0)System.out.print('+');
                else{
                    System.out.print(get(x,y));
                }
            }
            System.out.println();
        }
    }
}