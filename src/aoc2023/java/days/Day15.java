package aoc2023.java.days;
import aoc2023.java.Day;
import java.util.ArrayList;
import java.util.Iterator;
public class Day15 extends Day{
    public Day15(){
        super(15);
    }
    @Override
    public void run(){
        String[] strs = input.replace("\n", "").split(",");
        long total = 0;
        for(String s : strs)total+=hash(s);
        System.out.println(total);
        Box[] boxes = new Box[256];
        for(int i = 0; i<256; i++)boxes[i] = new Box();
        STEPS:for(String step : strs){
            String label = step.split("[-=]")[0];
            Box box = boxes[hash(label)];
            if(step.contains("-")){
                for(Iterator<Lens> it = box.lenses.iterator(); it.hasNext();){
                    Lens lens = it.next();
                    if(lens.label.equals(label))it.remove();
                }
            }else{
                int focalLen = Integer.parseInt(step.substring(step.indexOf("=")+1));
                Lens lens = new Lens(label, focalLen);
                for(int i = 0; i<box.lenses.size(); i++){
                    if(box.lenses.get(i).label.equals(lens.label)){
                        box.lenses.set(i, lens);
                        continue STEPS;
                    }
                }
                box.lenses.add(lens);
            }
        }
        total = 0;
        for(int boxID = 0; boxID<256; boxID++){
            Box box = boxes[boxID];
            for(int lensID = 0; lensID<box.lenses.size(); lensID++){
                int power = (boxID+1)*(lensID+1)*box.lenses.get(lensID).focalLen;
                total+=power;
            }
        }
        System.out.println(total);
    }
    private int hash(String str){
        int current = 0;
        for(char c : str.toCharArray()){
            if(c=='\n')continue;
            int val = c;
            current+=val;
            current*=17;
            current%=256;
        }
        return current;
    }
    private static class Box{
        public ArrayList<Lens> lenses = new ArrayList<>();
    }
    private static class Lens{
        private final String label;
        private final int focalLen;
        public Lens(String label, int focalLen){
            this.label = label;
            this.focalLen = focalLen;
        }
    }
}