package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.HashSet;
public class Day9 extends Day{
    public Day9(){
        super(9);
    }
    @Override
    public void run(){
        sim(2);
        sim(10);
    }
    public void sim(int len){
        int[] rx = new int[len];
        int[] ry = new int[len];
        HashSet<String> visited = new HashSet<>();
        visited.add(rx[len-1]+","+ry[len-1]);
        for(String s : input.split("\n")){
            char dir = s.charAt(0);
            int dist = Integer.parseInt(s.substring(2));
            for(int i = 0; i<dist; i++){
                int dx = switch(dir){
                    case 'L' -> -1;
                    case 'R' -> 1;
                    default -> 0;
                };
                int dy = switch(dir){
                    case 'U' -> -1;
                    case 'D' -> 1;
                    default -> 0;
                };
                rx[0]+=dx;
                ry[0]+=dy;
                for(int j = 1; j<len; j++){
                    int hx = rx[j-1];
                    int hy = ry[j-1];
                    int tx = rx[j];
                    int ty = ry[j];
                    int dst = Math.max(Math.abs(hx-tx),Math.abs(hy-ty));
                    if(dst>1){//too far away! move closer!
                        boolean Y = hx==tx;
                        boolean X = hy==ty;
                        if(!(X||Y))X = Y = true;
                        if(X)tx+=Math.signum(hx-tx);
                        if(Y)ty+=Math.signum(hy-ty);
                        rx[j] = tx;
                        ry[j] = ty;
                    }
                }
                visited.add(rx[len-1]+","+ry[len-1]);
            }
        }
        System.out.println(visited.size());
    }
}