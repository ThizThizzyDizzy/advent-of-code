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
        int numVisible = 0;
        for(var bs : visible){
            for(var b : bs){
                if(b)numVisible++;
            }
        }
        System.out.println(numVisible);
        int highest = 0;
        for(int y = 0; y<height; y++){
            for(int x = 0; x<width; x++){
                int tree = trees[y][x];
                int top = 0, right = 0, bottom = 0, left = 0;
                for(int i = 1; i<Math.max(width, height); i++){//all four directions at once! fancy!
                    if(top<=0&&i<=y){//top
                        int other = trees[y-i][x];
                        top--;
                        if(other>=tree)top*=-1;//make it positive; stop checking
                    }
                    if(left<=0&&i<=x){//left
                        int other = trees[y][x-i];
                        left--;
                        if(other>=tree)left*=-1;//make it positive; stop checking
                    }
                    if(bottom<=0&&i+y<height){
                        int other = trees[y+i][x];
                        bottom--;
                        if(other>=tree)bottom*=-1;//make it positive; stop checking
                    }
                    if(right<=0&&i+x<width){
                        int other = trees[y][x+i];
                        right--;
                        if(other>=tree)right*=-1;//make it positive; stop checking
                    }
                }
                if(top<0)top*=-1;
                if(right<0)right*=-1;
                if(left<0)left*=-1;
                if(bottom<0)bottom*=-1;
                int score = top*right*bottom*left;
                if(score>highest)highest = score;
            }
        }
        System.out.println(highest);
    }
}