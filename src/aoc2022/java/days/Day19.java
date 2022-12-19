package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
public class Day19 extends Day{
    public Day19(){
        super(19);
    }
    public ArrayList<Blueprint> blueprints = new ArrayList<>();
    @Override
    public void run(){
        for(String s : input.split("\n")){
            String[] strs = s.split(" ");
            blueprints.add(new Blueprint(strs[6], strs[12], strs[18], strs[21], strs[27], strs[30]));
        }
        int total = 0;
        for(int i = 0; i<blueprints.size(); i++){
            int best = -1;
            for(int j = 0; j<5; j++){
                best = Math.max(best, findGoodSolution(blueprints.get(i)));
            }
            total+=(i+1)*best;
        }
        System.out.println(total);
    }
    private int findGoodSolution(Blueprint blueprint){
        long lastChange = System.nanoTime();
        int best = -1;
        ArrayList<Robot> bestSteps = null;
        while(true){
            ArrayList<Robot> steps = (rand.nextInt(10)==0||bestSteps==null)?randomValidSolution(blueprint, 24):tweak(bestSteps, rand.nextInt(rand.nextInt(23)+1));
            int score = calculateSubscore(blueprint, steps);
            if(score>best||bestSteps==null){
                System.out.println("Found better: "+score);
                best = score;
                bestSteps = steps;
                lastChange = System.nanoTime();
            }
            if(System.nanoTime()-lastChange>500_000_000l)break;//stop after 5 seconds of inactivity
        }
        return calculate(blueprint, bestSteps);
    }
    Random rand = new Random();
    private ArrayList<Robot> randomValidSolution(Blueprint blueprint, int size){
        ArrayList<Robot> steps = new ArrayList<>();
        HashMap<Robot, Integer> robots = new HashMap<>();
        robots.put(Robot.ORE, 1);
        int ore = 0, clay = 0, obby = 0, geodes = 0;
        for(int i = 0; i<size; i++){
            ArrayList<Robot> possibleActions = new ArrayList<>();
            possibleActions.add(null);
            if(ore>=blueprint.oreOre)possibleActions.add(Robot.ORE);
            if(ore>=blueprint.clayOre)possibleActions.add(Robot.CLAY);
            if(ore>=blueprint.obsidianOre&&clay>=blueprint.obsidianClay)possibleActions.add(Robot.OBSIDIAN);
            if(ore>=blueprint.geodeOre&&obby>=blueprint.geodeObsidian)possibleActions.add(Robot.GEODE);
            Robot chosen = possibleActions.get(rand.nextInt(possibleActions.size()));
            steps.add(chosen);
            if(chosen!=null){
                switch(chosen){
                    case ORE:
                        ore-=blueprint.oreOre;
                        break;
                    case CLAY:
                        ore-=blueprint.clayOre;
                        break;
                    case OBSIDIAN:
                        ore-=blueprint.obsidianOre;
                        clay-=blueprint.obsidianClay;
                        break;
                    case GEODE:
                        ore-=blueprint.geodeOre;
                        obby-=blueprint.geodeObsidian;
                        break;
                }
            }
            ore+=robots.getOrDefault(Robot.ORE, 0);
            clay+=robots.getOrDefault(Robot.CLAY, 0);
            obby+=robots.getOrDefault(Robot.OBSIDIAN, 0);
            geodes+=robots.getOrDefault(Robot.GEODE, 0);
            if(chosen!=null)robots.put(chosen, robots.getOrDefault(chosen, 0)+1);
        }
        return steps;
    }
    private ArrayList<Robot> randomSolution(int size){
        ArrayList<Robot> robots = new ArrayList<>();
        for(int i = 0; i<size; i++){
            int r = rand.nextInt(5);
            Robot robot = r==4?null:Robot.values()[r];
            robots.add(robot);
        }
        return robots;
    }
    private int findBestSolution(Blueprint blueprint, ArrayList<Robot> steps){//takes too long, IT'S PLANNERATOR TIME AGAIN
        if(steps.size()<24){
            if(steps.size()<15)System.out.println(steps.size());
            int best = -1;
            ArrayList<Robot> bestList = null;
            for(int i = 0; i<5; i++){
                Robot r = i==4?null:Robot.values()[i];
                ArrayList<Robot> lst = new ArrayList<>(steps);
                lst.add(r);
                int score = findBestSolution(blueprint, lst);
                if(score>best){
                    best = score;
                    bestList = lst;
                }
            }
            steps = bestList;
        }
        return calculate(blueprint, steps);
    }
    private int calculate(Blueprint blueprint, ArrayList<Robot> steps){
        if(steps==null)return -1;
        HashMap<Robot, Integer> robots = new HashMap<>();
        robots.put(Robot.ORE, 1);
        int ore = 0, clay = 0, obby = 0, geodes = 0;
        for(Robot step : steps){
            if(step!=null){
                switch(step){
                    case ORE:
                        ore-=blueprint.oreOre;
                        break;
                    case CLAY:
                        ore-=blueprint.clayOre;
                        break;
                    case OBSIDIAN:
                        ore-=blueprint.obsidianOre;
                        clay-=blueprint.obsidianClay;
                        break;
                    case GEODE:
                        ore-=blueprint.geodeOre;
                        obby-=blueprint.geodeObsidian;
                        break;
                }
            }
            if(ore<0||clay<0||obby<0||geodes<0)return -1;//invalid!
            ore+=robots.getOrDefault(Robot.ORE, 0);
            clay+=robots.getOrDefault(Robot.CLAY, 0);
            obby+=robots.getOrDefault(Robot.OBSIDIAN, 0);
            geodes+=robots.getOrDefault(Robot.GEODE, 0);
            if(step!=null)robots.put(step, robots.getOrDefault(step, 0)+1);
        }
        return geodes;
    }
    private int calculateSubscore(Blueprint blueprint, ArrayList<Robot> steps){
        if(steps==null)return -1;
        HashMap<Robot, Integer> robots = new HashMap<>();
        robots.put(Robot.ORE, 1);
        int ore = 0, clay = 0, obby = 0, geodes = 0;
        for(Robot step : steps){
            if(step!=null){
                switch(step){
                    case ORE:
                        ore-=blueprint.oreOre;
                        break;
                    case CLAY:
                        ore-=blueprint.clayOre;
                        break;
                    case OBSIDIAN:
                        ore-=blueprint.obsidianOre;
                        clay-=blueprint.obsidianClay;
                        break;
                    case GEODE:
                        ore-=blueprint.geodeOre;
                        obby-=blueprint.geodeObsidian;
                        break;
                }
            }
            if(ore<0||clay<0||obby<0||geodes<0)return -1;//invalid!
            ore+=robots.getOrDefault(Robot.ORE, 0);
            clay+=robots.getOrDefault(Robot.CLAY, 0);
            obby+=robots.getOrDefault(Robot.OBSIDIAN, 0);
            geodes+=robots.getOrDefault(Robot.GEODE, 0);
            if(step!=null)robots.put(step, robots.getOrDefault(step, 0)+1);
        }
        return geodes*1_000_000+obby*100+clay*10+ore;
    }

