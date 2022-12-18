package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.HashMap;
import java.util.HashSet;
public class Day18 extends Day{
    public Day18(){
        super(18);
    }
    public HashMap<Integer, HashMap<Integer, HashSet<Integer>>> blocks = new HashMap<>();
    @Override
    public void run(){
        for(String s : input.split("\n")){
            String[] coords = s.split(",");
            add(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(coords[2]));
        }
        long surface = 0;
        for(int x : blocks.keySet()){
            for(int y : blocks.get(x).keySet()){
                for(int z : blocks.get(x).get(y)){
                    if(!has(x,y,z+1))surface++;
                    if(!has(x,y,z-1))surface++;
                    if(!has(x,y+1,z))surface++;
                    if(!has(x,y-1,z))surface++;
                    if(!has(x+1,y,z))surface++;
                    if(!has(x-1,y,z))surface++;
                }
            }
        }
        System.out.println(surface);
    }
    public void add(int x, int y, int z){
        var lst = blocks.getOrDefault(x, new HashMap<>());
        if(!blocks.containsKey(x))blocks.put(x, lst);
        HashSet<Integer> lst2 = lst.getOrDefault(y, new HashSet<>());
        if(!lst.containsKey(y))lst.put(y, lst2);
        lst2.add(z);
    }
    public boolean has(int x, int y, int z){
        var lst = blocks.getOrDefault(x, new HashMap<>());
        HashSet<Integer> lst2 = lst.getOrDefault(y, new HashSet<>());
        return lst2.contains(z);
    }
}