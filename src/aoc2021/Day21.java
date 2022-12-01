package aoc2021;
import java.util.HashMap;
import java.util.Iterator;
public class Day21 implements Day{
    int ddie = 1;
    int drolls = 0;
    @Override
    public void run(){
        int p1 = 8;
        int p2 = 6;
        System.out.println("Part one");
        int score1 = 0, score2 = 0;
        int player = 0;
        while(score1<1000&&score2<1000){
            int roll = droll()+droll()+droll();
            if(player==0){
                p1+=roll;
                while(p1>10)p1-=10;
                score1+=p1;
            }else{
                p2+=roll;
                while(p2>10)p2-=10;
                score2+=p2;
            }
            player++;
            if(player>1)player = 0;
        }
        System.out.println(Math.min(score1, score2)*drolls);
        System.out.println("Part two");
        HashMap<GameState, Long> states = new HashMap<>();
        states.put(new GameState(8, 6, 0, 0, 0, 0, 0), 1l);
        long wins1 = 0, wins2 = 0;
        while(!states.isEmpty()){
//            System.out.println(states.size()+" | "+wins1+" | "+wins2);
            HashMap<GameState, Long> newStates = new HashMap<>();
            for(GameState state : states.keySet()){
                long count = states.get(state);
                HashMap<GameState, Long> theseNewStates = new HashMap<>();
                state.tick(theseNewStates);
                for(GameState newState : theseNewStates.keySet())newStates.put(newState, newStates.getOrDefault(newState, 0l)+theseNewStates.get(newState)*count);
            }
            states = newStates;
//            for(GameState newState : newStates.keySet())states.put(newState, states.getOrDefault(newState, 0l)+newStates.get(newState));
            for(Iterator<GameState> it = states.keySet().iterator(); it.hasNext();){
                GameState state = it.next();
                if(state.score1>=21){
                    wins1+=states.get(state);
                    it.remove();
                }
                if(state.score2>=21){
                    wins2+=states.get(state);
                    it.remove();
                }
            }
        }
        System.out.println(Math.max(wins1,wins2));
    }
    private int droll(){
        int roll = ddie;
        ddie++;
        drolls++;
        if(ddie>100)ddie-=100;
        return roll;
    }
    private static class GameState{
        private final int p1;
        private final int p2;
        private final int score1;
        private final int score2;
        private final int turn;
        private final int rolls;
        private final int rollTotal;
        public GameState(int p1, int p2, int score1, int score2, int turn, int rolls, int rollTotal){
            this.p1 = p1;
            this.p2 = p2;
            this.score1 = score1;
            this.score2 = score2;
            this.turn = turn;
            this.rolls = rolls;
            this.rollTotal = rollTotal;
        }
        private HashMap<GameState, Long> tick(HashMap<GameState, Long> map){
            if(rolls<3){
                map.put(new GameState(p1, p2, score1, score2, turn, rolls+1, rollTotal+1), 1L);
                map.put(new GameState(p1, p2, score1, score2, turn, rolls+1, rollTotal+2), 1L);
                map.put(new GameState(p1, p2, score1, score2, turn, rolls+1, rollTotal+3), 1L);
            }else{
                int np1 = p1;
                int np2 = p2;
                int nscore1 = score1;
                int nscore2 = score2;
                if(turn==0){
                    np1+=rollTotal;
                    while(np1>10)np1-=10;
                    nscore1+=np1;
                }else{
                    np2+=rollTotal;
                    while(np2>10)np2-=10;
                    nscore2+=np2;
                }
                map.put(new GameState(np1, np2, nscore1, nscore2, 1-turn, 0, 0), 1L);
            }
            return map;
        }
        @Override
        public boolean equals(Object obj){
            if(obj instanceof GameState st){
                return st.p1==p1&&st.p2==p2&&st.score1==score1&&st.score2==score2&&st.turn==turn&&st.rolls==rolls&&st.rollTotal==rollTotal;
            }
            return false;
        }
        @Override
        public int hashCode(){
            int hash = 3;
            hash = 59*hash+this.p1;
            hash = 59*hash+this.p2;
            hash = 59*hash+this.score1;
            hash = 59*hash+this.score2;
            hash = 59*hash+this.turn;
            hash = 59*hash+this.rolls;
            hash = 59*hash+this.rollTotal;
            return hash;
        }
    }
}