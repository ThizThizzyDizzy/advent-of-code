package aoc2023.java.days;
import aoc2023.java.Day;
public class Day16 extends Day{
    private Tile[][] tiles;
    public Day16(){
        super(16);
    }
    @Override
    public void run(){
        String[] lines = input.split("\n");
        tiles = new Tile[lines[0].length()][lines.length];
        for(int y = 0; y<lines.length; y++){
            for(int x = 0; x<lines[y].length(); x++){
                tiles[x][y] = new Tile(x, y, lines[y].charAt(x));
            }
        }
        energizeTile(0,0,1,0);
        int max = count();
        System.out.println(max);
        for(int x = 0; x<tiles.length; x++){
            reset();
            energizeTile(x, 0, 0, 1);
            max = Math.max(max, count());
            reset();
            energizeTile(x, tiles[0].length-1, 0, -1);
            max = Math.max(max, count());
        }
        for(int y = 0; y<tiles[0].length; y++){
            reset();
            energizeTile(0, y, 1, 0);
            max = Math.max(max, count());
            reset();
            energizeTile(tiles.length-1, y, -1, 0);
            max = Math.max(max, count());
        }
        System.out.println(max);
    }
    private void reset(){
        for(Tile[] col : tiles){
            for(Tile t : col)t.energized = new boolean[4];
        }
    }
    private int count(){
        int total = 0;
        for(Tile[] col : tiles){
            for(Tile tile : col){
                for(boolean b : tile.energized){
                    if(b){
                        total++;
                        break;
                    }
                }
            }
        }
        return total;
    }
    private void energizeTile(int x, int y, int dx, int dy){
        if(x<0||y<0)return;
        if(x>=tiles.length)return;
        if(y>=tiles[x].length)return;
        tiles[x][y].energize(dx, dy);
    }
    private class Tile{
        private final int x;
        private final int y;
        private final char c;
        private boolean[] energized = new boolean[4];
        public Tile(int x, int y, char c){
            this.x = x;
            this.y = y;
            this.c = c;
        }
        private void energize(int dx, int dy){
            int dirIdx = -1;
            if(dy<0)dirIdx = 0;
            if(dx>0)dirIdx = 1;
            if(dy>0)dirIdx = 2;
            if(dx<0)dirIdx = 3;
            if(energized[dirIdx])return;
            energized[dirIdx] = true;
            switch(c){
                case '.':
                    energizeTile(x+dx,y+dy,dx,dy);
                    break;
                case '/':
                    energizeTile(x-dy, y-dx, -dy, -dx);
                    break;
                case '\\':
                    energizeTile(x+dy, y+dx, dy, dx);
                    break;
                case '-':
                case '|':
                    boolean split = false;
                    if(c=='-')split = dx==0;
                    if(c=='|')split = dy==0;
                    if(split){
                        energizeTile(x+dy,y+dx,dy,dx);
                        energizeTile(x-dy,y-dx,-dy,-dx);
                    }else{
                        energizeTile(x+dx,y+dy,dx,dy);
                    }
                    break;
            }
        }
    }
}