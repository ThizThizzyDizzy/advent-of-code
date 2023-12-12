package aoc2023.java.days;
import aoc2023.java.Day;
import java.util.ArrayList;
public class Day10 extends Day{
    public Day10(){
        super(10);
    }
    char[][] map;
    int startX, startY, posX, posY, lastX, lastY;
    ArrayList<Point> loop = new ArrayList<>();
    ArrayList<Point> interiorChecks = new ArrayList<>();
    @Override
    public void run(){
        String[] rows = input.split("\n");
        map = new char[rows[0].length()][rows.length];
        for(int y = 0; y<rows.length; y++){
            for(int x = 0; x<rows[y].length(); x++){
                map[x][y] = rows[y].charAt(x);
            }
        }
        for(int x = 0; x<map.length; x++){
            for(int y = 0; y<map[x].length; y++){
                if(map[x][y]=='S'){
                    startX = x;
                    startY = y;
                    //assume it's not on the edge; it wasn't for me, so it's fine(tm)
                    boolean north = getPipe(x, y-1).s;
                    boolean east = getPipe(x+1, y).w;
                    boolean south = getPipe(x, y+1).n;
                    boolean west = getPipe(x-1, y).e;
                    for(Pipe p : Pipe.values()){
                        if(north==p.n&&east==p.e&&south==p.s&&west==p.w){
                            map[x][y] = p.c;
                        }
                    }
                }
            }
        }
        lastX = posX = startX;
        lastY = posY = startY;
        int i = 0;
        while(march())i++;
        System.out.println(i/2);
        validateInterior();
        boolean somethingChanged;
        do{
            somethingChanged = false;
            int prevQuantity = interiorChecks.size();
            ArrayList<Point> newInterior = new ArrayList<>();
            for(Point p : interiorChecks){
                for(int dx = -1; dx<=1; dx++){
                    for(int dy = -1; dy<=1; dy++){
                        newInterior.add(new Point(p.x+dx, p.y+dy));
                    }
                }
            }
            interiorChecks = newInterior;
            validateInterior();
            if(interiorChecks.size()>prevQuantity)somethingChanged = true;
        }while(somethingChanged);
        System.out.println(interiorChecks.size());
    }
    private void validateInterior(){
        ArrayList<Point> newInteriorChecks = new ArrayList<>();
        for(Point check : interiorChecks){
            if(loop.contains(check))continue;
            if(newInteriorChecks.contains(check))continue;
            newInteriorChecks.add(check);
        }
        interiorChecks = newInteriorChecks;
    }
    private Pipe getPipe(int x, int y){
        try{
            for(Pipe p : Pipe.values()){
                if(p.c==map[x][y])return p;
            }
        }catch(IndexOutOfBoundsException ex){}
        return Pipe.NONE;
    }
    private boolean march(){
        int fromX = lastX;
        int fromY = lastY;
        Pipe pipe = getPipe(posX,posY);
        if(posX==startX&&posY==startY&&(startX!=fromX||startY!=fromY))return false;
        lastX = posX;
        lastY = posY;
        loop.add(new Point(lastX,lastY));
        if(pipe.n&&(fromY>=posY))posY--;
        else if(pipe.e&&(fromX<=posX))posX++;
        else if(pipe.s&&(fromY<=posY))posY++;
        else if(pipe.w&&(fromX>=posX))posX--;
        boolean goingNorth = posY<lastY;
        boolean goingEast = posX>lastX;
        boolean goingSouth = posY>lastY;
        boolean goingWest = posX<lastX;
        boolean reversePipe = false;
        if(pipe.n)reversePipe = !goingNorth;
        else if(pipe.e)reversePipe = !goingEast;
        else if(pipe.s)reversePipe = !goingSouth;
        else if(pipe.w)reversePipe = !goingWest;
        int inX = reversePipe?pipe.lx:pipe.rx;
        int inY = reversePipe?pipe.ly:pipe.ry;
        interiorChecks.add(new Point(lastX+inX,lastY+inY));
        //catch elbow bends, duplicate the rest, eh I don't care lol
        if(inX!=0)interiorChecks.add(new Point(lastX+inX,lastY));
        if(inY!=0)interiorChecks.add(new Point(lastX,lastY+inY));
        return true;
    }
    private static enum Pipe{
        VERT('|', true, false, true, false, 1, 0, -1, 0),
        HORIZ('-', false, true, false, true, 0, 1, 0, -1),
        NE('L', true, true, false, false, 1, -1, -1, 1),
        NW('J', true, false, false, true, 1, 1, -1, -1),
        SW('7', false, false, true, true, -1, 1, 1, -1),
        SE('F', false, true, true, false, 1, 1, -1, -1),
        NONE('.', false, false, false, false, 0, 0, 0, 0);
        private final char c;
        private final boolean n;
        private final boolean e;
        private final boolean s;
        private final boolean w;
        private final int rx;
        private final int ry;
        private final int lx;
        private final int ly;
        private Pipe(char c, boolean n, boolean e, boolean s, boolean w, int rx, int ry, int lx, int ly){
            this.c = c;
            this.n = n;
            this.e = e;
            this.s = s;
            this.w = w;
            this.rx = rx;
            this.ry = ry;
            this.lx = lx;
            this.ly = ly;
        }
    }
    private static class Point{
        private final int x;
        private final int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Point p){
                return p.x==x&&p.y==y;
            }
            return false;
        }
    }
}