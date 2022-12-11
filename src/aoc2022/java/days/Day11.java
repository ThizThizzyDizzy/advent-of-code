package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.ArrayList;
import java.util.Collections;
public class Day11 extends Day{
    public Day11(){
        super(11);
    }
    static ArrayList<Monkey> monkeys = new ArrayList<>();
    static boolean part2 = false;
    private static int divs;
    @Override
    public void run(){
        calc(20);
        part2 = true;
        calc(10000);
    }
    public void calc(int rounds){
        monkeys.clear();
        String[] monkeysS = input.split("\n\n");
        for(String monkeyS : monkeysS){
            String[] monka = monkeyS.split("\n");
            Monkey monkey = new Monkey();
            String starting = monka[1].substring("  Starting items: ".length());
            for(String s : starting.split(" ")){
                monkey.items.add((long)Integer.parseInt(s.replace(",", "")));
            }
            if(monka[2].contains("+"))monkey.op = 0;
            if(monka[2].contains("*"))monkey.op = 1;
            if(monka[2].contains("old * old"))monkey.op = 2;
            if(monkey.op<2){
                monkey.param = Integer.parseInt(monka[2].substring("  Operation: new = old + ".length()));
            }
            monkey.divTest = Integer.parseInt(monka[3].substring("  Test: divisible by ".length()));
            monkey.trueMonkey = Integer.parseInt(monka[4].substring("    If true: throw to monkey ".length()));
            monkey.falseMonkey = Integer.parseInt(monka[5].substring("    If false: throw to monkey ".length()));
            monkeys.add(monkey);
        }
        int divs = 1;
        for(Monkey monkey : monkeys)divs*=monkey.divTest;
        this.divs = divs;
        for(int i = 1; i<=rounds; i++){
            for(Monkey monkey : monkeys){
                monkey.takeTurn();
            }
            if(i%1000==0||i==1||i==20){
//                for(Monkey monkey : monkeys)System.out.println(i+" "+monkey.totalInspections);
            }
        }
        Collections.sort(monkeys, (o1, o2) -> {
            if(o2.totalInspections>o1.totalInspections)return 1;
            if(o2.totalInspections<o1.totalInspections)return -1;
            return 0;
        });
        System.out.println(monkeys.get(0).totalInspections*monkeys.get(1).totalInspections);
    }
    private static class Monkey{
        private ArrayList<Long> items = new ArrayList<>();
        private int divTest;
        private int op, param;
        private int trueMonkey, falseMonkey;
        private long totalInspections = 0;
        public void takeTurn(){
            while(!items.isEmpty()){
                long i = items.remove(0);
                totalInspections++;
                switch(op){
                    case 0:
                        i+=param;
                        break;
                    case 1:
                        i*=param;
                        break;
                    case 2:
                        i*=i;
                        break;
                }
                if(i<0)throw new IllegalArgumentException(i+"");
                if(!part2)i/=3;
                i%=divs;
                if(i%divTest==0){
                    monkeys.get(trueMonkey).items.add(i);
                }else monkeys.get(falseMonkey).items.add(i);
            }
        }
    }
}