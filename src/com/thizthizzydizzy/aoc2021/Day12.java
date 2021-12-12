package com.thizthizzydizzy.aoc2021;
import java.util.ArrayList;
public class Day12 implements Day{
    @Override
    public void run(){
        String input = """
                       CV-mk
                       gm-IK
                       sk-gm
                       ca-sk
                       sx-mk
                       gm-start
                       sx-ca
                       kt-sk
                       ca-VS
                       kt-ml
                       kt-ca
                       mk-IK
                       end-sx
                       end-sk
                       gy-sx
                       end-ca
                       ca-ml
                       gm-CV
                       sx-kt
                       start-CV
                       IK-start
                       CV-kt
                       ml-mk
                       ml-CV
                       ml-gm
                       ml-IK""";
        System.out.println("Part one");
        ArrayList<Node> nodes = new ArrayList<>();
        for(String path : input.split("\n")){
            String[] parts = path.split("\\-");
            Node from = getNode(nodes, parts[0]);
            Node to = getNode(nodes, parts[1]);
            from.linked.add(to);
            to.linked.add(from);
        }
        Path path;
        findAllPaths(path = new Path(getNode(nodes, "start")), nodes);
        System.out.println(path.countPaths());
        System.out.println("Part two");
        findAllPaths2(path = new Path(getNode(nodes, "start")), nodes);
        System.out.println(path.countPaths());
    }
    private Node getNode(ArrayList<Node> nodes, String node){
        for(Node n : nodes){
            if(n.name.equals(node))return n;
        }
        var n = new Node(node);
        nodes.add(n);
        return n;
    }
    private void findAllPaths(Path startingPath, ArrayList<Node> nodes){
        Node from = startingPath.path[startingPath.path.length-1];
        if(from.name.equals("end"))return;//path has already ended
        for(Node node : from.linked){
            if(node.small&&contains(startingPath.path, node))continue;//already visited small cave!
            Path path = new Path(startingPath.path, node);
            findAllPaths(path, nodes);
            startingPath.subpaths.add(path);
        }
    }
    private void findAllPaths2(Path startingPath, ArrayList<Node> nodes){
        Node from = startingPath.path[startingPath.path.length-1];
        if(from.name.equals("end"))return;//path has already ended
        for(Node node : from.linked){
            int c = count(startingPath.path, node);
            if(node.small&&(c>=2||(startingPath.hasDoubleSmall()&&c>=1))||node.name.equals("start"))continue;//already visited!
            Path path = new Path(startingPath.path, node);
            findAllPaths2(path, nodes);
            startingPath.subpaths.add(path);
        }
    }
    private static int count(Node[] path, Node node){
        int c = 0;
        for(Node n : path)if(n==node)c++;
        return c;
    }
    private boolean contains(Node[] path, Node node){
        for(Node n : path)if(n==node)return true;
        return false;
    }
    private static class Node{
        private final String name;
        private final boolean small;
        private final ArrayList<Node> linked = new ArrayList<>();
        public Node(String name){
            this.name = name;
            small = Character.isLowerCase(name.charAt(0));
        }
    }
    private static class Path{
        private final Node[] path;
        private final ArrayList<Path> subpaths = new ArrayList<>();
        public Path(Node... nodes){
            path = nodes;
        }
        public Path(Node[] prevPath, Node newNode){
            path = new Node[prevPath.length+1];
            for(int i = 0; i<prevPath.length; i++){
                path[i] = prevPath[i];
            }
            path[path.length-1] = newNode;
        }
        public int countPaths(){
            if(subpaths.isEmpty())return path[path.length-1].name.equals("end")?1:0;
            else{
                int ret = 0;
                for(Path p : subpaths)ret+=p.countPaths();
                return ret;
            }
        }
        private boolean hasDoubleSmall(){
            for(Node n : path){
                if(n.small&&count(path, n)>1)return true;
            }
            return false;
        }
    }
}
