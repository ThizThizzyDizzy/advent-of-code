package aoc2023.java.days;
import aoc2023.java.Day;
import java.util.ArrayList;
public class Day3 extends Day{
    public Day3(){
        super(3);
    }
    @Override
    public void run(){
        ArrayList<Symbol> symbols = new ArrayList<>();
        String[] rows = input.split("\n");
        for(int y = 0; y<rows.length; y++){
            for(int x = 0; x<rows[y].length(); x++){
                char c = rows[y].charAt(x);
                if(c!='.'&&!Character.isDigit(c))symbols.add(new Symbol(c,x,y));
            }
        }
        long total = 0;
        for(int y = 0; y<rows.length; y++){
            for(int x = 0; x<rows[y].length(); x++){
                char c = rows[y].charAt(x);
                if(Character.isDigit(c)){
                    String num = "";
                    for(int len = 0; len<rows[y].length()-x; len++){
                        char ch = rows[y].charAt(x+len);
                        if(Character.isDigit(rows[y].charAt(x+len)))num+=ch;
                        else break;
                    }
                    for(Symbol s : symbols){
                        if(s.x>=x-1&&s.y>=y-1&&s.x<=x+num.length()&&s.y<=y+1){
                            s.value*=Integer.parseInt(num);
                            s.count++;
                            total+=Integer.parseInt(num);
                        }
                    }
                    x+=num.length();
                }
            }
        }
        System.out.println(total);
        long totalRatio = 0;
        for(Symbol s : symbols){
            if(s.c=='*'&&s.count==2){
                totalRatio+=s.value;
            }
        }
        System.out.println(totalRatio);
    }
    private static class Symbol{
        private final char c;
        private final int x;
        private final int y;
        private int value = 1;
        private int count = 0;
        public Symbol(char c, int x, int y){
            this.c = c;
            this.x = x;
            this.y = y;
        }
    }
}