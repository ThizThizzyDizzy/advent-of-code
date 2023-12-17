package aoc2023.java.days;
import aoc2023.java.Day;
import java.util.ArrayList;
public class Day17 extends Day{

    private static int[][] map;
    public static int endx, endy;
    public static int minDist = 0, maxDist = 3;
    public Day17(){
        super(17);
    }
    @Override
    public void run(){
        String[] rows = input.split("\n");
        map = new int[rows[0].length()][rows.length];
        for(int y = 0; y<rows.length; y++){
            for(int x = 0; x<rows[y].length(); x++){
                char c = rows[y].charAt(x);
                map[x][y] = Integer.parseInt(c+"");
            }
        }
        endx = map.length-1;
        endy = map[0].length-1;
        int loss = 0;
        var p = path(0, 0, endx, endy);
        for(var node : p)loss+=node.c;
        for(int y = 0; y<=endy; y++){
            for(int x = 0; x<=endx; x++){
                Node n = null;
                for(var node : p){
                    if(node.x==x&&node.y==y)n = node;
                }
                System.out.print(n==null?".":'X');
            }
            System.out.println();
        }
        System.out.println(loss);
        minDist = 4;
        maxDist = 10;
        nodes.clear();
        loss = 0;
        p = path(0, 0, endx, endy);
        for(var node : p)loss+=node.c;
        for(int y = 0; y<=endy; y++){
            for(int x = 0; x<=endx; x++){
                Node n = null;
                for(var node : p){
                    if(node.x==x&&node.y==y)n = node;
                }
                System.out.print(n==null?".":'X');
            }
            System.out.println();
        }
        System.out.println(loss);
    }
     private ArrayList<Node> path(int startx, int starty, int endx, int endy){
        ArrayList<Node> open = new ArrayList<>();
        Node start = getNode(startx, starty, null, 0);
        start.g = 0;
        open.add(start);
        while(!open.isEmpty()){
            Node node = null;
            for(Node n : open){
                if(node==null||n.f()<node.f())node = n;
            }
            open.remove(node);
            if(node.x==endx&&node.y==endy)return retrace(node);
            for(Direction d : Direction.values()){
                if(node.d!=null&&node.dc<minDist&&d!=node.d)continue;
                if(node.d!=null&&(d.x==-node.d.x&&d.y==-node.d.y))continue; // prevent reversing direction
                Node neighbor = getNode(node.x+d.x, node.y+d.y, d, node.d==d?node.dc+1:1);
                if(neighbor==null)continue;
                int g = node.g+node.c;
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
    private Node getNode(int x, int y, Direction d, int dc){
        if(dc>maxDist)return null;
        if(x<0||y<0||x>=map.length||y>=map[0].length)return null;
        for(Node node : nodes){
            if(node.x==x&&node.y==y&&node.d==d&&node.dc==dc)return node;
        }
        Node node = new Node(x, y, d, dc);
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
        private final Direction d;
        private final int dc;
        int g = Integer.MAX_VALUE;
        final int h;
        private Node parent;
        private int c;
        public Node(int x, int y, Direction d, int dc){
            this.x = x;
            this.y = y;
            this.d = d;
            this.dc = dc;
            c = map[x][y];
            h = Math.abs(x-endx)+Math.abs(y-endy);
        }
        public int f(){
            return g+h;
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