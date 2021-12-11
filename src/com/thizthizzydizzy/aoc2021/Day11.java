package com.thizthizzydizzy.aoc2021;
public class Day11 implements Day{
    @Override
    public void run(){
        String input = """
                       5651341452
                       1381541252
                       1878435224
                       6814831535
                       3883547383
                       6473548464
                       1885833658
                       3732584752
                       1881546128
                       5121717776""";
        System.out.println("Part one");
        String[] rows = input.split("\n");
        DumboOctopus[][] octopuses = new DumboOctopus[rows[0].length()][rows.length];
        for(int y = 0; y<rows.length; y++){
            String row = rows[y];
            for(int x = 0; x<row.length(); x++){
                int i = Integer.parseInt(row.charAt(x)+"");
                octopuses[x][y] = new DumboOctopus(x, y, i);
            }
        }
        int flashes = 0;
        for(int i = 0; i<10000; i++){
            int theseFlashes = 0;
            for(int y = 0; y<octopuses.length; y++){
                DumboOctopus[] octopuse = octopuses[y];
                for(int x = 0; x<octopuse.length; x++){
                    DumboOctopus octo = octopuse[x];
                    theseFlashes+=octo.tick(octopuses);
                }
            }
            for(int y = 0; y<octopuses.length; y++){
                DumboOctopus[] octopuse = octopuses[y];
                for(int x = 0; x<octopuse.length; x++){
                    DumboOctopus octo = octopuse[x];
                    octo.finishTick();
                }
            }
            flashes+=theseFlashes;
            if(i==99){
                System.out.println(flashes);
                System.out.println("Part two");
            }
            if(theseFlashes==100){
                System.out.println(i+1);
                break;
            }
        }
    }
    private static class DumboOctopus{
        private final int y;
        private int level;
        private final int x;
        private boolean flashed = false;
        public DumboOctopus(int x, int y, int level){
            this.y = y;
            this.level = level;
            this.x = x;
        }
        public int tick(DumboOctopus[][] octos){
            level++;
            if(level>9&&!flashed){
                flashed = true;
                int flashes = 1;
                for(int dx = -1; dx<=1; dx++){
                    for(int dy = -1; dy<=1; dy++){
                        if(dx==0&&dy==0)continue;
                        int X = x+dx;
                        int Y = y+dy;
                        if(X<0||Y<0||X>9||Y>9)continue;
                        flashes+=octos[X][Y].tick(octos);
                    }
                }
                return flashes;
            }
            return 0;
        }
        public void finishTick(){
            if(flashed)level = 0;
            flashed = false;
        }
    }
}