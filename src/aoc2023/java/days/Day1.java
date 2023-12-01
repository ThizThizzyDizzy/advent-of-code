package aoc2023.java.days;
import aoc2023.java.Day;
public class Day1 extends Day{
    public Day1(){
        super(1);
    }
    @Override
    public void run() {
        int total = 0;
        for(String strs : input.split("\n")){
            int first = -1;
            int last = -1;
            for(char c : strs.toCharArray()){
                if(Character.isDigit(c)){
                    if(first==-1)first = toint(c);
                    last = toint(c);
                }
            }
            total+=Integer.parseInt(first+""+last);
        }
        System.out.println(total);
        String input2 = input;
        String[] numbers = new String[]{"one","two","three","four","five","six","seven","eight","nine"};
        int total2 = 0;
        for(String strs : input2.split("\n")){
            int first = -1;
            int last = -1;
            for(int i = 0; i<strs.length(); i++){
                for(int n = 1; n<=numbers.length; n++){
                    String num = numbers[n-1];
                    if(strs.startsWith(num, i)||strs.charAt(i)==(n+"").charAt(0)){
                        if(first==-1)first = n;
                        last = n;
                    }
                }
            }
            total2+=Integer.parseInt(first+""+last);
        }
        System.out.println(total2);
    }
    private int toint(char c){
        return Integer.parseInt(c+"");
    }
}