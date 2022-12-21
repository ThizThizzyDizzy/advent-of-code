package aoc2022.java.days;
import aoc2022.java.Day;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
public class Day21 extends Day{
    public Day21(){
        super(21);
    }
    @Override
    public void run(){
        {
            ArrayList<Monkey> monkeys = new ArrayList<>();
            HashMap<String, Monkey> map = new HashMap<>();
            for(String s : input.split("\n")){
                String name = s.substring(0, 4);
                String op = s.substring(6);
                var monkey = new Monkey(name, op);
                monkeys.add(monkey);
                map.put(name, monkey);
            }
            for(Monkey m : monkeys){
                m.m1 = map.get(m.in1);
                m.m2 = map.get(m.in2);
            }
            boolean changed;
            do{
                changed = false;
                for(Monkey m : monkeys){
                    changed |= m.calc();
                }
            }while(changed);
            System.out.println(map.get("root").value);
        }
        //part 2
        boolean growing = true;
        long i = 1;
        long range = 0;
        while(true){
            ArrayList<Monkey> monkeys = new ArrayList<>();
            HashMap<String, Monkey> map = new HashMap<>();
            for(String s : input.split("\n")){
                String name = s.substring(0, 4);
                String op = s.substring(6);
                var monkey = new Monkey(name, op);
                monkeys.add(monkey);
                map.put(name, monkey);
            }
            for(Monkey m : monkeys){
                m.m1 = map.get(m.in1);
                m.m2 = map.get(m.in2);
            }
            map.get("humn").value = BigInteger.valueOf(i);
            boolean changed;
            do{
                changed = false;
                for(Monkey m : monkeys){
                    changed |= m.calc();
                }
            }while(changed);
            long v1 = map.get("root").m1.value.longValueExact();
            long v2 = map.get("root").m2.value.longValueExact();
            if(v1==v2){
                break;
            }else{
                System.out.println(i+": "+v1+" != "+v2);
            }
            if(v1<v2){
                growing = false;
                range = i/2;
            }
            if(growing){
                i*=2;
            }else{
                if(v1>v2){
                    i+=range/2;
                    range = Math.max(2, range/2);
                }else{
                    i-=range/2;
                    range = Math.max(2, range/2);
                }
            }
        }
        //part 2
        growing = true;
        i -= 1000;
        boolean foundAnswer = false;
        while(true){
            ArrayList<Monkey> monkeys = new ArrayList<>();
            HashMap<String, Monkey> map = new HashMap<>();
            for(String s : input.split("\n")){
                String name = s.substring(0, 4);
                String op = s.substring(6);
                var monkey = new Monkey(name, op);
                monkeys.add(monkey);
                map.put(name, monkey);
            }
            for(Monkey m : monkeys){
                m.m1 = map.get(m.in1);
                m.m2 = map.get(m.in2);
            }
            map.get("humn").value = BigInteger.valueOf(i);
            boolean changed;
            do{
                changed = false;
                for(Monkey m : monkeys){
                    changed |= m.calc();
                }
            }while(changed);
            long v1 = map.get("root").m1.value.longValueExact();
            long v2 = map.get("root").m2.value.longValueExact();
            if(v1==v2){
                System.out.println(i+" IS A VALID ANSWER");
                foundAnswer = true;
            }else{
                if(foundAnswer){
                    System.out.println("AoC accepted the first answer, but not the last... curious");
                    break;
                }
                System.out.println(i+": "+v1+" != "+v2);
            }
            i++;
        }
    }
    private static class Monkey{
        private final String name;
        private BigInteger value = null;
        private String in1 = null;
        private String in2 = null;
        private Monkey m1 = null;
        private Monkey m2 = null;
        private Operation op = null;
        public Monkey(String name, String op){
            this.name = name;
            String[] strs = op.split(" ");
            if(strs.length==3){
                in1 = strs[0];
                this.op = Operation.get(op.charAt(5));
                in2 = strs[2];
            }else value = BigInteger.valueOf(Long.parseLong(op));
        }
        public boolean calc(){
            if(value==null){
                if(m1.value!=null&&m2.value!=null){
                    value = op.calc(m1.value, m2.value);
                    return true;
                }else return false;
            }
            return false;
        }
    }
    private static enum Operation{
        ADD('+'),
        SUB('-'),
        MUL('*'),
        DIV('/');
        private final char c;
        private Operation(char c){
            this.c = c;
        }
        public static Operation get(char ch){
            for(Operation op : values()){
                if(op.c==ch)return op;
            }
            return null;
        }
        public BigInteger calc(BigInteger in1, BigInteger in2){
            return switch(this){
                case ADD -> in1.add(in2);
                case SUB -> in1.subtract(in2);
                case MUL -> in1.multiply(in2);
                case DIV -> in1.divide(in2);
            };
        }
    }
}