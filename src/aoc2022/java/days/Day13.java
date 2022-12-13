package aoc2022.java.days;
import aoc2022.java.Day;
import aoc2022.java.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class Day13 extends Day{
    public Day13(){
        super(13);
    }
    @Override
    public void run(){
        int i = 0;
        int out = 0;
        for(String s : input.split("\n\n")){
            i++;
            String[] packs = s.split("\n");
            if(compare(parse(packs[0]), parse(packs[1]))>=0){
                System.out.println(i);
                out+=i;
            }
        }
        System.out.println(out);
        ArrayList<String> packets = new ArrayList<>(Arrays.asList(input.replace("\n\n", "\n").split("\n")));
        packets.add("[[2]]");
        packets.add("[[6]]");
        Collections.sort(packets, (o1, o2) -> {
            return -compare(parse(o1), parse(o2));
        });
        out = 1;
        i = 0;
        for(String packet : packets){
            i++;
            if("[[2]]".equals(packet)||"[[6]]".equals(packet)){
                out*=i;
            }
        }
        System.out.println(out);
    }
    public ArrayList<ArrayList> parse(String s){
        Stack<ArrayList<ArrayList>> stack = new Stack<>();
        String num = "";
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num+=c;
                continue;
            }else if(!num.isEmpty()){
                ArrayList<Integer> intlist = new ArrayList<Integer>(Arrays.asList(Integer.parseInt(num)));
                stack.peek().add(intlist);
                num = "";
            }
            if(c==',')continue;
            if(c=='['){
                stack.push(new ArrayList<>());
            }else if(c==']'){
                var v = stack.pop();
                if(stack.isEmpty()){
                    return v;
                }
                stack.peek().add(v);
            }else throw new IllegalArgumentException("bad char: "+c);
        }
        return null;
    }
    private int compare(Object o1, Object o2) {
        if(o1 instanceof Integer i1&&o2 instanceof Integer i2)return i2-i1;
        if(o1 instanceof Integer i)return compare(new ArrayList<>(Arrays.asList(i)), (ArrayList)o2);
        if(o2 instanceof Integer i)return compare((ArrayList)o1, new ArrayList<>(Arrays.asList(i)));
        ArrayList arr1 = (ArrayList)o1;
        ArrayList arr2 = (ArrayList)o2;
        for(int i = 0; i<Math.min(arr1.size(), arr2.size()); i++){
            int c = compare(arr1.get(i), arr2.get(i));
            if(c!=0)return c;
        }
        return arr2.size()-arr1.size();
    }
}