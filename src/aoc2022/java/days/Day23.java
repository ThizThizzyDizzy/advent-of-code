package aoc2022.java.days;
import aoc2022.java.Day;
import java.util.ArrayList;
import java.util.HashSet;
public class Day23 extends Day{
    public Day23(){
        super(23);
    }
    ArrayList<Elf> elves = new ArrayList<>();
    @Override
    public void run(){
        int y = 0;
        for(String s : input.split("\n")){
            for(int x = 0; x<s.length(); x++){
                if(s.charAt(x)=='#')elves.add(new Elf(x, y));
            }
            y++;
        }
        for(int i = 0; i<10; i++){
            processRound();
        }
        printMap(elves, true);
    }
    ArrayList<ElfMoveOption> options = new ArrayList<>();
    {
        options.add(new ElfMoveOption(0, -1){
            @Override
            public boolean isValid(boolean n, boolean ne, boolean e, boolean se, boolean s, boolean sw, boolean w, boolean nw) {
                return !n&&!ne&&!nw;
            }
        });
        options.add(new ElfMoveOption(0, 1){
            @Override
            public boolean isValid(boolean n, boolean ne, boolean e, boolean se, boolean s, boolean sw, boolean w, boolean nw) {
                return !s&&!se&&!sw;
            }
        });
        options.add(new ElfMoveOption(-1, 0){
            @Override
            public boolean isValid(boolean n, boolean ne, boolean e, boolean se, boolean s, boolean sw, boolean w, boolean nw) {
                return !w&&!nw&&!sw;
            }
        });
        options.add(new ElfMoveOption(1, 0){
            @Override
            public boolean isValid(boolean n, boolean ne, boolean e, boolean se, boolean s, boolean sw, boolean w, boolean nw) {
                return !e&&!ne&&!se;
            }
        });
    }
    private void processRound(){
//        cache.clear();
        ArrayList<ElfMove> moves = new ArrayList<>();
        for(Elf elf : elves){
            boolean n = getElf(elf.x, elf.y-1)!=null;
            boolean ne = getElf(elf.x+1, elf.y-1)!=null;
            boolean e = getElf(elf.x+1, elf.y)!=null;
            boolean se = getElf(elf.x+1, elf.y+1)!=null;
            boolean s = getElf(elf.x, elf.y+1)!=null;
            boolean sw = getElf(elf.x-1, elf.y+1)!=null;
            boolean w = getElf(elf.x-1, elf.y)!=null;
            boolean nw = getElf(elf.x-1, elf.y-1)!=null;
            int total = (n?1:0)+(ne?1:0)+(e?1:0)+(se?1:0)+(s?1:0)+(sw?1:0)+(w?1:0)+(nw?1:0);
            if(total==0)continue;//don't do anything this round
            ElfMoveOption chosen = null;
            for(ElfMoveOption option : options){
                if(option.isValid(n, ne, e, se, s, sw, w, nw)){
                    chosen = option;
                    break;
                }
            }
            if(chosen!=null)moves.add(new ElfMove(elf, chosen));
        }
        HashSet<ElfMove> badMoves = new HashSet<>();
        for(ElfMove move : moves){
            if(badMoves.contains(move))continue;
            for(ElfMove otherMoreDifferentMove : moves){
                if(move==otherMoreDifferentMove)continue;
                if(move.toX==otherMoreDifferentMove.toX&&move.toY==otherMoreDifferentMove.toY){
                    badMoves.add(move);
                    badMoves.add(otherMoreDifferentMove);
                }
            }
        }
        moves.removeAll(badMoves);
        for(ElfMove move : moves){
            move.elf.x = move.toX;
            move.elf.y = move.toY;
        }
        options.add(options.remove(0));
    }
    private Elf getElf(int x, int y){
        for(Elf elf : elves){
            if(elf.x==x&&elf.y==y){
                return elf;
            }
        }
        return null;
    }
    private void printMap(ArrayList<Elf> elves, boolean justGiveMeTheActualAnswer){
        int minx = Integer.MAX_VALUE, miny = minx, maxx = Integer.MIN_VALUE, maxy = maxx;
        for(Elf elf : elves){
            if(elf.x<minx)minx = elf.x;
            if(elf.y<miny)miny = elf.y;
            if(elf.x>maxx)maxx = elf.x;
            if(elf.y>maxy)maxy = elf.y;
        }
        int blank = 0;
        for(int y = miny; y<=maxy; y++){
            for(int x = minx; x<=maxx; x++){
                boolean hasElf = getElf(x, y)!=null;
                if(justGiveMeTheActualAnswer){
                    if(!hasElf)blank++;
                }else{
                    if(getElf(x, y)!=null)System.out.print('#');
                    else System.out.print('.');
                }
            }
            if(!justGiveMeTheActualAnswer)System.out.println();
        }
        if(justGiveMeTheActualAnswer)System.out.println(blank);
    }
    private static class Elf{
        private int x;
        private int y;
        public Elf(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static abstract class ElfMoveOption{
        private final int dx;
        private final int dy;
        public ElfMoveOption(int dx, int dy){
            this.dx = dx;
            this.dy = dy;
        }
        public abstract boolean isValid(boolean n, boolean ne, boolean e, boolean se, boolean s, boolean sw, boolean w, boolean nw);
    }
    private static class ElfMove{
        private final Elf elf;
        private final int toX, toY;
        public ElfMove(Elf elf, ElfMoveOption chosen){
            this.elf = elf;
            toX = elf.x+chosen.dx;
            toY = elf.y+chosen.dy;
        }
    }
}