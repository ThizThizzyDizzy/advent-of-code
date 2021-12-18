package com.thizthizzydizzy.aoc2021;
import java.util.ArrayList;
import java.util.Stack;
public class Day18 implements Day{
    @Override
    public void run(){
        String input = """
                       [[2,[[4,8],7]],[[9,7],[[2,0],9]]]
                       [0,[7,5]]
                       [[[5,[6,9]],4],[3,3]]
                       [[[6,[6,9]],4],[[[4,8],8],[6,5]]]
                       [[[[1,4],[2,1]],[6,0]],[[[9,1],[4,2]],[[0,4],0]]]
                       [[9,4],[[8,6],1]]
                       [[[[0,7],0],7],[1,[2,9]]]
                       [[[2,9],[[8,4],[4,0]]],[[[6,2],2],[9,5]]]
                       [[[0,[5,8]],[6,8]],[[[0,7],4],[[2,8],4]]]
                       [[3,[[4,1],[0,7]]],[[1,[5,1]],4]]
                       [[[[2,9],6],[[5,3],2]],[[8,[2,0]],9]]
                       [0,[[[2,7],9],[1,8]]]
                       [[[2,[6,2]],[[4,0],[9,6]]],[[6,1],[8,9]]]
                       [[[[9,6],9],[5,[1,8]]],[[[9,6],9],[[2,0],[3,8]]]]
                       [[[[4,3],[0,8]],4],[6,6]]
                       [[[[4,3],7],[[7,0],5]],[2,[[9,9],4]]]
                       [[[[4,3],[1,7]],[[3,1],[0,9]]],0]
                       [[5,[[2,5],[2,8]]],[[4,0],[[5,2],[9,8]]]]
                       [[[0,[3,5]],7],[[[5,9],2],4]]
                       [[9,[[4,4],8]],[[[2,8],1],[[0,9],5]]]
                       [[[6,8],[0,1]],[[8,2],[2,0]]]
                       [[[1,9],[[9,1],2]],[[6,4],[[7,7],[8,3]]]]
                       [[1,[5,[7,6]]],[[[4,7],4],5]]
                       [[[8,0],9],[[[6,0],4],1]]
                       [[[4,[4,2]],7],[[6,[0,9]],[[3,0],[7,6]]]]
                       [[[[3,4],[9,0]],[4,4]],[[9,6],7]]
                       [4,[[8,3],[7,1]]]
                       [6,[6,8]]
                       [[[[0,6],[7,6]],[5,3]],[[[8,9],[6,0]],[[8,5],7]]]
                       [[[[0,3],1],5],[[[4,3],[3,2]],[2,[5,9]]]]
                       [[[[3,1],0],[1,[8,4]]],[4,5]]
                       [[[0,[4,1]],1],[[1,6],[[4,8],[8,3]]]]
                       [[[1,4],6],[9,[1,2]]]
                       [[9,[[0,7],1]],[[0,9],[0,[4,4]]]]
                       [[1,[7,4]],[[2,[5,3]],[[6,6],9]]]
                       [0,[0,[0,[0,4]]]]
                       [[[[9,7],[4,9]],[9,[3,5]]],[[9,7],7]]
                       [5,[9,[[4,1],[2,9]]]]
                       [[0,[8,4]],1]
                       [[[9,[3,3]],[8,6]],[7,[[1,6],0]]]
                       [[[1,[0,7]],[[9,1],8]],[[[2,2],5],[[7,1],[2,2]]]]
                       [[[7,[0,3]],4],[[6,[1,6]],[8,7]]]
                       [[[[4,8],3],[[6,1],7]],[8,[3,[7,8]]]]
                       [3,[[[9,6],9],3]]
                       [[[5,[1,0]],[1,4]],5]
                       [[[[4,7],2],[[7,0],[6,7]]],[[1,[0,3]],0]]
                       [9,[[3,7],[6,1]]]
                       [[[2,5],[[0,7],[0,7]]],[[[0,3],2],8]]
                       [[[[4,4],7],[2,[0,7]]],[[[1,4],[6,6]],[[8,9],[5,2]]]]
                       [[[[0,8],5],[[3,5],7]],[[[5,6],[0,0]],[[3,8],6]]]
                       [4,[8,[9,[2,3]]]]
                       [[[[6,6],9],0],[[[2,9],[0,8]],5]]
                       [[[8,[4,0]],[[2,1],[7,3]]],[8,7]]
                       [[6,[9,[1,8]]],[[7,[7,9]],[[2,3],1]]]
                       [[6,[[1,7],1]],[[[5,3],[2,0]],[[4,4],9]]]
                       [[[[8,0],[0,3]],[[4,8],[0,9]]],[8,[7,[8,6]]]]
                       [6,0]
                       [[[[5,2],0],[3,3]],[0,4]]
                       [[[9,5],[6,4]],[[[7,2],0],8]]
                       [[[0,9],[5,[2,3]]],2]
                       [[[[5,4],[2,9]],[1,[9,0]]],[[9,9],[9,6]]]
                       [[[7,[4,8]],[9,8]],[[[1,3],0],[4,[4,7]]]]
                       [[7,[7,9]],0]
                       [[[[6,7],[8,1]],[[0,2],2]],[[[7,6],6],[[3,4],[9,9]]]]
                       [[7,[6,[2,2]]],[[[8,8],[0,4]],[5,[7,7]]]]
                       [[[[0,6],[9,2]],[8,1]],[[[0,4],2],[[5,9],[4,9]]]]
                       [[[[9,1],[1,7]],[[3,1],[0,7]]],[[2,[4,9]],[9,1]]]
                       [[[9,4],2],[[[2,3],3],[6,[5,7]]]]
                       [[[0,8],[[0,9],2]],[[[0,7],[4,4]],7]]
                       [[[5,2],4],[0,6]]
                       [[3,[9,[9,2]]],[8,[1,[6,8]]]]
                       [3,[7,[[8,0],[1,7]]]]
                       [[[[2,4],[7,3]],[[0,7],0]],5]
                       [[[[6,0],8],[1,4]],[[[3,3],[8,6]],5]]
                       [[5,[5,[6,2]]],4]
                       [[[0,7],[[4,1],4]],[[8,[3,2]],[7,7]]]
                       [[1,[[6,5],[2,2]]],[[6,[2,8]],[1,0]]]
                       [6,[4,[[2,2],[1,8]]]]
                       [[[[3,3],1],[[4,1],7]],[[[5,2],7],[4,[4,7]]]]
                       [[[[2,2],1],[[4,1],3]],[1,[[0,9],[3,8]]]]
                       [[0,[0,4]],[[9,[7,5]],[8,[8,0]]]]
                       [[[[0,3],3],[[7,3],5]],[4,[[0,1],[3,0]]]]
                       [[4,8],3]
                       [[[6,0],7],[[6,8],[8,6]]]
                       [[[[8,5],3],[[6,2],[2,6]]],[[[2,7],5],[[3,8],[6,9]]]]
                       [7,[4,2]]
                       [[[[6,0],[7,8]],6],[[[4,6],6],7]]
                       [[[0,[2,1]],[5,[3,8]]],[[[3,9],3],[[0,9],3]]]
                       [[[8,6],[4,0]],[2,[[4,1],8]]]
                       [[[0,1],[[2,0],5]],[[[0,1],[7,0]],[[1,2],[1,4]]]]
                       [[[8,8],[[4,4],3]],[1,[4,1]]]
                       [[[5,[0,7]],[7,5]],[[7,6],[5,5]]]
                       [[[9,[1,3]],[[3,3],6]],[4,[[5,6],8]]]
                       [[[9,[3,0]],[8,5]],[1,[[8,0],3]]]
                       [[[3,[3,9]],[[2,4],[4,6]]],[[1,2],3]]
                       [[[1,[3,1]],[3,[6,3]]],[1,[5,7]]]
                       [[[[5,5],[1,5]],3],[9,[[7,4],[9,2]]]]
                       [[[6,[7,1]],[[6,6],[1,6]]],7]
                       [[[[1,4],0],[8,3]],[[[8,2],9],[[0,3],[9,5]]]]
                       [[4,[1,[0,1]]],[[1,[7,3]],1]]""";
//        input = """
//                [[[0,[4,5]],[0,0]],[[[4,5],[2,6]],[9,5]]]
//                [7,[[[3,7],[4,3]],[[6,3],[8,8]]]]""";
        System.out.println("Part one");
        ArrayList<SnailfishNumber> homework = new ArrayList<>();
        for(String sfn : input.split("\n")){
            Stack<SnailfishNumber> numbers = new Stack<>();
            for(char c : sfn.toCharArray()){
                if(c=='[')numbers.push(new SnailfishNumber());
                if(Character.isDigit(c)){
                    int val = Integer.parseInt(c+"");
                    SnailfishNumber num = numbers.peek();
                    if(!num.hasLeft){
                        num.hasLeft = true;
                        num.left = val;
                    }else if(!num.hasRight){
                        num.hasRight = true;
                        num.right = val;
                    }else throw new IllegalArgumentException("Cannot create a Snailfish number with 3 parts!");
                }
                if(c==']'){
                    SnailfishNumber val = numbers.pop();
                    if(numbers.isEmpty()){
                        homework.add(val);
                        break;
                    }
                    if(!val.hasLeft&&!val.hasRight)throw new IllegalArgumentException("Cannot create an incomplete snailfish number!");
                    SnailfishNumber num = numbers.peek();
                    if(!num.hasLeft){
                        num.hasLeft = true;
                        num.leftsfn = val;
                        val.isLeft = true;
                        val.parent = num;
                    }else if(!num.hasRight){
                        num.hasRight = true;
                        num.rightsfn = val;
                        val.isRight = true;
                        val.parent = num;
                    }else throw new IllegalArgumentException("Cannot create a Snailfish number with 3 parts!");
                }
            }
        }
        while(homework.size()>1){
            SnailfishNumber num = new SnailfishNumber(homework.remove(0), homework.remove(0));
            num.reduce();
            homework.add(0, num);
        }
//        System.out.println(homework.get(0).toString());
        System.out.println(homework.get(0).getMagnitude());
        System.out.println("Part two");
        homework = new ArrayList<>();
        for(String sfn : input.split("\n")){
            Stack<SnailfishNumber> numbers = new Stack<>();
            for(char c : sfn.toCharArray()){
                if(c=='[')numbers.push(new SnailfishNumber());
                if(Character.isDigit(c)){
                    int val = Integer.parseInt(c+"");
                    SnailfishNumber num = numbers.peek();
                    if(!num.hasLeft){
                        num.hasLeft = true;
                        num.left = val;
                    }else if(!num.hasRight){
                        num.hasRight = true;
                        num.right = val;
                    }else throw new IllegalArgumentException("Cannot create a Snailfish number with 3 parts!");
                }
                if(c==']'){
                    SnailfishNumber val = numbers.pop();
                    if(numbers.isEmpty()){
                        homework.add(val);
                        break;
                    }
                    if(!val.hasLeft&&!val.hasRight)throw new IllegalArgumentException("Cannot create an incomplete snailfish number!");
                    SnailfishNumber num = numbers.peek();
                    if(!num.hasLeft){
                        num.hasLeft = true;
                        num.leftsfn = val;
                        val.isLeft = true;
                        val.parent = num;
                    }else if(!num.hasRight){
                        num.hasRight = true;
                        num.rightsfn = val;
                        val.isRight = true;
                        val.parent = num;
                    }else throw new IllegalArgumentException("Cannot create a Snailfish number with 3 parts!");
                }
            }
        }
        long magnitude = 0;
        for(int i = 0; i<homework.size(); i++){
            SnailfishNumber sn1 = homework.get(i);
            for(int j = 0; j<homework.size(); j++){
                SnailfishNumber sn2 = homework.get(j);
                SnailfishNumber num = new SnailfishNumber(sn1.copy(), sn2.copy());
                num.reduce();
                magnitude = Math.max(magnitude, num.getMagnitude());
            }
        }
        System.out.println(magnitude);
    }
    private static class SnailfishNumber{
        int left, right;
        SnailfishNumber leftsfn, rightsfn, parent;
        boolean hasLeft, hasRight;
        boolean isLeft, isRight;
        private SnailfishNumber(){}
        private SnailfishNumber(int l, int r){
            hasLeft = hasRight = true;
            left = l;
            right = r;
        }
        private SnailfishNumber(int l, SnailfishNumber r){
            hasLeft = hasRight = true;
            r.isRight = true;
            left = l;
            rightsfn = r;
            r.parent = this;
        }
        private SnailfishNumber(SnailfishNumber l, int r){
            hasLeft = hasRight = true;
            l.isLeft = true;
            leftsfn = l;
            right = r;
        }
        private SnailfishNumber(SnailfishNumber l, SnailfishNumber r){
            hasLeft = hasRight = true;
            r.isRight = true;
            l.isLeft = true;
            leftsfn = l;
            rightsfn = r;
            l.parent = this;
            r.parent = this;
        }
        public void reduce(){
            boolean somethingHappened;
            do{
                somethingHappened = false;
                if(tryExplode(0))somethingHappened = true;
                else if(trySplit())somethingHappened = true;
//                System.err.println(toString());
            }while(somethingHappened);
        }
        public boolean tryExplode(int depth){
            if(depth==4){
                explode();
                return true;
            }else{
                if(leftsfn!=null)if(leftsfn.tryExplode(depth+1))return true;
                if(rightsfn!=null)if(rightsfn.tryExplode(depth+1))return true;
            }
            return false;
        }
        public boolean trySplit(){
            if(leftsfn!=null){
                if(leftsfn.trySplit())return true;
            }else if(left>9){
                leftsfn = split(left);
                leftsfn.isLeft = true;
                leftsfn.parent = this;
                left = 0;
                return true;
            }
            if(rightsfn!=null){
                if(rightsfn.trySplit())return true;
            }else if(right>9){
                rightsfn = split(right);
                rightsfn.isRight = true;
                rightsfn.parent = this;
                right = 0;
                return true;
            }
            return false;
        }
        private void explode(){
//            if(leftsfn!=null){
//                leftsfn.explode();
//                return;
//            }
//            if(rightsfn!=null){
//                rightsfn.explode();
//                return;
//            }
//            System.out.println("explode");
            if(leftsfn!=null||rightsfn!=null)throw new IllegalArgumentException("Cannot explode a snailfish number that contains snailfish numbers!");
            parent.incrementLeft(this, left);
            parent.incrementRight(this, right);
            if(isLeft)parent.leftsfn = null;
            if(isRight)parent.rightsfn = null;
        }
        private SnailfishNumber split(int num){
//            System.out.println("split");
            return new SnailfishNumber(num/2, num-num/2);
        }
        private void incrementLeft(SnailfishNumber num, int val){
            if(num==null){
                if(leftsfn!=null)leftsfn.incrementLeft(null, val);
                else left+=val;
            }else if(num.isRight){
                if(leftsfn!=null)leftsfn.incrementRight(null, val);
                else left+=val;
            }else{
                if(parent!=null)parent.incrementLeft(this, val);
            }
        }
        private void incrementRight(SnailfishNumber num, int val){
            if(num==null){
                if(rightsfn!=null)rightsfn.incrementRight(null, val);
                else right+=val;
            }else if(num.isLeft){
                if(rightsfn!=null)rightsfn.incrementLeft(null, val);
                else right+=val;
            }else{
                if(parent!=null)parent.incrementRight(this, val);
            }
        }
        private long getMagnitude(){
            return 3*(leftsfn==null?left:leftsfn.getMagnitude())+2*(rightsfn==null?right:rightsfn.getMagnitude());
        }
        @Override
        public String toString(){
            return "["+(leftsfn==null?left+"":leftsfn.toString())+","+(rightsfn==null?right+"":rightsfn.toString())+"]";
        }
        public SnailfishNumber copy(){
            SnailfishNumber number = new SnailfishNumber();
            number.left = left;
            number.right = right;
            number.leftsfn = leftsfn==null?null:leftsfn.copy();
            number.rightsfn = rightsfn==null?null:rightsfn.copy();
            number.hasLeft = hasLeft;
            number.hasRight = hasRight;
            number.isLeft = isLeft;
            number.isRight = isRight;
            if(number.leftsfn!=null)number.leftsfn.parent = number;
            if(number.rightsfn!=null)number.rightsfn.parent = number;
            return number;
        }
    }
}