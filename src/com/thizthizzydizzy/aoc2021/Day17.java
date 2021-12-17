package com.thizthizzydizzy.aoc2021;
import java.util.ArrayList;
public class Day17 implements Day{
    int tx1 = 56;
    int tx2 = 76;
    int ty1 = -162;
    int ty2 = -134;
    ArrayList<int[]> points;
    @Override
    public void run(){
        System.out.println("Part one");
        ArrayList<ArrayList<int[]>> successes = new ArrayList<>();
        int max = 0;
        int total = 0;
        for(int y = -1000; y<1000; y++){
            for(int x = -100; x<100; x++){
                int result = simulate(x,  y);
//                if(result>0)System.out.print("X");
//                else System.out.print(".");
                max = Math.max(max, result);
                if(result>Integer.MIN_VALUE){
                    total++;
                    successes.add(points);
                }
            }
//            System.out.println();
        }
//        for(var pts : successes){
//            int minx = 0, miny = 0, maxx = 0, maxy = 0;
//            for(int[] p : pts){
//                if(p[0]<minx)minx = p[0];
//                if(p[1]<miny)miny = p[1];
//                if(p[0]>maxx)maxx = p[0];
//                if(p[1]>maxy)maxy = p[1];
//            }
//            System.out.println();
//            for(int y = maxy; y>=miny; y--){
//                for(int x = minx; x<=maxx; x++){
//                    boolean has = false;
//                    for(int[] p : pts){
//                        if(p[0]==x&&p[1]==y){
//                            has = true;
//                            break;
//                        }
//                    }
//                    if(x==0&&y==0)System.out.print(0);
//                    else System.out.print(has?"#":(x>=tx1&&x<=tx2&&y>=ty1&&y<=ty2?"T":"."));
//                }
//                System.out.println();
//            }
//        }
        System.out.println(max);
        System.out.println("Part two");
        System.out.println(total);
    }
    private int simulate(int dx, int dy){
        points = new ArrayList<>();
        int maxY = 0;
        int x = 0, y = 0;
        for(int i = 0; i<1000; i++){
            x+=dx;
            y+=dy;
            if(dx!=0)dx-=Math.abs(dx)/dx;
            dy--;
            maxY = Math.max(y, maxY);
            points.add(new int[]{x,y});
            if(x>=tx1&&x<=tx2&&y>=ty1&&y<=ty2)return maxY;
            if(dy<ty1)return Integer.MIN_VALUE;
        }
        return Integer.MIN_VALUE;
    }
}