package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.ArrayList;
public class Day17 extends Day{
    public Day17(){
        super(17);
    }
    public static Shape[] shapes = new Shape[]{
        new Shape("####"),
        new Shape("""
                  .#.
                  ###
                  .#."""),
        new Shape("""
                  ..#
                  ..#
                  ###"""),
        new Shape("""
                  #
                  #
                  #
                  #"""),
        new Shape("""
                  ##
                  ##""")
    };
    public static ArrayList<boolean[]> stack = new ArrayList<>();
    public static int width = 7;
    @Override
    public void run(){
        int shapeIndex = 0;
        int airIndex = 0;
        int rockX = 0, rockY = 0;
        Shape rock = null;
        int rocks = 0;
        while(rocks<2022){
            if(rock==null){
                rock = shapes[shapeIndex];
                rockX = 2;
                rockY = stack.size()+rock.h+2;
                shapeIndex++;
                if(shapeIndex==shapes.length)shapeIndex = 0;
            }
            boolean right = input.charAt(airIndex)=='>';
            airIndex++;
            if(airIndex>=input.length())airIndex = 0;
            if(right){
                boolean pass = true;
                for(int Y = 0; Y<rock.h; Y++){
                    int x = rockX+rock.rightChecks[Y];
                    int y = rockY-Y;
                    if(x>=width||get(x,y)){
                        pass = false;
                        break;
                    }
                }
                if(pass){
                    rockX++;
                }
            }else{
                boolean pass = true;
                for(int Y = 0; Y<rock.h; Y++){
                    int x = rockX+rock.leftChecks[Y];
                    int y = rockY-Y;
                    if(x<0||get(x,y)){
                        pass = false;
                        break;
                    }
                }
                if(pass){
                    rockX--;
                }
            }
            boolean pass = true;
            for(int X = 0; X<rock.w; X++){
                int y = rockY-rock.downChecks[X];
                int x = rockX+X;
                if(get(x,y)){
                    pass = false;
                    break;
                }
            }
            if(pass){
                rockY--;
            }else{
                settle(rock, rockX, rockY);
                rocks++;
                rock = null;
            }
        }
        System.out.println(stack.size());
    }
    private boolean get(int x, int y){
        if(x>=width||x<0)return true;
        if(y<0)return true;
        if(stack.size()<=y)return false;
        return stack.get(y)[x];
    }
    private void settle(Shape rock, int rockX, int rockY){
        for(int y = 0; y<rock.h; y++){
            int Y = rockY-y;
            while(stack.size()<=Y)stack.add(new boolean[width]);
            boolean[] layer = stack.get(Y);
            for(int X = 0; X<rock.w; X++){
                if(!rock.shape[X][y])continue;
                int x = X+rockX;
                if(layer[x])throw new IllegalStateException("Somethin' went very wrong!");
                layer[x] = true;
            }
        }
//        printStack();
    }
    private void printStack(){
        for(int i = stack.size()-1; i>=0; i--){
            for(boolean b : stack.get(i)){
                System.out.print(b?'#':'.');
            }
            System.out.println();
        }
        System.out.println();
    }
    private static class Shape {
        int w, h;
        boolean[][] shape;
        int[] rightChecks, leftChecks, downChecks;
        public Shape(String pattern){
            String[] strs = pattern.split("\n");
            w = strs[0].length();
            h = strs.length;
            shape = new boolean[w][h];
            for(int y = 0; y<strs.length; y++){
                for(int x = 0; x<strs[y].length(); x++){
                    shape[x][y] = strs[y].charAt(x)=='#';
                }
            }
            rightChecks = new int[h];
            leftChecks = new int[h];
            downChecks = new int[w];
            for(int x = 0; x<w; x++){
                int Y = 0;
                for(int y = 0; y<h; y++){
                    if(shape[x][y])Y = y;
                }
                downChecks[x] = Y+1;
            }
            for(int y = 0; y<h; y++){
                int r = 0;
                int l = -1;
                for(int x = 0; x<w; x++){
                    if(shape[x][y]&&l==-1)l = x;
                    if(shape[x][y])r = x;
                }
                leftChecks[y] = l-1;
                rightChecks[y] = r+1;
            }
        }
    }
}