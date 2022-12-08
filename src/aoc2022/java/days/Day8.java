package aoc2022.java.days;
import aoc2022.java.Day;
public class Day8 extends Day{
    public Day8(){
        super(8);
    }
    @Override
    public void run() {
        String[] rows = input.split("\n");
        int height = rows.length;
        int width = rows[0].length();
        int[][] trees = new int[height][width];
        for(int y = 0; y < height; y++){
            var row = rows[y].toCharArray();
            for (int x = 0; x < width; x++) {
                trees[y][x] = Integer.parseInt(row[x]+"");
            }
        }
        boolean[][] visible = new boolean[height][width];
        //lateral
        for(int y = 0; y<height; y++){
            //left
            int tallest = -1;
            for(int x = 0; x<width; x++){
                int tree = trees[y][x];
                if(tree>tallest){
                    visible[y][x] = true;
                    tallest = tree;
                }
            }
            //right
            tallest = -1;
            for(int x = width-1; x>=0; x--){
                int tree = trees[y][x];
                if(tree>tallest){
                    visible[y][x] = true;
                    tallest = tree;
                }
            }
        }
        //vertical
        for(int x = 0; x<width; x++){
            //left
            int tallest = -1;
            for(int y = 0; y<height; y++){
                int tree = trees[y][x];
                if(tree>tallest){
                    visible[y][x] = true;
                    tallest = tree;
                }
            }
            //right
            tallest = -1;
            for(int y = height-1; y>=0; y--){
                int tree = trees[y][x];
                if(tree>tallest){
                    visible[y][x] = true;
                    tallest = tree;
                }
            }
        }
        int i = 0;
        for(var bs : visible){
            for(var b : bs){
                if(b)i++;
            }
        }
        System.out.println(i);
    }
}