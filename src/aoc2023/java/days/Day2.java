package aoc2023.java.days;
import aoc2023.java.Day;
import java.util.ArrayList;
import java.util.HashMap;
public class Day2 extends Day{
    public Day2(){
        super(2);
    }
    @Override
    public void run(){
        ArrayList<Game> games = new ArrayList<>();
        for(String s : input.split("\n")){
            games.add(new Game(s));
        }
        int total = 0;
        long totalPower = 0;
        for(Game game : games){
            boolean possible = true;
            for(Round round : game.rounds){
                if(round.cubes.getOrDefault("red", 0)>12
                    ||round.cubes.getOrDefault("green", 0)>13
                    ||round.cubes.getOrDefault("blue", 0)>14)possible = false;
            }
            if(possible)total+=game.id;
            int power = 1;
            for(String s : game.min.cubes.keySet()){
                power*=game.min.cubes.get(s);
            }
            totalPower+=power;
        }
        System.out.println(total);
        System.out.println(totalPower);
    }
    private static class Game{
        private final int id;
        private final ArrayList<Round> rounds = new ArrayList<>();
        private final Round min;
        public Game(String s){
            id = Integer.parseInt(s.substring("game ".length(), s.indexOf(":")));
            s = s.substring(("game "+id+":").length()).trim();
            for(String round : s.split(";")){
                rounds.add(new Round(round.trim()));
            }
            min = new Round();
            for(Round round : rounds){
                for(String key : round.cubes.keySet()){
                    min.cubes.put(key, Math.max(round.cubes.get(key),min.cubes.getOrDefault(key, 0)));
                }
            }
        }
    }
    private static class Round{
        public HashMap<String, Integer> cubes = new HashMap<>();
        public Round(){}
        private Round(String text){
            for(String s : text.split(",")){
                s = s.trim();
                String[] strs = s.split(" ");
                cubes.put(strs[1], cubes.getOrDefault(strs[1], 0)+Integer.parseInt(strs[0]));
            }
        }
    }
}