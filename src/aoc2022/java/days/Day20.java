package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.ArrayList;
public class Day20 extends Day{
    public Day20(){
        super(20);
    }
    @Override
    public void run(){
        ArrayList<IntContainer> ints = new ArrayList<>();
        for(String s : input.split("\n")){
            int i = Integer.parseInt(s);
            ints.add(new IntContainer(i));
        }
        ArrayList<IntContainer> ordered = new ArrayList<>(ints);
//        System.out.println(ordered.toString());
        int size = ordered.size();
        for(IntContainer ic : ints){
                int oldIdx = ordered.indexOf(ic);
                int newIdx = (int) (oldIdx+ic.i);
                while(newIdx>=size*2)newIdx-=size;
                while(newIdx<-size)newIdx+=size;
                while(newIdx>=size-1)newIdx-=(size-1);
                while(newIdx<=0)newIdx+=(size-1);
//                if(newIdx<oldIdx)newIdx++;
//                if(newIdx==-1)newIdx = size-1;
            ordered.add(newIdx, ordered.remove(oldIdx));
        }
        int zero = -1;
        for(IntContainer ic : ordered){
            if(ic.i==0){
                zero = ordered.indexOf(ic);
                break;
            }
        }
        int a = zero+1000;while(a>=ordered.size())a-=ordered.size();
        int b = zero+2000;while(b>=ordered.size())b-=ordered.size();
        int c = zero+3000;while(c>=ordered.size())c-=ordered.size();
        System.out.println(ordered.get(a).i+ordered.get(b).i+ordered.get(c).i);
        
        int key = 811589153;
        ints.forEach((t) -> {
            t.i*=key;
        });
        ordered = new ArrayList<>(ints);
        size = ordered.size();
        for(int i = 0; i<10; i++){
            for(IntContainer ic : ints){
                int oldIdx = ordered.indexOf(ic);
                long newIdx = oldIdx+ic.i;
                if(newIdx>=size-1){
                    long cycles = newIdx/(size-1);
                    newIdx-=(size-1)*(cycles-1);
                }
                while(newIdx>=size-1)newIdx-=(size-1);
                if(newIdx<=0){
                    long cycles = newIdx/(size-1);
                    newIdx+=(size-1)*(Math.abs(cycles)-1);
                }
                while(newIdx<=0)newIdx+=(size-1);
                ordered.add((int) newIdx, ordered.remove(oldIdx));
            }
        }
        zero = -1;
        for(IntContainer ic : ordered){
            if(ic.i==0){
                zero = ordered.indexOf(ic);
                break;
            }
        }
        a = zero+1000;while(a>=ordered.size())a-=ordered.size();
        b = zero+2000;while(b>=ordered.size())b-=ordered.size();
        c = zero+3000;while(c>=ordered.size())c-=ordered.size();
        System.out.println((long)ordered.get(a).i+ordered.get(b).i+ordered.get(c).i);
        
        
    }
    //literally just holds an int, but I need to keep track of it
    private static class IntContainer{
        private long i;
        public IntContainer(long i){
            this.i = i;
        }
        @Override
        public String toString(){
            return i+"";
        }
    }
}