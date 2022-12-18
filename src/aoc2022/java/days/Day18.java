package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.ArrayList;
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
        surface = 0;
        ArrayList<int[]> outside = toList(getBlocks(new int[]{minx-1,miny-1,minz-1}));
        for(int[] b : outside){
            int x = b[0];
            int y = b[1];
            int z = b[2];
            if(has(x,y,z+1))surface++;
            if(has(x,y,z-1))surface++;
            if(has(x,y+1,z))surface++;
            if(has(x,y-1,z))surface++;
            if(has(x+1,y,z))surface++;
            if(has(x-1,y,z))surface++;
        }
        System.out.println(surface);
    }
    public int minx = Integer.MAX_VALUE, miny = minx, minz = miny;
    public int maxx = Integer.MIN_VALUE, maxy = maxx, maxz = maxy;
    public void add(int x, int y, int z){
        var lst = blocks.getOrDefault(x, new HashMap<>());
        if(!blocks.containsKey(x))blocks.put(x, lst);
        HashSet<Integer> lst2 = lst.getOrDefault(y, new HashSet<>());
        if(!lst.containsKey(y))lst.put(y, lst2);
        lst2.add(z);
        if(x<minx)minx = x;
        if(y<miny)miny = y;
        if(z<minz)minz = z;
        if(x>maxx)maxx = x;
        if(y>maxy)maxy = y;
        if(z>maxz)maxz = z;
    }
    public boolean has(int x, int y, int z){
        var lst = blocks.getOrDefault(x, new HashMap<>());
        HashSet<Integer> lst2 = lst.getOrDefault(y, new HashSet<>());
        return lst2.contains(z);
    }
    private boolean contains(int x, int y, int z){
        if(x<minx-1)return false;
        if(y<miny-1)return false;
        if(z<minz-1)return false;
        if(x>maxx+1)return false;
        if(y>maxy+1)return false;
        if(z>maxz+1)return false;
        return true;
    }
    /**
     * Plannerator_YOINK
     */
    private HashMap<Integer, ArrayList<int[]>> getBlocks(int[] start){
        //layer zero
        HashMap<Integer, ArrayList<int[]>>results = new HashMap<>();
        ArrayList<int[]> zero = new ArrayList<>();
        zero.add(start);
        results.put(0, zero);
        //all the other layers
        int maxDistance = 1_000_000_000;//the algorithm requires a max search distance. Rather than changing that, I'll just be lazy and give it a big enough number
        for(int i = 0; i<maxDistance; i++){
            ArrayList<int[]> layer = new ArrayList<>();
            ArrayList<int[]> lastLayer = new ArrayList<>(results.get(i));
            if(i==0&&lastLayer.isEmpty()){
                lastLayer.add(start);
            }
            for(int[] block : lastLayer){
                FOR:for(int j = 0; j<6; j++){
                    int dx=0,dy=0,dz=0;
                    switch(j){//This is a primitive version of the Direction class used in other places here, but I'll just leave it as it is
                        case 0:
                            dx = -1;
                            break;
                        case 1:
                            dx = 1;
                            break;
                        case 2:
                            dy = -1;
                            break;
                        case 3:
                            dy = 1;
                            break;
                        case 4:
                            dz = -1;
                            break;
                        case 5:
                            dz = 1;
                            break;
                        default:
                            throw new IllegalArgumentException("How did this happen?");
                    }
                    if(!contains(block[0]+dx, block[1]+dy, block[2]+dz))continue;
                    int[] newBlock = new int[]{block[0]+dx,block[1]+dy,block[2]+dz};
                    if(has(newBlock[0], newBlock[1], newBlock[2]))continue;
                    for(int[] oldbl : lastLayer){//if(lastLayer.contains(newBlock))continue;//if the new block is on the same layer, ignore
                        if(oldbl[0]==newBlock[0]&&oldbl[1]==newBlock[1]&&oldbl[2]==newBlock[2]){
                            continue FOR;
                        }
                    }
                    if(i>0){
                        for(int[] oldbl : results.get(i-1)){//if(i>0&&results.get(i-1).contains(newBlock))continue;//if the new block is on the previous layer, ignore
                            if(oldbl[0]==newBlock[0]&&oldbl[1]==newBlock[1]&&oldbl[2]==newBlock[2]){
                                continue FOR;
                            }
                        }
                    }
                    for(int[] oldbl : layer){//if(layer.contains(newBlock))continue;//if the new block is on the next layer, but already processed, ignore
                        if(oldbl[0]==newBlock[0]&&oldbl[1]==newBlock[1]&&oldbl[2]==newBlock[2]){
                            continue FOR;
                        }
                    }
                    layer.add(newBlock);
                }
            }
            if(layer.isEmpty())break;
            results.put(i+1, layer);
        }
        return results;
    }
    private static ArrayList<int[]> toList(HashMap<Integer, ArrayList<int[]>> blocks){
        ArrayList<int[]> list = new ArrayList<>();
        for(int i : blocks.keySet()){
            list.addAll(blocks.get(i));
        }
        return list;
    }
}