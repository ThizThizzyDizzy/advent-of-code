package aoc2021;
import java.util.ArrayList;
public class Day6 implements Day{
    @Override
    public void run(){
        String input = "1,1,1,1,1,1,1,4,1,2,1,1,4,1,1,1,5,1,1,1,1,1,1,1,1,1,1,1,1,5,1,1,1,1,3,1,1,2,1,2,1,3,3,4,1,4,1,1,3,1,1,5,1,1,1,1,4,1,1,5,1,1,1,4,1,5,1,1,1,3,1,1,5,3,1,1,1,1,1,4,1,1,1,1,1,2,4,1,1,1,1,4,1,2,2,1,1,1,3,1,2,5,1,4,1,1,1,3,1,1,4,1,1,1,1,1,1,1,4,1,1,4,1,1,1,1,1,1,1,2,1,1,5,1,1,1,4,1,1,5,1,1,5,3,3,5,3,1,1,1,4,1,1,1,1,1,1,5,3,1,2,1,1,1,4,1,3,1,5,1,1,2,1,1,1,1,1,5,1,1,1,1,1,2,1,1,1,1,4,3,2,1,2,4,1,3,1,5,1,2,1,4,1,1,1,1,1,3,1,4,1,1,1,1,3,1,3,3,1,4,3,4,1,1,1,1,5,1,3,3,2,5,3,1,1,3,1,3,1,1,1,1,4,1,1,1,1,3,1,5,1,1,1,4,4,1,1,5,5,2,4,5,1,1,1,1,5,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,5,1,1,1,1,1,1,3,1,1,2,1,1";
        System.out.println("Part one");
        ArrayList<Integer> fish = new ArrayList<>();
        for(String s : input.split(","))fish.add(Integer.parseInt(s));
        for(int i = 0; i<80; i++){
            ArrayList<Integer> newFish = new ArrayList<>();
            for(int j = 0; j<fish.size(); j++){
                int f = fish.get(j);
                f--;
                if(f==-1){
                    f = 6;
                    newFish.add(8);
                }
                fish.set(j, f);
            }
            fish.addAll(newFish);
        }
        System.out.println(fish.size());
        System.out.println("Part two");
        long[] fishAges = new long[9];
        for(String s : input.split(","))fishAges[Integer.parseInt(s)]++;
        for(int i = 0; i<256; i++){
            long age0 = fishAges[0];
            long age1 = fishAges[1];
            long age2 = fishAges[2];
            long age3 = fishAges[3];
            long age4 = fishAges[4];
            long age5 = fishAges[5];
            long age6 = fishAges[6];
            long age7 = fishAges[7];
            long age8 = fishAges[8];
            fishAges = new long[]{age1,age2,age3,age4,age5,age6,age7+age0,age8,age0};
        }
        long total = 0;
        for(long i : fishAges)total+=i;
        System.out.println(total);
    }
}