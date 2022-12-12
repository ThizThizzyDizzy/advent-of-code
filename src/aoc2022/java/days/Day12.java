package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.ArrayList;
public class Day12 extends Day{
    private static int startx;
    private static int starty;
    private static int endx;
    private static int endy;
    public Day12(){
        super(12);
    }
    public static int[][] heightmap;
    @Override
    public void run(){
        String[] rows = input.split("\n");
        heightmap = new int[rows[0].length()][rows.length];
        for(int y = 0; y<rows.length; y++){
            for(int x = 0; x<rows[y].length(); x++){
                char c = rows[y].charAt(x);
                if(c=='S'){
                    c = 'a';
                    startx = x;
                    starty = y;
                }
                if(c=='E'){
                    c = 'z';
                    endx = x;
                    endy = y;
                }
                heightmap[x][y] = Integer.parseInt(c+"", 36)-10;
            }
        }
        System.out.println(path(startx, starty, endx, endy).size());
    }
    private ArrayList<Node> path(int startx, int starty, int endx, int endy){
        ArrayList<Node> open = new ArrayList<>();
        ArrayList<Node> closed = new ArrayList<>();
        Node start = getNode(startx, starty);
        start.g = 0;
        start.f = start.h;
        open.add(start);
        while(!open.isEmpty()){
            Node node = null;
            for(Node n : open){
                if(node==null||n.f<node.f)node = n;
            }
            open.remove(node);
            if(node.x==endx&&node.y==endy)return retrace(node);
            for(Direction d : Direction.values()){
                Node neighbor = getNode(node.x+d.x, node.y+d.y);
                if(neighbor==null)continue;
                if(neighbor.z>node.z+1)continue;//too far up!
                int g = node.g+1;
                if(g<neighbor.g){
                    neighbor.g = g;
                    neighbor.parent = node;
                    if(!open.contains(neighbor))open.add(neighbor);
                }
            }
        }
        return null;
    }
    ArrayList<Node> nodes = new ArrayList<>();
    private Node getNode(int x, int y){
        if(x<0||y<0||x>=heightmap.length||y>=heightmap[0].length)return null;
        for(Node node : nodes){
            if(node.x==x&&node.y==y)return node;
        }
        Node node = new Node(x, y);
        nodes.add(node);
        return node;
    }
    private ArrayList<Node> retrace(Node node) {
        ArrayList<Node> path = new ArrayList<>();
        while(node.parent!=null){
            path.add(node);
            node = node.parent;
        }
        return path;
    }
    private static class Node{
        private final int x;
        private final int y;
        private final int z;
        int g = Integer.MAX_VALUE;
        int f = Integer.MAX_VALUE;
        final int h;
        private Node parent;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
            z = heightmap[x][y];
            h = Math.abs(x-endx)+Math.abs(y-endy);
        }
    }
    private static enum Direction{
        PX(1,0),
        PY(0,1),
        NX(-1,0),
        NY(0,-1);
        private final int x;
        private final int y;
        private Direction(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}