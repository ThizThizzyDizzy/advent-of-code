package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.ArrayList;
import java.util.HashSet;
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
    public static long stackExtraHeight = 0;
    @Override
    public void run(){
        int shapeIndex = 0;
        int airIndex = 0;
        int rockX = 0, rockY = 0;
        Shape rock = null;
        long rocks = 0;
        long time = System.nanoTime();
        int rockSteps = 0;
        ArrayList<Integer> pattern = new ArrayList<>();
        ArrayList<String> stackPattern = new ArrayList<>();
        ArrayList<Integer> rocksPattern = new ArrayList<>();
        ArrayList<Integer> yPattern = new ArrayList<>();
        ArrayList<String> totalPattern = new ArrayList<>();
        int rocksSinceLast = 0;
        int buffer = 5;
        int buffer2 = 10;
        boolean skipDone = false;
        boolean skipDone2 = false;
        boolean skipnotdone2 = false;
        long skipRocks = 0, skipHeight = 0;
        long startRocks = 0;
        int skipidx = 0;
        long lastRox = 0, lastHeight = 0;
        while(rocks<1000000000000l){
            if(rock==null){
                rock = shapes[shapeIndex];
                rockX = 2;
                rockY = stack.size()+rock.h+2;
                shapeIndex++;
                rocksSinceLast++;
                if(shapeIndex==shapes.length)shapeIndex = 0;
                rockSteps = 0;
            }
            boolean right = input.charAt(airIndex)=='>';
            airIndex++;
            if(airIndex>=input.length()){
                if(buffer>0)buffer--;
                int size = stack.size();
                optimizeStack();
//                System.out.println(size-stack.size()+" optimized!");
                rockY-=(size-stack.size());
                if(buffer<=0){
                    int siz = size-stack.size();
                    if(pattern.contains(siz)&&rocksPattern.contains(rocksSinceLast)&&!skipDone){
                        int patLoop = loopSize(pattern);
                        int rpatLoop = loopSize(rocksPattern);
                        int yLoop = loopSize(yPattern);
//                        System.out.println(patLoop+" "+rpatLoop+" "+yLoop);
                        if(patLoop>0&&rpatLoop>0&&patLoop==rpatLoop){//might not always be equal but it was true for me so whatever
                            skipDone = true;
                            int totalHeight = 0;
                            int totalRocks = 0;
                            for(int i = 0; i<patLoop; i++)totalHeight+=pattern.get(i);
                            for(int i = 0; i<patLoop; i++)totalRocks+=rocksPattern.get(i);
                            totalHeight*=patLoop;
                            totalRocks*=patLoop;
//                            System.out.println(totalRocks);
                            long skipSteps = (1000000000000l-rocks)/totalRocks-1;
//                            rocks+=skipSteps*totalRocks;
//                            stackExtraHeight+=skipSteps*totalHeight;
                            startRocks = rocks;
                            skipRocks = totalRocks;
                            skipHeight = totalHeight;
                            stackPattern.add(printStack());
                        }
                    }
                    buffer2--;
                    if(buffer2<=0){
//                        totalPattern.add(airIndex+" "+rockX+" "+rockY+" "+shapeIndex+" "+rockSteps+" "+(size-stack.size())+" "+rocksSinceLast+" "+printStack().hashCode()+" "+printStack().replace("\n", ""));
//                        System.out.println("PAT "+loopSizeS(totalPattern)+" "+airIndex+" "+rockX+" "+rockY+" "+shapeIndex+" "+rockSteps+" "+(size-stack.size())+" "+rocksSinceLast+" "+printStack().hashCode()+" "+printStack().replace("\n", ""));
                    }
//                    System.out.println("AA"+rocks+" "+(stack.size()+stackExtraHeight)+" "+airIndex+" "+rockX+" "+rockY+" "+shapeIndex+" "+rockSteps+" "+(size-stack.size())+" "+rocksSinceLast+" "+printStack().hashCode()+" "+printStack().replace("\n", ""));
                    pattern.add(siz);
                    rocksPattern.add(rocksSinceLast);
                    yPattern.add(rockY);
                    if(skipRocks>0){
                        skipidx++;
//                        if(skipidx%10==0)System.out.println(rocks+" "+(stack.size()+stackExtraHeight)+" "+airIndex+" "+rockX+" "+rockY+" "+shapeIndex+" "+rockSteps+" "+(size-stack.size())+" "+rocksSinceLast+" "+printStack().hashCode()+" "+printStack().replace("\n", ""));
                        if(skipidx%10==0){
                            long lastR = rocks-lastRox;
                            long lastH = stackExtraHeight+stack.size()-lastHeight;
                            System.out.println(rocks+" "+(stack.size()+stackExtraHeight)+" can skip "+skipRocks+" for "+skipHeight+", last "+lastR+" for "+lastH);
                            long skipSteps = (1000000000000l-rocks)/lastR-2;
//                            skipSteps = 0;
                            if(skipnotdone2&&!skipDone2&&buffer2<=0){
                                skipDone2 = true;
                                rocks+=skipSteps*lastR;
                                stackExtraHeight+=skipSteps*lastH;
                                System.out.println(rocks+" "+(stack.size()+stackExtraHeight)+" skipped "+skipSteps);
                            }
                            skipnotdone2 = true;
                            lastRox = rocks;
                            lastHeight = stackExtraHeight+stack.size();
                        }
                    }
                    rocksSinceLast = 0;
                }
                airIndex = 0;
            }
            if(skipRocks!=0&&(rocks-startRocks)%skipRocks==0){
//                System.out.println("X"+rockX+" "+rockY+" "+shapeIndex+" "+rockSteps+" "+(stack.size())+" "+rocksSinceLast+" "+printStack().hashCode()+" "+printStack().replace("\n", ""));
            }
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
            rockSteps++;
            if(pass){
                rockY--;
            }else{
                settle(rock, rockX, rockY);
                rocks++;
                if(rocks==2022){
                    System.out.println(stack.size()+stackExtraHeight);
//                    System.exit(0);
                }
                rock = null;
                if(rocks%100000000==0){
                    System.out.println(rocks+": "+(System.nanoTime()-time)/1_000_000+"ms");
                    long preopt = System.nanoTime();
                    optimizeStack();
                    System.out.println("opt: "+(System.nanoTime()-preopt)/1_000_000+"ms");
                }
            }
        }
        System.out.println(stack.size()+stackExtraHeight);
//        System.out.println(printStack());
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
    }
    private String printStack(){
        String s = "";
        for(int i = stack.size()-1; i>=0; i--){
            for(boolean b : stack.get(i)){
                s+=b?'#':'.';
            }
            s+="\n";
        }
        return s;
    }
    private void optimizeStack(){
//        System.out.println("preop "+(stack.size()+stackExtraHeight)+" "+printStack().replace("\n", ""));
        ArrayList<boolean[]> newStack = new ArrayList<>();
        FOR:for(int y = stack.size()-1; y>=0; y--){
            boolean[] layer = stack.get(y);
            for(var b : layer){
                if(!b)continue FOR;
            }
            for(int i = y; i<stack.size(); i++){
                newStack.add(stack.get(i));
            }
            stackExtraHeight+=stack.size()-newStack.size();
            stack = newStack;
            break;
        }
//        System.out.println("postop"+(stack.size()+stackExtraHeight)+" "+printStack().replace("\n", ""));
    }
    private int loopSizeS(ArrayList<String> pattern){
        LP:for(int loopSiz = 1; loopSiz<pattern.size(); loopSiz++){
            String first = pattern.get(loopSiz);
            int loops = 0;
            for(int off = 0; off<pattern.size()-loopSiz; off+=loopSiz){
                if(!pattern.get(loopSiz+off).equals(first)){
                    continue LP;
                }
                loops++;
            }
            if(loops>5)return loopSiz;
        }
        return 0;
    }
    private int loopSize(ArrayList<Integer> pattern){
        LP:for(int loopSiz = 1; loopSiz<pattern.size(); loopSiz++){
            int first = pattern.get(loopSiz);
            int loops = 0;
            for(int off = 0; off<pattern.size()-loopSiz; off+=loopSiz){
                if(pattern.get(loopSiz+off)!=first){
                    continue LP;
                }
                loops++;
            }
            if(loops>5)return loopSiz;
        }
        return 0;
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