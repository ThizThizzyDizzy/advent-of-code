package com.thizthizzydizzy.aoc2021;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
public class Day24 implements Day{
    @Override
    public void run(){
        String input = """
                       inp w
                       mul x 0
                       add x z
                       mod x 26
                       div z 1
                       add x 12
                       eql x w
                       eql x 0
                       mul y 0
                       add y 25
                       mul y x
                       add y 1
                       mul z y
                       mul y 0
                       add y w
                       add y 7
                       mul y x
                       add z y
                       inp w
                       mul x 0
                       add x z
                       mod x 26
                       div z 1
                       add x 11
                       eql x w
                       eql x 0
                       mul y 0
                       add y 25
                       mul y x
                       add y 1
                       mul z y
                       mul y 0
                       add y w
                       add y 15
                       mul y x
                       add z y
                       inp w
                       mul x 0
                       add x z
                       mod x 26
                       div z 1
                       add x 12
                       eql x w
                       eql x 0
                       mul y 0
                       add y 25
                       mul y x
                       add y 1
                       mul z y
                       mul y 0
                       add y w
                       add y 2
                       mul y x
                       add z y
                       inp w
                       mul x 0
                       add x z
                       mod x 26
                       div z 26
                       add x -3
                       eql x w
                       eql x 0
                       mul y 0
                       add y 25
                       mul y x
                       add y 1
                       mul z y
                       mul y 0
                       add y w
                       add y 15
                       mul y x
                       add z y
                       inp w
                       mul x 0
                       add x z
                       mod x 26
                       div z 1
                       add x 10
                       eql x w
                       eql x 0
                       mul y 0
                       add y 25
                       mul y x
                       add y 1
                       mul z y
                       mul y 0
                       add y w
                       add y 14
                       mul y x
                       add z y
                       inp w
                       mul x 0
                       add x z
                       mod x 26
                       div z 26
                       add x -9
                       eql x w
                       eql x 0
                       mul y 0
                       add y 25
                       mul y x
                       add y 1
                       mul z y
                       mul y 0
                       add y w
                       add y 2
                       mul y x
                       add z y
                       inp w
                       mul x 0
                       add x z
                       mod x 26
                       div z 1
                       add x 10
                       eql x w
                       eql x 0
                       mul y 0
                       add y 25
                       mul y x
                       add y 1
                       mul z y
                       mul y 0
                       add y w
                       add y 15
                       mul y x
                       add z y
                       inp w
                       mul x 0
                       add x z
                       mod x 26
                       div z 26
                       add x -7
                       eql x w
                       eql x 0
                       mul y 0
                       add y 25
                       mul y x
                       add y 1
                       mul z y
                       mul y 0
                       add y w
                       add y 1
                       mul y x
                       add z y
                       inp w
                       mul x 0
                       add x z
                       mod x 26
                       div z 26
                       add x -11
                       eql x w
                       eql x 0
                       mul y 0
                       add y 25
                       mul y x
                       add y 1
                       mul z y
                       mul y 0
                       add y w
                       add y 15
                       mul y x
                       add z y
                       inp w
                       mul x 0
                       add x z
                       mod x 26
                       div z 26
                       add x -4
                       eql x w
                       eql x 0
                       mul y 0
                       add y 25
                       mul y x
                       add y 1
                       mul z y
                       mul y 0
                       add y w
                       add y 15
                       mul y x
                       add z y
                       inp w
                       mul x 0
                       add x z
                       mod x 26
                       div z 1
                       add x 14
                       eql x w
                       eql x 0
                       mul y 0
                       add y 25
                       mul y x
                       add y 1
                       mul z y
                       mul y 0
                       add y w
                       add y 12
                       mul y x
                       add z y
                       inp w
                       mul x 0
                       add x z
                       mod x 26
                       div z 1
                       add x 11
                       eql x w
                       eql x 0
                       mul y 0
                       add y 25
                       mul y x
                       add y 1
                       mul z y
                       mul y 0
                       add y w
                       add y 2
                       mul y x
                       add z y
                       inp w
                       mul x 0
                       add x z
                       mod x 26
                       div z 26
                       add x -8
                       eql x w
                       eql x 0
                       mul y 0
                       add y 25
                       mul y x
                       add y 1
                       mul z y
                       mul y 0
                       add y w
                       add y 13
                       mul y x
                       add z y
                       inp w
                       mul x 0
                       add x z
                       mod x 26
                       div z 26
                       add x -10
                       eql x w
                       eql x 0
                       mul y 0
                       add y 25
                       mul y x
                       add y 1
                       mul z y
                       mul y 0
                       add y w
                       add y 13
                       mul y x
                       add z y""";
        String[] lines = input.split("\n");
        String[][] prog = new String[lines.length][];
        for(int i = 0; i<prog.length; i++){
            prog[i] = lines[i].split(" ");
        }
        System.out.println("Part one");
        //        //<editor-fold defaultstate="collapsed" desc="attempt 1">
//        int[] digits = new int[14];
//        for(int i = 0; i<digits.length; i++){
//            digits[i] = 9;
//        }
//        Queue<int[]> pending = new Queue<>();
//        Queue<int[]> results = new Queue<>();
//        boolean[] finished = new boolean[]{false};
//        for(int i = 0; i<12; i++){
//            if(true)continue;
//            new Thread(()->{
//                while(!finished[0]){
//                    int[] theInput = pending.dequeue();
//                    if(theInput==null)continue;
//                    int d = 0;
//                    if(runCode(theInput))results.enqueue(theInput);
//                }
//            }).start();
//        }
//        long lastPrint = System.nanoTime();
//        long numResults = 0;
//        long finalResult = 0;
//        long solution = -1;
//        N1:for(int n1 = 9; n1>0; n1--){
//            for(int n2 = 9; n2>0; n2--){
//                for(int n3 = 9; n3>0; n3--){
//                    for(int n4 = 9; n4>0; n4--){
//                        for(int n5 = 9; n5>0; n5--){
//                            for(int n6 = 9; n6>0; n6--){
//                                for(int n7 = 9; n7>0; n7--){
//                                    for(int n8 = 9; n8>0; n8--){
//                                        for(int n9 = 9; n9>0; n9--){
//                                            for(int n10 = 9; n10>0; n10--){
//                                                for(int n11 = 9; n11>0; n11--){
//                                                    for(int n12 = 9; n12>0; n12--){
//                                                        for(int n13 = 9; n13>0; n13--){
//                                                            for(int n14 = 9; n14>0; n14--){
//                                                                if(runCode(n14,n13,n12,n11,n10,n9,n8,n7,n6,n5,n4,n3,n2,n1)){
//                                                                    solution = Long.parseLong(n1+""+n2+""+n3+""+n4+""+n5+""+n6+""+n7+""+n8+""+n9+""+n10+""+n11+""+n12+""+n13+""+n14);
//                                                                    System.out.println("SOLUTION");
//                                                                    break N1;
//                                                                }
//                                                            }
//                                                        }
//                                                        return;
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(solution);
////        WHILE:while(true){
//////            int[] theInput = new int[digits.length];
//////            for(int i = 0; i<digits.length; i++){
//////                theInput[i] = digits[i];
//////            }
////            long diff = System.nanoTime()-lastPrint;
////            if(diff>1_000_000_000){
////                System.out.println(numResults+" $ "+finalResult+" P "+pending.size()+" ("+((double)numResults/Math.pow(9,14))*100+"%)");
////                lastPrint = System.nanoTime();
////            }
//////            pending.enqueue(theInput);
////            numResults++;
////            if(runCode(digits)){
////                String resultStr = "";
////                for(int i : digits)resultStr+=i;
////                finalResult = Math.max(finalResult, Long.parseLong(resultStr));
////            }
////            for(int i = 0; i<digits.length; i++){
////                digits[i]--;
////                if(digits[i]<1){
////                    if(i==13)break WHILE;
////                    digits[i] = 9;
////                }
////                else break;
////            }
////        }
////        finished[0] = true;
//</editor-fold>
        HashMap<Integer, ArrayList<State>> data = new HashMap<>();
        for(int i = 0; i<14; i++){
            ArrayList<State> thisData;
            if(i==0){
                thisData = new ArrayList<>();
                thisData.add(new State(0, 0, 0, 0));
            }else{
                thisData = data.get(i-1);
            }
            ArrayList<State> newData = new ArrayList<>();
            for(State s : thisData){
                for(int n = 1; n<10; n++){
                    State s2 = runCode(i, n, s);
                    if(s2.z>100000||s2.z<-100000)continue;
                    s2.in[i] = n;
                    if(!newData.contains(s2))newData.add(s2);
                }
            }
            data.put(i, newData);
            System.out.println(i+" "+newData.size());
        }
        long max = 0;
        int results = 0;
        for(State s : data.get(13)){
            if(s.z==0){
                String val = "";
                for(int i : s.in)val+=i;
                long l = Long.parseLong(val);
                max = Math.max(max, l);
                results++;
            }
        }
        System.out.println(results+" results");
        System.out.println(max);
        System.out.println("Part two");
        State.invert = true;
        data = new HashMap<>();
        for(int i = 0; i<14; i++){
            ArrayList<State> thisData;
            if(i==0){
                thisData = new ArrayList<>();
                thisData.add(new State(0, 0, 0, 0));
            }else{
                thisData = data.get(i-1);
            }
            ArrayList<State> newData = new ArrayList<>();
            for(State s : thisData){
                for(int n = 1; n<10; n++){
                    State s2 = runCode(i, n, s);
                    if(s2.z>100000||s2.z<-100000)continue;
                    s2.in[i] = n;
                    if(!newData.contains(s2))newData.add(s2);
                }
            }
            data.put(i, newData);
            System.out.println(i+" "+newData.size());
        }
        long min = Long.MAX_VALUE;
        for(State s : data.get(13)){
            if(s.z==0){
                String val = "";
                for(int i : s.in)val+=i;
                long l = Long.parseLong(val);
                min = Math.min(min, l);
                results++;
            }
        }
        System.out.println(min);
    }
    private State runCode(int part, int in, State state){
        int w = state.w;
        int x = state.x;
        int y = state.y;
        int z = state.z;
        switch(part){
            case 0:
                w = in;
                x=z;
                x%=26;
                x+=12;
                x = x==w?0:1;
                y=25;
                y*=x;
                y++;
                z*=y;
                y=w;
                y+=7;
                y*=x;
                z+=y;
                break;
            case 1:
                w = in;
                x=z;
                x%=26;
                x+=11;
                x = x==w?0:1;
                y=25;
                y*=x;
                y++;
                z*=y;
                y=w;
                y+=15;
                y*=x;
                z+=y;
                break;
            case 2:
                w = in;
                x=z;
                x%=26;
                x+=12;
                x = x==w?0:1;
                y=25;
                y*=x;
                y++;
                z*=y;
                y=w;
                y+=2;
                y*=x;
                z+=y;
                break;
            case 3:
                w = in;
                x=z;
                x%=26;
                z/=26;
                x+=-3;
                x = x==w?0:1;
                y=25;
                y*=x;
                y++;
                z*=y;
                y=w;
                y+=15;
                y*=x;
                z+=y;
                break;
            case 4:
                w = in;
                x=z;
                x%=26;
                x+=10;
                x = x==w?0:1;
                y=25;
                y*=x;
                y++;
                z*=y;
                y=w;
                y+=14;
                y*=x;
                z+=y;
                break;
            case 5:
                w = in;
                x=z;
                x%=26;
                z/=26;
                x+=-9;
                x = x==w?0:1;
                y=25;
                y*=x;
                y++;
                z*=y;
                y=w;
                y+=2;
                y*=x;
                z+=y;
                break;
            case 6:
                w = in;
                x=z;
                x%=26;
                x+=10;
                x = x==w?0:1;
                y=25;
                y*=x;
                y++;
                z*=y;
                y=w;
                y+=15;
                y*=x;
                z+=y;
                break;
            case 7:
                w = in;
                x=z;
                x%=26;
                z/=26;
                x+=-7;
                x = x==w?0:1;
                y=25;
                y*=x;
                y++;
                z*=y;
                y=w;
                y++;
                y*=x;
                z+=y;
                break;
            case 8:
                w = in;
                x=z;
                x%=26;
                z/=26;
                x+=-11;
                x = x==w?0:1;
                y=25;
                y*=x;
                y++;
                z*=y;
                y=w;
                y+=15;
                y*=x;
                z+=y;
                break;
            case 9:
                w = in;
                x=z;
                x%=26;
                z/=26;
                x+=-4;
                x = x==w?0:1;
                y=25;
                y*=x;
                y++;
                z*=y;
                y=w;
                y+=15;
                y*=x;
                z+=y;
                break;
            case 10:
                w = in;
                x=z;
                x%=26;
                x+=14;
                x = x==w?0:1;
                y=25;
                y*=x;
                y++;
                z*=y;
                y=w;
                y+=12;
                y*=x;
                z+=y;
                break;
            case 11:
                w = in;
                x=z;
                x%=26;
                x+=11;
                x = x==w?0:1;
                y=25;
                y*=x;
                y++;
                z*=y;
                y=w;
                y+=2;
                y*=x;
                z+=y;
                break;
            case 12:
                w = in;
                x=z;
                x%=26;
                z/=26;
                x+=-8;
                x = x==w?0:1;
                y=25;
                y*=x;
                y++;
                z*=y;
                y=w;
                y+=13;
                y*=x;
                z+=y;
                break;
            case 13:
                w = in;
                x=z;
                x%=26;
                z/=26;
                x+=-10;
                x = x==w?0:1;
                y=25;
                y*=x;
                y++;
                z*=y;
                y=w;
                y+=13;
                y*=x;
                z+=y;
                break;
        }
        return new State(state, w, x, y, z);
    }
    private boolean runCode(int... in){
        int w = 0, x = 0, y = 0, z = 0;
        System.out.println();
        System.out.println(Arrays.toString(in));
        w = in[0];
        x=z;
        x%=26;
        x+=12;
        x = x==w?0:1;
        y=25;
        y*=x;
        y++;
        z*=y;
        y=w;
        y+=7;
        y*=x;
        z+=y;
        System.out.println("0 "+z);
        w = in[1];
        x=z;
        x%=26;
        x+=11;
        x = x==w?0:1;
        y=25;
        y*=x;
        y++;
        z*=y;
        y=w;
        y+=15;
        y*=x;
        z+=y;
        System.out.println("1 "+z);
        w = in[2];
        x=z;
        x%=26;
        x+=12;
        x = x==w?0:1;
        y=25;
        y*=x;
        y++;
        z*=y;
        y=w;
        y+=2;
        y*=x;
        z+=y;
        System.out.println("2 "+z);
        w = in[3];
        x=z;
        x%=26;
        z/=26;
        x+=-3;
        x = x==w?0:1;
        y=25;
        y*=x;
        y++;
        z*=y;
        y=w;
        y+=15;
        y*=x;
        z+=y;
        System.out.println("3 "+z);
        w = in[4];
        x=z;
        x%=26;
        x+=10;
        x = x==w?0:1;
        y=25;
        y*=x;
        y++;
        z*=y;
        y=w;
        y+=14;
        y*=x;
        z+=y;
        System.out.println("4 "+z);
        w = in[5];
        x=z;
        x%=26;
        z/=26;
        x+=-9;
        x = x==w?0:1;
        y=25;
        y*=x;
        y++;
        z*=y;
        y=w;
        y+=2;
        y*=x;
        z+=y;
        System.out.println("5 "+z);
        w = in[6];
        x=z;
        x%=26;
        x+=10;
        x = x==w?0:1;
        y=25;
        y*=x;
        y++;
        z*=y;
        y=w;
        y+=15;
        y*=x;
        z+=y;
        System.out.println("6 "+z);
        w = in[7];
        x=z;
        x%=26;
        z/=26;
        x+=-7;
        x = x==w?0:1;
        y=25;
        y*=x;
        y++;
        z*=y;
        y=w;
        y++;
        y*=x;
        z+=y;
        System.out.println("7 "+z);
        w = in[8];
        x=z;
        x%=26;
        z/=26;
        x+=-11;
        x = x==w?0:1;
        y=25;
        y*=x;
        y++;
        z*=y;
        y=w;
        y+=15;
        y*=x;
        z+=y;
        System.out.println("8 "+z);
        w = in[9];
        x=z;
        x%=26;
        z/=26;
        x+=-4;
        x = x==w?0:1;
        y=25;
        y*=x;
        y++;
        z*=y;
        y=w;
        y+=15;
        y*=x;
        z+=y;
        System.out.println("9 "+z);
        w = in[10];
        x=z;
        x%=26;
        x+=14;
        x = x==w?0:1;
        y=25;
        y*=x;
        y++;
        z*=y;
        y=w;
        y+=12;
        y*=x;
        z+=y;
        System.out.println("a "+z);
        w = in[11];
        x=z;
        x%=26;
        x+=11;
        x = x==w?0:1;
        y=25;
        y*=x;
        y++;
        z*=y;
        y=w;
        y+=2;
        y*=x;
        z+=y;
        System.out.println("b "+z);
        w = in[12];
        x=z;
        x%=26;
        z/=26;
        x+=-8;
        x = x==w?0:1;
        y=25;
        y*=x;
        y++;
        z*=y;
        y=w;
        y+=13;
        y*=x;
        z+=y;
        System.out.println("c "+z);
        w = in[13];
        x=z;
        x%=26;
        z/=26;
        x+=-10;
        x = x==w?0:1;
        y=25;
        y*=x;
        y++;
        z*=y;
        y=w;
        y+=13;
        y*=x;
        z+=y;
        System.out.println("d "+z);
        return z==0;
    }
    private static class State{
        private final int[] in = new int[14];
        private final int w;
        private final int x;
        private final int y;
        private final int z;
        private static boolean invert = false;
        public State(State other){
            this.w = other.w;
            this.x = other.x;
            this.y = other.y;
            this.z = other.z;
            System.arraycopy(other.in, 0, in, 0, in.length);
        }
        public State(State other, int w, int x, int y, int z){
            this.w = w;
            this.x = x;
            this.y = y;
            this.z = z;
            System.arraycopy(other.in, 0, in, 0, in.length);
        }
        public State(int w, int x, int y, int z){
            this.w = w;
            this.x = x;
            this.y = y;
            this.z = z;
        }
        @Override
        public boolean equals(Object obj){
            if(obj instanceof State s){
                boolean eq = s.z==z;
                if(eq){
                    String thisOne = "";
                    String oth = "";
                    for(int i = 0; i<in.length; i++){
                        thisOne+=in[i];
                        oth+=s.in[i];
                    }
                    long thisL = Long.parseLong(thisOne);
                    long othL = Long.parseLong(oth);
                    boolean yep = thisL>othL;
                    if(invert)yep = !yep;
                    if(yep){
                        for(int i = 0; i<in.length; i++){
                            s.in[i] = in[i];
                        }
                    }else{
                        for(int i = 0; i<in.length; i++){
                            in[i] = s.in[i];
                        }
                    }
                }
                return eq;
            }
            return false;
        }
    }
}