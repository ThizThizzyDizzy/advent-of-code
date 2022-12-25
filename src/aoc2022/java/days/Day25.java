package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.ArrayList;
public class Day25 extends Day{
    public Day25(){
        super(25);
    }
    @Override
    public void run(){
        long total = 0;
        for(String snafu : input.split("\n")){
            total+=fromSNAFU(snafu);
        }
        System.out.println(toSNAFU(total));
    }
    public String toSNAFU(long num){
        ArrayList<Long> digits = new ArrayList<>();
        digits.add(num);
        int pos = 0;
        while(digits.size()>pos){
            long val = digits.get(pos);
            long next = 0;
            while(val>2){
                long amount = Math.max(1,(val-3)/5);
                next+=amount;
                val-=5*amount;
            }
            digits.set(pos, val);
            if(next==0)break;
            digits.add(next);
            pos++;
        }
        String snafu = "";
        for(long l : digits){
            snafu = vals.charAt((int) l+2)+snafu;
        }
        return snafu;
    }
    String vals = "=-012";
    public long fromSNAFU(String s){
        long num = 0;
        long place = 1;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(s.length()-i-1);
            num+=(vals.indexOf(c+"")-2)*place;
            place*=5;
        }
        return num;
    }
}