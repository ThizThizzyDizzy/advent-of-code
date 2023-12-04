package aoc2023.java.days;
import aoc2023.java.Day;
public class Day4 extends Day{
    public Day4(){
        super(4);
    }
    @Override
    public void run(){
        long total = 0;
        String[] cards = input.split("\n");
        int[] count = new int[cards.length];
        for(int i = 0; i<count.length; i++)count[i] = 1;
        for(int i = 0; i<cards.length; i++){
            String card = cards[i];
            String[] strs = card.split("[:|]");
            long part1Value = 1;
            int matchingNumbers = 0;
            for(String cardNum : strs[1].split(" ")){
                if(cardNum.isBlank())continue;
                int n1 = Integer.parseInt(cardNum);
                for(String haveNum : strs[2].split(" ")){
                    if(haveNum.isBlank())continue;
                    int n2 = Integer.parseInt(haveNum);
                    if(n1==n2){
                        part1Value*=2;
                        matchingNumbers++;
                        break;
                    }
                }
            }
            part1Value/=2;
            total+=part1Value;
            for(int off = 1; off<=matchingNumbers; off++){
                if(i+off>=cards.length)break;
                count[i+off]+=count[i];
            }
        }
        System.out.println(total);
        total = 0;
        for(int i : count)total+=i;
        System.out.println(total);
    }
}