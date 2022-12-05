package aoc2022.java.days;
import aoc2022.java.Stack;
import aoc2022.java.Day;
public class Day5 extends Day{
    public Day5(){
        super(5);
    }
    @Override
    public void run() {
        String[] inpt = input.split("\n\n");
        String[] inputStacks = inpt[0].split("\n");
        String nums = inputStacks[inputStacks.length-1].trim();
        Stack<Character>[] stacks = new Stack[Integer.parseInt(nums.charAt(nums.length()-1)+"")];
        for(int i = 0; i<stacks.length; i++)stacks[i] = new Stack<Character>();
        for(int i = inputStacks.length-2; i>=0; i--){
            for(int s = 0; s<stacks.length; s++){
                char c = inputStacks[i].charAt(s*4+1);
                if(c==' ')continue;
                stacks[s].push(c);
            }
        }
        String[] instructions = inpt[1].split("\n");
        for(String s : instructions){
            String[] instruction = s.split(" ");
            int count = Integer.parseInt(instruction[1]);
            int from = Integer.parseInt(instruction[3]);
            int to = Integer.parseInt(instruction[5]);
            for(int i = 0; i<count; i++){
                stacks[to-1].push(stacks[from-1].pop());
            }
        }
        String output = "";
        for(Stack st : stacks){
            output+=st.peek();
        }
        System.out.println(output);
        //part 2
        for(int i = 0; i<stacks.length; i++)stacks[i].clear();
        for(int i = inputStacks.length-2; i>=0; i--){
            for(int s = 0; s<stacks.length; s++){
                char c = inputStacks[i].charAt(s*4+1);
                if(c==' ')continue;
                stacks[s].push(c);
            }
        }
        for(String s : instructions){
            String[] instruction = s.split(" ");
            int count = Integer.parseInt(instruction[1]);
            int from = Integer.parseInt(instruction[3]);
            int to = Integer.parseInt(instruction[5]);
            Stack<Character> interimStack = new Stack<>();
            for(int i = 0; i<count; i++){
                interimStack.push(stacks[from-1].pop());
            }
            for(int i = 0; i<count; i++){
                stacks[to-1].push(interimStack.pop());
            }
        }
        String s = "";
        for(Stack st : stacks){
            s+=st.peek();
        }
        System.out.println(s);
    }
}