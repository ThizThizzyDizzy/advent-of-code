package aoc2023.java.days;
import aoc2023.java.Day;
import java.util.ArrayList;
import java.util.HashMap;
public class Day8 extends Day{
    private static String directions;
    private static HashMap<String, String> left;
    private static HashMap<String, String> right;
    public Day8(){
        super(8);
    }
    @Override
    public void run(){
        directions = input.split("\n\n")[0];
        left = new HashMap<>();
        right = new HashMap<>();
        for(String s : input.split("\n\n")[1].split("\n")){
            String key = s.split("=")[0].trim();
            String[] vals = s.split("=")[1].trim().replaceAll("[(),]", "").split(" ");
            left.put(key, vals[0]);
            right.put(key, vals[1]);
        }
        String start = "AAA";
        int steps = 0;
        int idx = 0;
        while(!start.equals("ZZZ")){
            char c = directions.charAt(idx);
            if(c=='L')start = left.get(start);
            if(c=='R')start = right.get(start);
            idx++;
            steps++;
            if(idx>=directions.length())idx = 0;
        }
        System.out.println(steps);
        
        ArrayList<Path> paths = new ArrayList<>();
        for(String s : left.keySet()){
            if(s.endsWith("A"))paths.add(new Path(s));
        }
        long lcm = 1;
        for(Path path : paths){
            lcm = lcm(lcm, path.repeatSteps);
        }
        System.out.println(lcm);
    }
    private long lcm(long n1, long n2){
        long lcm = Math.max(n1,n2);
        while(lcm%Math.min(n1, n2)!=0)lcm+=Math.max(n1, n2);
        return lcm;
    }

    private static class Path{
        public ArrayList<Node> lastNodes = new ArrayList<>();
        public int initialSteps;
        public int repeatSteps;
        public Path(String node){
            int steps = 0;
            int idx = 0;
            lastNodes.add(new Node(node, idx, steps));
            WHILE:while(true){
                char c = directions.charAt(idx);
                if(c=='L')node = left.get(node);
                if(c=='R')node = right.get(node);
                idx++;
                steps++;
                if(idx>=directions.length())idx = 0;
                if(node.endsWith("Z")){
                    Node n = new Node(node, idx, steps);
                    for(Node contained : lastNodes){
                        if(contained.node.equals(node)&&contained.idx==idx){
                            initialSteps = contained.step;
                            repeatSteps = steps-contained.step;
                            break WHILE;
                        }
                    }
                    lastNodes.add(n);
                }
            }
        }
    }
    private static class Node{
        private final String node;
        private final int idx;
        private final transient int step;
        public Node(String node, int idx, int step){
            this.node = node;
            this.idx = idx;
            this.step = step;
        }
        @Override
        public boolean equals(Object obj){
            if(obj instanceof Node n){
                return n.node.equals(node)&&n.idx==idx;
            }
            return false;
        }
    }
}