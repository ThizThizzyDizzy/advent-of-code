package com.thizthizzydizzy.aoc2021;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
public class Day23 implements Day{
    @Override
    public void run(){
        String input = """
                       #############
                       #...........#
                       ###A#D#C#A###
                         #C#D#B#B#
                         #########""";
        RoomState initial = new RoomState(Amphipod.AMBER, Amphipod.COPPER, Amphipod.DESERT, Amphipod.DESERT, Amphipod.COPPER, Amphipod.BRONZE, Amphipod.AMBER, Amphipod.BRONZE);
        TallRoomState initialTall = new TallRoomState(Amphipod.AMBER, Amphipod.COPPER, Amphipod.DESERT, Amphipod.DESERT, Amphipod.COPPER, Amphipod.BRONZE, Amphipod.AMBER, Amphipod.BRONZE);
        System.out.println("Part one");
        {
            ArrayList<RoomState> pendingStates = new ArrayList<>();
            pendingStates.add(initial);
            HashSet<RoomState> doneStates = new HashSet<>();
            int smallest = Integer.MAX_VALUE;
            int deadends = 0;
            int loops = 0;
            int finished = 0;
            int skipped = 0;
            int i = 0;
            long lastPrint = System.nanoTime();
            int lastNrg = 0;
            while(!pendingStates.isEmpty()){
                long diff = System.nanoTime()-lastPrint;
                if(diff>1_000_000_000){
                    System.out.println(pendingStates.size()+" | "+doneStates.size()+" : "+(smallest==Integer.MAX_VALUE?"n/a":smallest)+" ; "+deadends+" ;; "+loops+" ~~ "+finished+" % "+skipped+" $ "+lastNrg);
                    lastPrint = System.nanoTime();
                }
    //            Collections.sort(pendingStates, (o1, o2)->{
    //                return o2.energyCost-o1.energyCost;
    //            });
    //            int idx = -1;
    //            int lowest = 0;
    //            for(int j = 0; j<pendingStates.size(); j++){
    //                RoomState state = pendingStates.get(j);
    //                if(idx==-1||state.energyCost<lowest){
    //                    lowest = state.energyCost;
    //                    idx = j;
    //                }
    //            }
    //            RoomState state = pendingStates.remove(idx);
                RoomState state = pendingStates.remove(pendingStates.size()-1);//pendingStates.size()>1000?0:(pendingStates.size()-1));
                lastNrg = state.energyCost;
    //            System.out.println(idx+" "+lowest+" "+state.energyCost);
    //            doneStates.add(state);
                if(state.energyCost>=smallest){
                    skipped++;
                    continue;
                }//skip
                if(state.isFinished()){
                    finished++;
                    if(state.energyCost<smallest){
                        smallest = state.energyCost;
    //                    System.out.println("Found new smallest:");
    //                    while(state!=null){
    //                        System.out.println(state);
    //                        state = state.parent;
    //                    }
                    }
                    continue;
                }
                Stack<RoomState> newStates = new Stack<>();
                state.getMoves(newStates);
                if(newStates.isEmpty()){
                    deadends++;
                    continue;
                }
                for(RoomState s : newStates){
                    s.parent = state;
    //                if(doneStates.contains(s))loops++;
    //                else{
                        int stateHalls = 0;
                        int sHalls = 0;
                        for(int j = 0; j<state.hall.length; j++){
                            if(state.hall[j]!=null)stateHalls++;
                            if(s.hall[j]!=null)sHalls++;
                        }
    //                    if(sHalls<stateHalls)System.out.println(state.toString()+"\nTO\n"+s.toString()+"\n\n");
                        pendingStates.add(s);
    //                }
                }
            }
                    System.out.println(pendingStates.size()+" | "+doneStates.size()+" : "+smallest+" ; "+deadends+" ;; "+loops+" ~~ "+finished);
            System.out.println(smallest);
        }
        System.out.println("Part two");
        ArrayList<TallRoomState> pendingStates = new ArrayList<>();
        pendingStates.add(initialTall);
        HashSet<TallRoomState> doneStates = new HashSet<>();
        int smallest = Integer.MAX_VALUE;
        int deadends = 0;
        int loops = 0;
        int finished = 0;
        int skipped = 0;
        int i = 0;
        long lastPrint = System.nanoTime();
        int lastNrg = 0;
        while(!pendingStates.isEmpty()){
            long diff = System.nanoTime()-lastPrint;
            if(diff>1_000_000_00){
                System.out.println(pendingStates.size()+" | "+doneStates.size()+" : "+(smallest==Integer.MAX_VALUE?"n/a":smallest)+" ; "+deadends+" ;; "+loops+" ~~ "+finished+" % "+skipped+" $ "+lastNrg);
                lastPrint = System.nanoTime();
            }
//            Collections.sort(pendingStates, (o1, o2)->{
//                return o2.energyCost-o1.energyCost;
//            });
//            int idx = -1;
//            int lowest = 0;
//            for(int j = 0; j<pendingStates.size(); j++){
//                RoomState state = pendingStates.get(j);
//                if(idx==-1||state.energyCost<lowest){
//                    lowest = state.energyCost;
//                    idx = j;
//                }
//            }
//            RoomState state = pendingStates.remove(idx);
            TallRoomState state = pendingStates.remove(pendingStates.size()-1);//pendingStates.size()>1000?0:(pendingStates.size()-1));
            lastNrg = state.energyCost;
//            System.out.println(idx+" "+lowest+" "+state.energyCost);
//            doneStates.add(state);
            if(state.energyCost>=smallest){
                skipped++;
                continue;
            }//skip
            if(state.isFinished()){
                finished++;
                if(state.energyCost<smallest){
                    smallest = state.energyCost;
//                    System.out.println("Found new smallest:");
//                    while(state!=null){
//                        System.out.println(state);
//                        state = state.parent;
//                    }
                }
                continue;
            }
            Stack<TallRoomState> newStates = new Stack<>();
            state.getMoves(newStates);
            if(newStates.isEmpty()){
                deadends++;
                continue;
            }
            for(TallRoomState s : newStates){
                s.parent = state;
//                if(doneStates.contains(s))loops++;
//                else{
                    int stateHalls = 0;
                    int sHalls = 0;
                    for(int j = 0; j<state.hall.length; j++){
                        if(state.hall[j]!=null)stateHalls++;
                        if(s.hall[j]!=null)sHalls++;
                    }
//                    if(sHalls<stateHalls)System.out.println(state.toString()+"\nTO\n"+s.toString()+"\n\n");
                    pendingStates.add(s);
//                }
            }
        }
                System.out.println(pendingStates.size()+" | "+doneStates.size()+" : "+smallest+" ; "+deadends+" ;; "+loops+" ~~ "+finished);
        System.out.println(smallest);
    }
    private static class TallRoomState{
        private final Amphipod[][] rooms = new Amphipod[4][4];
        private final Amphipod[] hall = new Amphipod[7];
        private int energyCost;
        private TallRoomState parent;
        public TallRoomState(TallRoomState s){
            System.arraycopy(s.hall, 0, hall, 0, hall.length);
            for(int i = 0; i<4; i++){
                rooms[i] = new Amphipod[4];
                System.arraycopy(s.rooms[i], 0, rooms[i], 0, 4);
            }
            energyCost = s.energyCost;
            for(int r = 0; r<rooms.length; r++){
                Amphipod[] room = rooms[r];
                for(int i = 0; i<room.length; i++){
                    Amphipod amphipod = room[i];
                    if(amphipod!=null)return;
                }
            }
            throw new IllegalArgumentException("THIS SHOULD NOT BE HAPPENING!");
        }
        public TallRoomState(Amphipod a1, Amphipod a2, Amphipod b1, Amphipod b2, Amphipod c1, Amphipod c2, Amphipod d1, Amphipod d2){
            rooms[0][0] = a1;
            rooms[0][3] = a2;
            rooms[1][0] = b1;
            rooms[1][3] = b2;
            rooms[2][0] = c1;
            rooms[2][3] = c2;
            rooms[3][0] = d1;
            rooms[3][3] = d2;
            rooms[0][1] = Amphipod.DESERT;
            rooms[0][2] = Amphipod.DESERT;
            rooms[1][1] = Amphipod.COPPER;
            rooms[1][2] = Amphipod.BRONZE;
            rooms[2][1] = Amphipod.BRONZE;
            rooms[2][2] = Amphipod.AMBER;
            rooms[3][1] = Amphipod.AMBER;
            rooms[3][2] = Amphipod.COPPER;
        }
        public void getMoves(Stack<TallRoomState> moves){
            for(int h = 0; h<7; h++){
                if(hall[h]!=null){
                    var mov = getHallMove(h, hall[h]);
                    if(mov!=null)moves.push(mov);
                }
            }
            for(int room = 0; room<4; room++){
                for(int depth = 0; depth<4; depth++){
                    if(rooms[room][depth]!=null){
                        getRoomMoves(moves, room, rooms[room][depth], depth);
                        break;
                    }
                }
            }
        }
        private TallRoomState getHallMove(int h, Amphipod amphipod){
            int room = amphipod.ordinal();
            for(int depth = 0; depth<4; depth++){
                if(rooms[room][depth]!=null&&rooms[room][depth]!=amphipod)return null;
            }
            if(isHallObstructed(room, h, true))return null;
            int actualHallPos = actualHallPos(h);
            int roomHallPos = roomHallPos(room);
            int hallCost = Math.abs(actualHallPos-roomHallPos);
            int targetDepth = 3;
            while(rooms[room][targetDepth]!=null)targetDepth--;
            if(hall[h]==null)throw new IllegalArgumentException("Shouldn't happen");
            TallRoomState state = new TallRoomState(this);
            if(state.hall[h]==null)throw new IllegalArgumentException("Really Shouldn't happen");
            state.rooms[room][targetDepth] = state.hall[h];
            state.hall[h] = null;
            state.energyCost+=(hallCost+targetDepth+1)*amphipod.movementEnergy;
            return state;
        }
        private void getRoomMoves(Stack<TallRoomState> moves, int room, Amphipod amphipod, int roomDepth){
            if(room==amphipod.ordinal()){
                //check lower ones; might be in the right spot already
                boolean allGood = true;
                for(int depth = roomDepth+1; depth<4; depth++){
                    if(rooms[room][depth].ordinal()!=room){
                        allGood = false;
                        break;
                    }
                }
                if(allGood)return;
            }
            int roomHallPos = room+2;
            int actualRoomHallPos = roomHallPos(room);
            //check left hallway moves from the left
            for(int h = 0; h<roomHallPos; h++){
                if(isHallObstructed(room, h, false))continue;
                int actualHallPos = actualHallPos(h);
                int dist = Math.abs(actualHallPos-actualRoomHallPos)+roomDepth+1;
                if(rooms[room][roomDepth]==null)throw new IllegalArgumentException("SHOULDN'T HAPPEN");
                TallRoomState state = new TallRoomState(this);
                if(state.rooms[room][roomDepth]==null)throw new IllegalArgumentException("DEFINITELY SHOULDN'T HAPPEN");
                state.hall[h] = state.rooms[room][roomDepth];
                state.rooms[room][roomDepth] = null;
                state.energyCost+=dist*amphipod.movementEnergy;
                moves.push(state);
            }
            //check right hallway moves from the right
            for(int h = 6; h>=roomHallPos; h--){
                if(isHallObstructed(room, h, false))continue;
                int actualHallPos = actualHallPos(h);
                int dist = Math.abs(actualHallPos-actualRoomHallPos)+roomDepth+1;
                if(rooms[room][roomDepth]==null)throw new IllegalArgumentException("SHOULDN'T HAPPEN");
                TallRoomState state = new TallRoomState(this);
                if(state.rooms[room][roomDepth]==null)throw new IllegalArgumentException("DEFINITELY SHOULDN'T HAPPEN");
                state.hall[h] = state.rooms[room][roomDepth];
                state.rooms[room][roomDepth] = null;
                state.energyCost+=dist*amphipod.movementEnergy;
                moves.push(state);
            }
        }
        private boolean isHallObstructed(int room, int h, boolean thisOne){
            int roomHallPos = room+2;
            if(h<roomHallPos){//check left of room
                for(int i = h; i<roomHallPos; i++){
                    if(thisOne&&i==h)continue;
                    if(hall[i]!=null)return true;
                }
                return false;
            }else{//check right of room
                for(int i = roomHallPos; i<=h; i++){
                    if(thisOne&&i==h)continue;
                    if(hall[i]!=null)return true;
                }
                return false;
            }
        }
        @Override
        public boolean equals(Object obj){
            if(obj instanceof TallRoomState r){
                boolean eq = Arrays.deepEquals(rooms, r.rooms)
                        &&Arrays.equals(hall, r.hall);
                if(eq)energyCost = r.energyCost = Math.min(energyCost, r.energyCost);
                return eq;
            }
            return false;
        }
        private int actualHallPos(int h){
            return switch(h){
                case 0 -> 0;
                case 1 -> 1;
                case 2 -> 3;
                case 3 -> 5;
                case 4 -> 7;
                case 5 -> 9;
                case 6 -> 10;
                default -> -1;
            };
        }
        private int roomHallPos(int room){
            return switch(room){
                case 0 -> 2;
                case 1 -> 4;
                case 2 -> 6;
                case 3 -> 8;
                default -> -1;
            };
        }
        private boolean isFinished(){
            for(int i = 0; i<hall.length; i++){
                if(hall[i]!=null)return false;
            }
            for(int r = 0; r<rooms.length; r++){
                for(int d = 0; d<4; d++){
                    if(rooms[r][d]==null){
                        throw new IllegalArgumentException("bad");
                    }
                    if(rooms[r][d].ordinal()!=r)return false;
                }
            }
            return true;
        }
        @Override
        public String toString(){
            return "############# "+energyCost+"\n" +
                   "#"+letter(hall[0])+letter(hall[1])+"."+letter(hall[2])+"."+letter(hall[3])+"."+letter(hall[4])+"."+letter(hall[5])+letter(hall[6])+"#\n" +
                   "###"+letter(rooms[0][0])+"#"+letter(rooms[1][0])+"#"+letter(rooms[2][0])+"#"+letter(rooms[3][0])+"###\n" +
                   "  #"+letter(rooms[0][1])+"#"+letter(rooms[1][1])+"#"+letter(rooms[2][1])+"#"+letter(rooms[3][1])+"#\n" +
                   "  #"+letter(rooms[0][2])+"#"+letter(rooms[1][2])+"#"+letter(rooms[2][2])+"#"+letter(rooms[3][2])+"#\n" +
                   "  #"+letter(rooms[0][3])+"#"+letter(rooms[1][3])+"#"+letter(rooms[2][3])+"#"+letter(rooms[3][3])+"#\n" +
                   "  #########";
        }
        private String letter(Amphipod a){
            if(a==null)return ".";
            else return a.toString().charAt(0)+"";
        }
    }
    private static class RoomState{
        private final Amphipod[] front = new Amphipod[4];
        private final Amphipod[] back = new Amphipod[4];
        private final Amphipod[] hall = new Amphipod[7];
        private int energyCost;
        private RoomState parent;
        public RoomState(RoomState s){
            this(s.front[0], s.back[0], s.front[1], s.back[1], s.front[2], s.back[2], s.front[3], s.back[3], s.hall[0], s.hall[1], s.hall[2], s.hall[3], s.hall[4], s.hall[5], s.hall[6], s.energyCost);
        }
        public RoomState(Amphipod a1, Amphipod a2, Amphipod b1, Amphipod b2, Amphipod c1, Amphipod c2, Amphipod d1, Amphipod d2){
            this(a1, a2, b1, b2, c1, c2, d1, d2, null, null, null, null, null, null, null, 0);
        }
        public RoomState(Amphipod a1, Amphipod a2, Amphipod b1, Amphipod b2, Amphipod c1, Amphipod c2, Amphipod d1, Amphipod d2, Amphipod h1, Amphipod h2, Amphipod h3, Amphipod h4, Amphipod h5, Amphipod h6, Amphipod h7, int energyCost){
            front[0] = a1;
            front[1] = b1;
            front[2] = c1;
            front[3] = d1;
            back[0] = a2;
            back[1] = b2;
            back[2] = c2;
            back[3] = d2;
            hall[0] = h1;
            hall[1] = h2;
            hall[2] = h3;
            hall[3] = h4;
            hall[4] = h5;
            hall[5] = h6;
            hall[6] = h7;
            this.energyCost = energyCost;
        }
        public void getMoves(Stack<RoomState> moves){
            for(int h = 0; h<7; h++){
                if(hall[h]!=null){
                    var mov = getHallMove(h, hall[h]);
                    if(mov!=null)moves.push(mov);
                }
            }
            for(int room = 0; room<4; room++){
                if(front[room]!=null)getRoomMoves(moves, room, front[room], 1);
                else if(back[room]!=null)getRoomMoves(moves, room, back[room], 2);
            }
        }
        private RoomState getHallMove(int h, Amphipod amphipod){
            int room = amphipod.ordinal();
            if(front[room]!=null)return null;
            if(back[room]!=null&&back[room]!=amphipod)return null;
            if(isHallObstructed(room, h, true))return null;
            int actualHallPos = actualHallPos(h);
            int roomHallPos = roomHallPos(room);
            int hallCost = Math.abs(actualHallPos-roomHallPos);
            if(back[room]==null){
                RoomState state = new RoomState(this);
                state.back[room] = state.hall[h];
                state.hall[h] = null;
                state.energyCost+=(hallCost+2)*amphipod.movementEnergy;
                return state;
            }else{
                RoomState state = new RoomState(this);
                state.front[room] = state.hall[h];
                state.hall[h] = null;
                state.energyCost+=(hallCost+1)*amphipod.movementEnergy;
                return state;
            }
        }
        private void getRoomMoves(Stack<RoomState> moves, int room, Amphipod amphipod, int roomDepth){
            if(roomDepth==2&&room==amphipod.ordinal())return;//already in the right spot
            if(roomDepth==1&&room==amphipod.ordinal()&&room==back[room].ordinal())return;//already in the right spot, and lower one is too
            int roomHallPos = room+2;
            int actualRoomHallPos = roomHallPos(room);
            //check left hallway moves from the left
            for(int h = 0; h<roomHallPos; h++){
                if(isHallObstructed(room, h, false))continue;
                int actualHallPos = actualHallPos(h);
                int dist = Math.abs(actualHallPos-actualRoomHallPos)+roomDepth;
                RoomState state = new RoomState(this);
                state.hall[h] = roomDepth==1?state.front[room]:state.back[room];
                if(roomDepth==1)state.front[room] = null;
                else state.back[room] = null;
                state.energyCost+=dist*amphipod.movementEnergy;
                moves.push(state);
            }
            //check right hallway moves from the right
            for(int h = 6; h>=roomHallPos; h--){
                if(isHallObstructed(room, h, false))continue;
                int actualHallPos = actualHallPos(h);
                int dist = Math.abs(actualHallPos-actualRoomHallPos)+roomDepth;
                RoomState state = new RoomState(this);
                state.hall[h] = roomDepth==1?state.front[room]:state.back[room];
                if(roomDepth==1)state.front[room] = null;
                else state.back[room] = null;
                state.energyCost+=dist*amphipod.movementEnergy;
                moves.push(state);
            }
        }
        private boolean isHallObstructed(int room, int h, boolean thisOne){
            int roomHallPos = room+2;
            if(h<roomHallPos){//check left of room
                for(int i = h; i<roomHallPos; i++){
                    if(thisOne&&i==h)continue;
                    if(hall[i]!=null)return true;
                }
                return false;
            }else{//check right of room
                for(int i = roomHallPos; i<=h; i++){
                    if(thisOne&&i==h)continue;
                    if(hall[i]!=null)return true;
                }
                return false;
            }
        }
        @Override
        public boolean equals(Object obj){
            if(obj instanceof RoomState r){
                boolean eq = Arrays.equals(front, r.front)
                        &&Arrays.equals(back, r.back)
                        &&Arrays.equals(hall, r.hall);
                if(eq)energyCost = r.energyCost = Math.min(energyCost, r.energyCost);
                return eq;
            }
            return false;
        }
        private int actualHallPos(int h){
            return switch(h){
                case 0 -> 0;
                case 1 -> 1;
                case 2 -> 3;
                case 3 -> 5;
                case 4 -> 7;
                case 5 -> 9;
                case 6 -> 10;
                default -> -1;
            };
        }
        private int roomHallPos(int room){
            return switch(room){
                case 0 -> 2;
                case 1 -> 4;
                case 2 -> 6;
                case 3 -> 8;
                default -> -1;
            };
        }
        private boolean isFinished(){
            for(int i = 0; i<hall.length; i++){
                if(hall[i]!=null)return false;
            }
            for(int i = 0; i<front.length; i++){
                if(front[i].ordinal()!=i)return false;
                if(back[i].ordinal()!=i)return false;
            }
            return true;
        }
        @Override
        public String toString(){
            return "############# "+energyCost+"\n" +
                   "#"+letter(hall[0])+letter(hall[1])+"."+letter(hall[2])+"."+letter(hall[3])+"."+letter(hall[4])+"."+letter(hall[5])+letter(hall[6])+"#\n" +
                   "###"+letter(front[0])+"#"+letter(front[1])+"#"+letter(front[2])+"#"+letter(front[3])+"###\n" +
                   "  #"+letter(back[0])+"#"+letter(back[1])+"#"+letter(back[2])+"#"+letter(back[3])+"#\n" +
                   "  #########";
        }
        private String letter(Amphipod a){
            if(a==null)return ".";
            else return a.toString().charAt(0)+"";
        }
    }
    private static enum Amphipod{
        AMBER(1),
        BRONZE(10),
        COPPER(100),
        DESERT(1000);
        private final int movementEnergy;
        private Amphipod(int movementEnergy){
            this.movementEnergy = movementEnergy;
        }
    }
}