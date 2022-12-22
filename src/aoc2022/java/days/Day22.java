package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.ArrayList;
public class Day22 extends Day{
    private char[][] map;
    private char[][] map2;
    public Day22(){
        super(22);
    }
    int facing = 0;//right
    int x = 0, y = 0;
    @Override
    public void run(){
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
                    if(!move())break;
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
        printMap(map2);
        System.out.println(x+" "+y);
        System.out.println((x+1)*4+(y+1)*1000+facing);
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
    }
}