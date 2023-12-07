package aoc2023.java.days;
import aoc2023.java.Day;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class Day7 extends Day{
    public Day7(){
        super(7);
    }
    @Override
    public void run(){
        ArrayList<Hand> hands = new ArrayList<>();
        for(String str : input.split("\n")){
            String[] strs = str.split(" ");
            hands.add(new Hand(strs[0], Integer.parseInt(strs[1])));
        }
        Collections.sort(hands);
        long total = 0;
        for(int i = 0; i<hands.size(); i++){
            Hand hand = hands.get(i);
            hand.rank = i+1;
            total+=hand.rank*hand.bet;
        }
        System.out.println(total);
        values = jokerValues;
        Collections.sort(hands);
        total = 0;
        for(int i = 0; i<hands.size(); i++){
            Hand hand = hands.get(i);
            hand.rank = i+1;
            total+=hand.rank*hand.bet;
        }
        System.out.println(total);
    }
    private static String values = "23456789TJQKA";
    private static String jokerValues = "J23456789TQKA";
    private static class Hand implements Comparable<Hand>{
        private HandType type;
        private HandType jokerType;
        private final int bet;
        private final String hand;
        private int rank;
        public Hand(String hand, int bet){
            this.hand = hand;
            this.bet = bet;
            type = calcType(hand);
            for(int v = jokerValues.length()-1; v>0; v--){
                HandType t = calcType(hand.replace('J', jokerValues.charAt(v)));
                if(jokerType==null||t.ordinal()<jokerType.ordinal())jokerType = t;
            }
        }
        private HandType calcType(String hand){
            HandType type = null;
            HashMap<Character, Integer> charCounts = new HashMap<>();
            for(char c : hand.toCharArray())charCounts.put(c, charCounts.getOrDefault(c, 0)+1);
            ArrayList<Character> chars = new ArrayList<>(charCounts.keySet());
            chars.sort((o1, o2) -> charCounts.get(o2)-charCounts.get(o1));
            switch(chars.size()){
                case 5:
                    type = HandType.HIGH_CARD;
                    break;
                case 4:
                    type = HandType.ONE_PAIR;
                    break;
                case 3:
                    if(charCounts.get(chars.get(0))==3){//3+1x2
                        type = HandType.THREE_OF_KIND;
                    }
                    if(charCounts.get(chars.get(0))==2)type = HandType.TWO_PAIR;//2x2+1
                    break;
                case 2:
                    if(charCounts.get(chars.get(0))==3){//3+2
                        type = HandType.FULL_HOUSE;
                    }else type = HandType.FOUR_OF_KIND;
                    break;
                case 1:
                    type = HandType.FIVE_OF_KIND;
                    break;
                default:
                    throw new IllegalArgumentException("HOW DID YOU DO THAT");
            };
            return type;
        }
        @Override
        public int compareTo(Hand o){
            int value = values.equals(jokerValues)?(o.jokerType.ordinal()-jokerType.ordinal()):(o.type.ordinal()-type.ordinal());
            if(value!=0)return value;
            for(int i = 0; i<5; i++){
                int v1 = values.indexOf(hand.charAt(i)+"");
                int v2 = values.indexOf(o.hand.charAt(i)+"");
                if(v1!=v2)return v1-v2;
            }
            throw new IllegalArgumentException("Uh oh! Found two identical hands!");
        }
    }

    private static enum HandType{
        FIVE_OF_KIND,
        FOUR_OF_KIND,
        FULL_HOUSE,
        THREE_OF_KIND,
        TWO_PAIR,
        ONE_PAIR,
        HIGH_CARD;
    }
}