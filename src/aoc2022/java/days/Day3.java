package aoc2022.java.days;
import aoc2022.java.Day;
public class Day3 extends Day{
    public Day3(){
        super(3);
    }
    @Override
    public void run() {
        String[] rucksacks = input.split("\n");
        int score = 0;
        for(String rucksack : rucksacks){
            String cp1 = rucksack.substring(0, rucksack.length()/2);
            String cp2 = rucksack.substring(rucksack.length()/2);
            char common = ' ';
            for(char c : cp1.toCharArray()){
                if(cp2.contains(c+"")){
                    common = c;
                    break;
                }
            }
            score+=priority(common);
        }
        System.out.println(score);
        score = 0;
        for(int i = 0; i<rucksacks.length-2; i+=3){
            String rc1 = rucksacks[i];
            String rc2 = rucksacks[i+1];
            String rc3 = rucksacks[i+2];
            char common = ' ';
            for(char c : rc1.toCharArray()){
                if(rc2.contains(c+"")&&rc3.contains(c+"")){
                    common = c;
                    break;
                }
            }
            score+=priority(common);
        }
        System.out.println(score);
    }
    public int priority(char c){
        if(c>='a'&&c<='z')return c-'a'+1;
        if(c>='A'&&c<='Z')return c-'A'+27;
        return -1;
    }
}