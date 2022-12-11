package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.ArrayList;
import java.util.Collections;
public class Day11 extends Day{
    public Day11(){
        super(11);
    }
    static ArrayList<Monkey> monkeys = new ArrayList<>();
    @Override
    public void run(){
        String[] monkeysS = input.split("\n\n");
        for(String monkeyS : monkeysS){
            String[] monka = monkeyS.split("\n");
            Monkey monkey = new Monkey();
            String starting = monka[1].substring("  Starting items: ".length());
            for(String s : starting.split(" ")){
                monkey.items.add(Integer.parseInt(s.replace(",", "")));
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
        for(int i = 0; i<20; i++){
            for(Monkey monkey : monkeys){
                monkey.takeTurn();
            }
        }
        Collections.sort(monkeys, (o1, o2) -> {
            return o2.totalInspections-o1.totalInspections;
        });
        System.out.println(monkeys.get(0).totalInspections*monkeys.get(1).totalInspections);
    }
    private static class Monkey{
        private ArrayList<Integer> items = new ArrayList<>();
        private int divTest;
        private int op, param;
        private int trueMonkey, falseMonkey;
        private int totalInspections = 0;
        public void takeTurn(){
            while(!items.isEmpty()){
                int i = items.remove(0);
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
                i/=3;
                if(i%divTest==0){
                    monkeys.get(trueMonkey).items.add(i);
                }else monkeys.get(falseMonkey).items.add(i);
            }
        }
    }
}