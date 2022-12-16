package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
public class Day16 extends Day{
    public Day16(){
        super(16);
    }
    public static HashMap<String, Valve> valves = new HashMap<>();
    String current = "AA";
    @Override
    public void run(){
        long time = System.nanoTime();
        ArrayList<Valve> usefulValves = new ArrayList<>();
        for(String str : input.split("\n")){
            String[] s = str.split(" ");
            Valve valve = new Valve(s[1], Integer.parseInt(s[4].substring(5).replace(";", "")));
            for(int i = 9; i<s.length; i++){
                valve.tunnels.add(s[i].replace(",", ""));
            }
            if(valve.rate>0)usefulValves.add(valve);
        }
        usefulValves.add(valves.get(current));//not actually useful, but needed for the calculations cuz that's where ya start
        for(Valve valve : usefulValves){
            for(Valve otherValve : usefulValves){
                if(valve==otherValve)continue;
                valve.timeMap.put(otherValve, path(valve, otherValve).size()-1);
            }
        }
        long bestScore = 0;
        ArrayList<Valve> bestPath = null;
        while(true){
            ArrayList<Valve> path = (bestPath==null||rand.nextDouble()<.1f)?randomPath(valves.get(current), usefulValves):tweakPath(bestPath, rand.nextInt(rand.nextInt(bestPath.size()-1)+1));
            long score = simulate(path);
            long diff = (System.nanoTime()-time);
            if(bestPath==null||score>bestScore){
                bestScore = score;
                bestPath = path;
                System.out.println(score+": "+path.toString()+" "+diff/1_000_000+"ms");
            }
            if(diff>2_000_000_000l){
                System.out.println("two seconds have passed, hope that's good enough");
                break;
            }
        }
        //part 2
        bestScore = 0;
        ArrayList<Valve>[] bestPth = null;
        while(true){
            ArrayList<Valve>[] path = (bestPth==null||rand.nextDouble()<.1f)?randomPth(valves.get(current), usefulValves):tweakPath(bestPth, rand.nextInt(10)+1);
            long score = simulate(path);
            long diff = (System.nanoTime()-time);
            if(bestPth==null||score>bestScore){
                bestScore = score;
                bestPth = path;
                System.out.println(score+": "+Arrays.toString(path)+" "+diff/1_000_000+"ms");
            }
            if(diff>5_000_000_000l){
                System.out.println("another three have passed, hope that's good enough");
                break;
            }
        }
    }
    private ArrayList<Valve> path(String... strs){
        ArrayList<Valve> path = new ArrayList<>();
        for(String s : strs)path.add(valves.get(s));
        return path;
    }
    private ArrayList<Valve> path(Valve valve, Valve otherValve){
        return path(valve, otherValve, new ArrayList<>());
    }
    private ArrayList<Valve> path(Valve valve, Valve otherValve, ArrayList<Valve> visited){
        if(valve==otherValve){
            ArrayList<Valve> lst = new ArrayList<>();
            lst.add(otherValve);
            return lst;
        }
        visited.add(valve);
        ArrayList<Valve> best = null;
        for(String s : valve.tunnels){
            Valve v = valves.get(s);
            if(visited.contains(v))continue;
            var path = path(valves.get(s), otherValve, new ArrayList<>(visited));
            if(path!=null&&(best==null||path.size()<best.size()))best = path;
        }
        if(best==null)return null;
        best.add(valve);
        return best;
    }
    Random rand = new Random();
    private ArrayList<Valve> randomPath(Valve start, ArrayList<Valve> allofem){
        ArrayList<Valve> path = new ArrayList<>();
        path.add(start);
        while(path.size()<allofem.size()){
            Valve last = path.get(path.size()-1);
            ArrayList<Valve> nextPossibilities = new ArrayList<>(allofem);
            nextPossibilities.removeAll(path);
            path.add(nextPossibilities.get(rand.nextInt(nextPossibilities.size())));
        }
        return path;
    }
    private ArrayList<Valve>[] randomPth(Valve start, ArrayList<Valve> allofem){
        ArrayList<Valve> path = new ArrayList<>();
        path.add(start);
        while(path.size()<allofem.size()){
            Valve last = path.get(path.size()-1);
            ArrayList<Valve> nextPossibilities = new ArrayList<>(allofem);
            nextPossibilities.removeAll(path);
            path.add(nextPossibilities.get(rand.nextInt(nextPossibilities.size())));
        }
        int split = rand.nextInt(path.size()-3)+2;
        ArrayList<Valve> otherPath = new ArrayList<>();
        otherPath.add(path.get(0));
        for(int i = split; i<path.size(); i++)otherPath.add(path.remove(split));
        return new ArrayList[]{path, otherPath};
    }
    @Deprecated //takes too long, too many permutations x.x
    private ArrayList<ArrayList<Valve>> findAllPaths(Valve start, ArrayList<Valve> visited){
        visited.add(start);
        ArrayList<ArrayList<Valve>> paths = new ArrayList<>();
        for(Valve v : start.timeMap.keySet()){
            if(visited.contains(v))continue;
            paths.addAll(findAllPaths(v, new ArrayList<>(visited)));
        }
        if(paths.isEmpty()){
            paths.add(new ArrayList<Valve>());
            paths.get(0).add(start);
        }
        for(var lst : paths)lst.add(start);
        if(paths.get(0).size()>10)System.out.println(paths.size()+" "+(paths.isEmpty()?"":paths.get(0).size()));
        return paths;
    }
    private long simulate(ArrayList<Valve> path){
        long score = 0;
        long releasing = 0;
        int idx = 0;
        boolean open = false;//should I open a valve this turn?
        int travelTime = path.get(0).timeMap.get(path.get(1));
        for(int i = 0; i<30; i++){
            score+=releasing;
            if(travelTime>0){
                travelTime--;
                if(travelTime==0){
                    open = true;
                    idx++;
                }
                continue;
            }
            if(open){
                releasing+=path.get(idx).rate;
                open = false;
                if(idx<path.size()-1)travelTime = path.get(idx).timeMap.get(path.get(idx+1));
                continue;
            }
        }
        return score;
    }
    private long simulate(ArrayList<Valve>[] paths){
        ArrayList<Valve> p1 = paths[0];
        ArrayList<Valve> p2 = paths[1];
        long score = 0;
        long releasing = 0;
        int i1 = 0;
        int i2 = 0;
        boolean o1 = false;//should I open a valve this turn?
        boolean o2 = false;//should the elephant open a valve this turn?
        int t1 = p1.get(0).timeMap.get(p1.get(1));
        int t2 = p2.get(0).timeMap.get(p2.get(1));
        for(int i = 0; i<26; i++){
            score+=releasing;
            if(t1>0){
                t1--;
                if(t1==0){
                    o1 = true;
                    i1++;
                }
            }else if(o1){
                releasing+=p1.get(i1).rate;
                o1 = false;
                if(i1<p1.size()-1)t1 = p1.get(i1).timeMap.get(p1.get(i1+1));
            }
            if(t2>0){
                t2--;
                if(t2==0){
                    o2 = true;
                    i2++;
                }
            }else if(o2){
                releasing+=p2.get(i2).rate;
                o2 = false;
                if(i2<p2.size()-1)t2 = p2.get(i2).timeMap.get(p2.get(i2+1));
            }
        }
        return score;
    }
    private ArrayList<Valve> tweakPath(ArrayList<Valve> p, int tweaks){
        var path = new ArrayList<>(p);
        for(int i = 0; i<tweaks; i++){
            path.add(rand.nextInt(path.size()-1)+1, path.remove(rand.nextInt(path.size()-1)+1));
        }
        return path;
    }
    private ArrayList<Valve>[] tweakPath(ArrayList<Valve>[] ps, int tweaks){
        var p1 = new ArrayList<>(ps[0]);
        var p2 = new ArrayList<>(ps[1]);
        for(int i = 0; i<tweaks; i++){
            switch(rand.nextInt(4)){
                case 0:
                    p1 = tweakPath(p1, 1);
                    break;
                case 1:
                    p2 = tweakPath(p2, 1);
                    break;
                case 2:
                    if(p1.size()>2){
                        p2.add(rand.nextInt(p2.size())+1, p1.remove(rand.nextInt(p1.size()-1)+1));
                    }
                    break;
                case 3:
                    if(p2.size()>2){
                        p1.add(rand.nextInt(p1.size())+1, p2.remove(rand.nextInt(p2.size()-1)+1));
                    }
                    break;
            }
        }
        return new ArrayList[]{p1,p2};
    }
    private static class Valve{
        private final String name;
        private final int rate;
        private ArrayList<String> tunnels = new ArrayList<>();
        private HashMap<Valve, Integer> timeMap = new HashMap<>();
        public Valve(String name, int rate){
            this.name = name;
            this.rate = rate;
            valves.put(name, this);
        }
        @Override
        public String toString(){
            return name;//+" "+rate+" "+tunnels.toString();
        }
    }
}