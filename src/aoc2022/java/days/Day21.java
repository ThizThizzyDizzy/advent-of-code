package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.ArrayList;
import java.util.HashMap;
public class Day21 extends Day{
    public Day21(){
        super(21);
    }
    public ArrayList<Monkey> monkeys = new ArrayList<>();
    public HashMap<String, Monkey> map = new HashMap<>();
    @Override
    public void run(){
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
        boolean changed = false;
        do{
            changed = false;
            for(Monkey m : monkeys){
                changed |= m.calc();
            }
        }while(changed);
        System.out.println(map.get("root").value);
    }
    private static class Monkey{
        private final String name;
        private Long value = null;
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
            }else value = Long.parseLong(op);
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
        public long calc(long in1, long in2){
            return switch(this){
                case ADD -> in1+in2;
                case SUB -> in1-in2;
                case MUL -> in1*in2;
                case DIV -> in1/in2;
            };
        }
    }
}