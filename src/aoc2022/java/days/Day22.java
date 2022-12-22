package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.ArrayList;
public class Day22 extends Day{
    private char[][] map;
    private char[][] map2;
    private int panelSize;
    public Day22(){
        super(22);
    }
    int facing = 0;//right
    int x = 0, y = 0;
    @Override
    public void run(){
        {//part1
            String[] split = input.split("\n\n");
            String smap = split[0];
            String[] splitMap = smap.split("\n");
            map = new char[splitMap.length][];
            map2 = new char[splitMap.length][];
            panelSize = map.length/4;
            for(int y = 0; y<splitMap.length; y++){
                String line = splitMap[y];
                map[y] = new char[line.length()];
                map2[y] = new char[line.length()];
                for(int x = 0; x<line.length(); x++){
                    map[y][x] = line.charAt(x);
                    map2[y][x] = line.charAt(x);
                }
            }
            String instructions = split[1];
            ArrayList<Object> moves = new ArrayList<>();
            while(!instructions.isEmpty()){
                if(instructions.startsWith("R")||instructions.startsWith("L")){
                    moves.add(instructions.charAt(0));
                    instructions = instructions.substring(1);
                    continue;
                }
                String numS = "";
                int i = 0;
                while(i<instructions.length()&&Character.isDigit(instructions.charAt(i))){
                    numS+=instructions.charAt(i);
                    i++;
                }
                instructions = instructions.substring(i);
                moves.add(Integer.parseInt(numS));
            }
            while(map[y][x]==' ')x++;
            for(Object o : moves){
                if(o instanceof Character c){
                    if(c=='R')facing++;
                    if(c=='L')facing--;
                    if(facing>3)facing-=4;
                    if(facing<0)facing+=4;
                }
                if(o instanceof Integer I){
                    for(int i = 0; i<I; i++){
                        map2[y][x] = switch(facing){
                            case 0 -> '>';
                            case 1 -> 'v';
                            case 2 -> '<';
                            case 3 -> '^';
                            default -> 'x';
                        };
                        if(!move())break;
                    }
                }
            }
            System.out.println((x+1)*4+(y+1)*1000+facing);
        }
        x = y = facing = 0;
        {//part2
            String[] split = input.split("\n\n");
            String smap = split[0];
            String[] splitMap = smap.split("\n");
            map = new char[splitMap.length][];
            map2 = new char[splitMap.length][];
            for(int y = 0; y<splitMap.length; y++){
                String line = splitMap[y];
                map[y] = new char[line.length()];
                map2[y] = new char[line.length()];
                for(int x = 0; x<line.length(); x++){
                    map[y][x] = line.charAt(x);
                    map2[y][x] = line.charAt(x);
                }
            }
            String instructions = split[1];
            ArrayList<Object> moves = new ArrayList<>();
            while(!instructions.isEmpty()){
                if(instructions.startsWith("R")||instructions.startsWith("L")){
                    moves.add(instructions.charAt(0));
                    instructions = instructions.substring(1);
                    continue;
                }
                String numS = "";
                int i = 0;
                while(i<instructions.length()&&Character.isDigit(instructions.charAt(i))){
                    numS+=instructions.charAt(i);
                    i++;
                }
                instructions = instructions.substring(i);
                moves.add(Integer.parseInt(numS));
            }
            while(map[y][x]==' ')x++;
            for(Object o : moves){
                if(o instanceof Character c){
                    if(c=='R')facing++;
                    if(c=='L')facing--;
                    if(facing>3)facing-=4;
                    if(facing<0)facing+=4;
                }
                if(o instanceof Integer I){
                    for(int i = 0; i<I; i++){
                        if(!movep2())break;
                        map2[y][x] = switch(facing){
                            case 0 -> '>';
                            case 1 -> 'v';
                            case 2 -> '<';
                            case 3 -> '^';
                            default -> 'x';
                        };
                    }
                }
            }
            System.out.println((x+1)*4+(y+1)*1000+facing);
        }
    }
    public boolean move(){
        switch(facing){
            case 0:
                int X = getRight(x, y);
                if(X==-1)return false;
                else{
                    x = X;
                    return true;
                }
            case 1:
                int Y = getDown(x,y);
                if(Y==-1)return false;
                else{
                    y = Y;
                    return true;
                }
            case 2:
                X = getLeft(x, y);
                if(X==-1)return false;
                else{
                    x = X;
                    return true;
                }
            case 3:
                Y = getUp(x,y);
                if(Y==-1)return false;
                else{
                    y = Y;
                    return true;
                }
        }
        return false;
    }
    public boolean movep2(){
        int toX = x;
        int toY = y;
        int panelX = x/panelSize;
        int panelY = y/panelSize;
        int localX = x-(panelX*panelSize);
        int localY = y-(panelY*panelSize);
        int toFacing = facing;
        switch(facing){//hardcoded to my layout, cuz it's easier lel
            case 0://right
                toX++;
                if(toX>=map[toY].length||map[toY][toX]==' '){
                    int pos = localY;
                    switch(panelY){
                        case 0:
                            toFacing = 2;
                            toX = panelSize*2-1;
                            toY = panelSize*2+panelSize-pos-1;
                            break;
                        case 1:
                            toFacing = 3;
                            toX = panelSize*2+pos;
                            toY = panelSize-1;
                            break;
                        case 2:
                            toFacing = 2;
                            toX = panelSize*3-1;
                            toY = panelSize-pos-1;
                            break;
                        case 3:
                            toFacing = 3;
                            toX = panelSize+pos;
                            toY = panelSize*3-1;
                            break;
                    }
                    System.out.println(panelX+" "+panelY+" wrapR at "+localX+" "+localY+" ("+x+" "+y+")");
                }
                break;
            case 1://down
                toY++;
                if(toY>=map.length||map[toY].length<=toX||map[toY][toX]==' '){
                    int pos = localX;
                    switch(panelX){
                        case 0:
                            toX = panelSize*2+pos;
                            toY = 0;
                            break;
                        case 1:
                            toFacing = 2;
                            toX = panelSize-1;
                            toY = panelSize*3+pos;
                            break;
                        case 2:
                            toFacing = 2;
                            toX = panelSize*2-1;
                            toY = panelSize+pos;
                            break;
                    }
                    System.out.println(panelX+" "+panelY+" wrapD at "+localX+" "+localY+" ("+x+" "+y+")");
                }
                break;
            case 2://left
                toX--;
                if(toX<0||map[toY][toX]==' '){
                    int pos = localY;
                    switch(panelY){
                        case 0:
                            toX = 0;
                            toY = panelSize*3-pos-1;
                            toFacing = 0;
                            break;
                        case 1:
                            toX = pos;
                            toY = panelSize*2;
                            toFacing = 1;
                            break;
                        case 2:
                            toX = panelSize;
                            toY = panelSize-pos-1;
                            toFacing = 0;
                            break;
                        case 3:
                            toX = panelSize+pos;
                            toY = 0;
                            toFacing = 1;
                            break;
                    }
                    System.out.println(panelX+" "+panelY+" wrapL at "+localX+" "+localY+" ("+x+" "+y+")");
                }
                break;
            case 3://up
                toY--;
                if(toY<0||map[toY][toX]==' '){
                    int pos = localX;
                    switch(panelX){
                        case 0:
                            toX = panelSize;
                            toY = panelSize+pos;
                            toFacing = 0;
                            break;
                        case 1:
                            toX = 0;
                            toY = panelSize*3+pos;
                            toFacing = 0;
                            break;
                        case 2:
                            toX = pos;
                            toY = panelSize*4-1;
                            toFacing = 3;
                            break;
                    }
                    System.out.println(panelX+" "+panelY+" wrapU at "+localX+" "+localY+" ("+x+" "+y+")");
                }
                break;
        }
        if(map[toY][toX]=='#')return false;
        if(toFacing!=facing)printMap(map2);
        x = toX;
        y = toY;
        facing = toFacing;
        return true;
    }
    public int getLeft(int x, int y){
        if(x==0||map[y][x-1]==' '){
            if(map[y][map[y].length-1]=='#')return -1;
            return map[y].length-1;
        }else{
            char c = map[y][x-1];
            if(c=='#')return -1;
            return x-1;
        }
    }
    public int getRight(int x, int y){
        if(x==map[y].length-1){
            x = 0;
            while(map[y][x]==' ')x++;
            if(map[y][x]=='#')return -1;
            return x;
        }else{
            char c = map[y][x+1];
            if(c=='#')return -1;
            return x+1;
        }
    }
    public int getUp(int x, int y){
        if(y==0||map[y-1][x]==' '){
            y = map.length-1;
            while(map[y].length<=x)y--;
            if(map[y][x]=='#')return -1;
            return y;
        }else{
            char c = map[y-1][x];
            if(c=='#')return -1;
            return y-1;
        }
    }
    public int getDown(int x, int y){
        if(y==map.length-1||map[y+1].length<=x){
            y = 0;
            while(map[y][x]==' ')y++;
            if(map[y][x]=='#')return -1;
            return y;
        }else{
            char c = map[y+1][x];
            if(c=='#')return -1;
            return y+1;
        }
    }
    private void printMap(char[][] map2){
        for(char[] line : map2){
            for(char c : line)System.out.print(c);
            System.out.println();
        }
        for(int y = 0; y<map2.length; y++){
            for(int x = 0; x<map2[y].length; x++){
                map2[y][x]=map[y][x];
            }
        }
    }
}