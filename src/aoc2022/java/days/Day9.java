package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.HashSet;
public class Day9 extends Day{
    public Day9(){
        super(9);
    }
    @Override
    public void run(){
        int hx = 0, hy = 0;
        int tx = 0, ty = 0;
        HashSet<String> visited = new HashSet<>();
        visited.add(tx+","+ty);
        for(String s : input.split("\n")){
            char dir = s.charAt(0);
            int len = Integer.parseInt(s.substring(2));
            for(int i = 0; i<len; i++){
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
                hx+=dx;
                hy+=dy;
                int dist = Math.max(Math.abs(hx-tx),Math.abs(hy-ty));
                if(dist>1){//too far away! move closer!
                    boolean Y = hx==tx;
                    boolean X = hy==ty;
                    if(!(X||Y))X = Y = true;
                    if(X)tx+=Math.signum(hx-tx);
                    if(Y)ty+=Math.signum(hy-ty);
                }
                System.out.println(hx+" "+hy+"  "+tx+" "+ty);
                visited.add(tx+","+ty);
            }
        }
        System.out.println(visited.size());
    }
}