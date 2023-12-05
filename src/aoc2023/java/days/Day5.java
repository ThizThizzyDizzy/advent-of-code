package aoc2023.java.days;
import aoc2023.java.Day;
import java.util.ArrayList;
public class Day5 extends Day{
    public Day5(){
        super(5);
    }
    @Override
    public void run(){
        String[] sections = input.split("\n\n");
        ArrayList<Long> seeds = new ArrayList<>();
        ArrayList<Map> maps = new ArrayList<>();
        for(String seed : sections[0].split(":")[1].trim().split(" ")){
            seeds.add(Long.parseLong(seed));
        }
        for(int i = 1; i<sections.length; i++){
            Map map = new Map();
            String[] ranges = sections[i].split("\n");
            for(int j = 1; j<ranges.length; j++){
                String[] range = ranges[j].split(" ");
                map.ranges.add(new Range(Long.parseLong(range[0]), Long.parseLong(range[1]), Long.parseLong(range[2])));
            }
            maps.add(map);
        }
        Long[] is = seeds.toArray(Long[]::new);
        for(Map map : maps){
            for(int i = 0; i<is.length; i++)is[i] = map.map(is[i]).value;
        }
        long min = Long.MAX_VALUE;
        for(long i : is){
            if(i<min)min = i;
        }
        System.out.println(min);
        min = Long.MAX_VALUE;
        for(int i = 0; i<seeds.size(); i+=2){
            long start = seeds.get(i);
            long len = seeds.get(i+1);
            for(long l = start; l<start+len; l++){
                long num = l;
                long length = len;
                for(Map map : maps){
                    var result = map.map(num);
                    num = result.value;
                    length = Math.min(length, result.length);
                }
                l+=Math.max(0,length-1);
                if(num<min)min = num;
            }
        }
        System.out.println(min);
    }
    private static class Map{
        public ArrayList<Range> ranges = new ArrayList<>();
        public MapResult map(long i){
            for(Range range : ranges){
                MapResult result = range.map(i);
                if(result!=null)return result;
            }
            long end = Long.MAX_VALUE;
            for(Range r : ranges){
                if(r.src<i)continue;
                end = Math.min(end, r.src);
            }
            return new MapResult(i, end-i);
        }
    }
    private static class Range{
        private final long src;
        private final long dest;
        private final long len;
        public Range(long dest, long src, long len){
            this.src = src;
            this.dest = dest;
            this.len = len;
        }
        public boolean contains(long i){
            return map(i)!=null;
        }
        public MapResult map(long i){
            if(i<src||i>src+len)return null;
            return new MapResult(i-src+dest, len-(i-src));
        }
    }
    private static class MapResult{
        private final long value;
        private final long length;
        public MapResult(long value, long length){
            this.value = value;
            this.length = length;
        }
    }
}