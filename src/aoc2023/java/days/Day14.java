package aoc2023.java.days;
import aoc2023.java.Day;
import java.util.ArrayList;
import java.util.Arrays;
public class Day14 extends Day{
    private int interval = -1;
    public Day14(){
        super(14);
    }
    @Override
    public void run(){
        char[][] map = unpack(input.split("\n"));
        tilt(map, 0, -1);
        System.out.println(load(map));
        //part 2
        map = unpack(input.split("\n"));
        for(int i = 0; i<1000000000; i++){
            cycle(map);
            if(interval>0)i+=Math.max(0, ((1000000000-i)/interval-1))*interval;
        }
        System.out.println(load(map));
    }
    private char[][] unpack(String[] split){
        char[][] arr = new char[split.length][];
        for(int i = 0; i<split.length; i++)arr[i] = split[i].toCharArray();
        return arr;
    }
    ArrayList<String> strings = new ArrayList<>();
    private void cycle(char[][] map){
        String s = Arrays.deepToString(map);
        interval = strings.lastIndexOf(s)-strings.indexOf(s);
        if(interval<=0)strings.add(s);
        tilt(map, 0, -1);
        tilt(map, -1, 0);
        tilt(map, 0, 1);
        tilt(map, 1, 0);
    }
    private void tilt(char[][] map, int dx, int dy){
        boolean change;
        do{
            change = false;
            for(int y = 0; y<map.length; y++){
                if(y==0&&dy<0)y++;
                if(y==map.length-1&&dy>0)continue;
                for(int x = 0; x<map[y].length; x++){
                    if(x==0&&dx<0)x++;
                    if(x==map[y].length-1&&dx>0)continue;
                    if(map[y][x]=='O'&&map[y+dy][x+dx]=='.'){
                        map[y+dy][x+dx] = map[y][x];
                        map[y][x] = '.';
                        change = true;
                    }
                }
            }
        }while(change);
    }
    private int load(char[][] map){
        int load = 0;
        for(int i = 0; i<map.length; i++){
            int rockLoad = map.length-i;
            for(char c : map[i])if(c=='O')load+=rockLoad;
        }
        return load;
    }
}