package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.ArrayList;
public class Day24 extends Day{
    private int width, height;
    private static int endx, endy;
    public Day24(){
        super(24);
    }
    ArrayList<Blizzard> blizzards = new ArrayList<>();
    ArrayList<boolean[][]> spaceTimeBlizzardMap = new ArrayList<>();
    @Override
    public void run(){
        String[] lines = input.split("\n");
        width = lines[0].length();
        height = lines.length;
        endy = height-1;
        endx = width-2;
        for(int y = 0; y<lines.length; y++){
            String line = lines[y];
            for(int x = 0; x<line.length(); x++){
                char c = line.charAt(x);
                if(c=='v')blizzards.add(new Blizzard(x, y, Direction.DOWN));
                if(c=='>')blizzards.add(new Blizzard(x, y, Direction.RIGHT));
                if(c=='<')blizzards.add(new Blizzard(x, y, Direction.LEFT));
                if(c=='^')blizzards.add(new Blizzard(x, y, Direction.UP));
            }
        }
        generateSpaceTimeBlizzardMap();
        System.out.println(path(1, 0, endx, endy).size());
    }
    private ArrayList<Node> path(int startX, int startY, int endX, int endY){
        ArrayList<Node> open = new ArrayList<>();
        ArrayList<Node> closed = new ArrayList<>();
        Node start = getNode(startX, startY, 0);
        start.g = 0;
        start.f = start.h;
        open.add(start);
        while(!open.isEmpty()){
            Node node = null;
            for(Node n  : open){
                if(node==null||n.f<node.f)node = n;
            }
            open.remove(node);
            if(node.x==endx&&node.y==endy)return retrace(node);
            generateSpaceTimeBlizzardMaps(node.t+1);
            for(Direction d : Direction.values()){
                Node neighbor = getNode(node.x+d.dx, node.y+d.dy, node.t+1);
                if(neighbor==null)continue;
                if(spaceTimeBlizzardMap.get(neighbor.t)[neighbor.x][neighbor.y])continue;
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
    private ArrayList<Node> retrace(Node node) {
        ArrayList<Node> path = new ArrayList<>();
        while(node.parent!=null){
            path.add(node);
            node = node.parent;
        }
        return path;
    }
    ArrayList<Node> nodes = new ArrayList<>();
    private Node getNode(int x, int y, int t){
        if(x<=0||x>=width-1)return null;
        if(y<0||y>height-1)return null;
        if(y==0&&x!=1)return null;
        if(y==height-1&&x!=endx)return null;
        for(Node node : nodes){
            if(node.x==x&&node.y==y&&node.t==t)return node;
        }
        Node node = new Node(x, y, t);
        nodes.add(node);
        return node;
    }
    private void generateSpaceTimeBlizzardMaps(int time){
        while(spaceTimeBlizzardMap.size()<=time){
            advanceBlizzards();
            generateSpaceTimeBlizzardMap();
        }
    }
    private void generateSpaceTimeBlizzardMap(){
        boolean[][] map = new boolean[width][height];
        for(Blizzard blizzard : blizzards){
            map[blizzard.x][blizzard.y] = true;
        }
        spaceTimeBlizzardMap.add(map);
    }
    private void advanceBlizzards(){
        for(Blizzard b : blizzards){
            b.x+=b.dir.dx;
            b.y+=b.dir.dy;
            if(b.x==0)b.x = width-2;
            if(b.y==0)b.y = height-2;
            if(b.x==width-1)b.x = 1;
            if(b.y==height-1)b.y = 1;
        }
    }
    private static class Blizzard{
        private int x;
        private int y;
        private final Direction dir;
        public Blizzard(int x, int y, Direction direction){
            this.x = x;
            this.y = y;
            this.dir = direction;
        }
    }
    private static class Node{
        private final int x;
        private final int y;
        private final int t;
        int g = Integer.MAX_VALUE;
        int f = Integer.MAX_VALUE;
        final int h;
        private Node parent;
        public Node(int x, int y, int t){
            this.x = x;
            this.y = y;
            this.t = t;
            h = Math.abs(x-endx)+Math.abs(y-endy);
        }
    }
    private static enum Direction{
        UP(0,-1),
        RIGHT(1,0),
        DOWN(0,1),
        LEFT(-1,0),
        NONE(0,0);
        private final int dx;
        private final int dy;
        private Direction(int dx, int dy){
            this.dx = dx;
            this.dy = dy;
        }
    }
}