    private ArrayList<Robot> tweak(ArrayList<Robot> input, int tweaks){
        var steps = new ArrayList<>(input);
        for(int i = 0; i<tweaks; i++){
            steps.remove(rand.nextInt(steps.size()));
            int r = rand.nextInt(5);
            Robot robot = r==4?null:Robot.values()[r];
            steps.add(rand.nextInt(steps.size()+1), robot);
        }
        return steps;
    }
    public static enum Robot{
        ORE,
        CLAY,
        OBSIDIAN,
        GEODE
    }
    private static class Blueprint{
        private final int oreOre;
        private final int clayOre;
        private final int obsidianOre;
        private final int obsidianClay;
        private final int geodeOre;
        private final int geodeObsidian;
        public Blueprint(int oreOre, int clayOre, int obsidianOre, int obsidianClay, int geodeOre, int geodeObsidian){
            this.oreOre = oreOre;
            this.clayOre = clayOre;
            this.obsidianOre = obsidianOre;
            this.obsidianClay = obsidianClay;
            this.geodeOre = geodeOre;
            this.geodeObsidian = geodeObsidian;
        }
        public Blueprint(String oreOre, String clayOre, String obsidianOre, String obsidianClay, String geodeOre, String geodeObsidian){
            this.oreOre = Integer.parseInt(oreOre);
            this.clayOre = Integer.parseInt(clayOre);
            this.obsidianOre = Integer.parseInt(obsidianOre);
            this.obsidianClay = Integer.parseInt(obsidianClay);
            this.geodeOre = Integer.parseInt(geodeOre);
            this.geodeObsidian = Integer.parseInt(geodeObsidian);
        }
    }
}