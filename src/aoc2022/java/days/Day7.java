package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.HashMap;
public class Day7 extends Day{
    public Dir dir;
    public Dir files = new Dir(null);
    public Day7(){
        super(7);
    }
    @Override
    public void run() {
        for(String command : input.split("\n")){
            if(command.startsWith("$")){
                if(command.equals("$ cd /")){
                    dir = files;
                }else if(command.equals("$ cd ..")){
                    dir = dir.parent;
                }else if(command.startsWith("$ cd ")){
                    dir = dir.dirs.get(command.substring(5));
                }
            }else{
                if(command.startsWith("dir"))dir.dirs.put(command.substring(4), new Dir(dir));
                else{
                    String[] fil = command.split(" ");
                    dir.files.put(fil[1], Integer.parseInt(fil[0]));
                }
            }
        }
        files.calculateSize();
        System.out.println(files.sumTotal(100000));
    }
    private static class Dir {
        public HashMap<String, Dir> dirs = new HashMap<>();
        public HashMap<String, Integer> files = new HashMap<>();
        private final Dir parent;
        private long size = 0;
        public Dir(Dir parent){
            this.parent = parent;
        }
        private long calculateSize(){
            for(Dir dir : dirs.values())size+=dir.calculateSize();
            for(int i : files.values())size+=i;
            return size;
        }
        private long sumTotal(long max){
            long sumTotal = 0;
            for(Dir dir : dirs.values())sumTotal+=dir.sumTotal(max);
            if(size<=max)sumTotal+=size;
            return sumTotal;
        }
    }
}