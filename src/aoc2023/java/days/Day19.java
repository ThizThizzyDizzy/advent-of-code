package aoc2023.java.days;
import aoc2023.java.Day;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
public class Day19 extends Day{
    public Day19(){
        super(19);
    }
    @Override
    public void run(){
        HashMap<String, Workflow> workflows = new HashMap<>();
        ArrayList<Part> parts = new ArrayList<>();
        String[] wfs = input.split("\n\n")[0].split("\n");
        for(String wf : wfs){
            Workflow w = new Workflow(wf);
            workflows.put(w.name, w);
        }
        String[] prts = input.split("\n\n")[1].split("\n");
        for(String prt : prts){
            parts.add(new Part(prt));
        }
        int total = 0;
        for(Part part : parts){
            String wf = "in";
            while(wf.length()>1||Character.isLowerCase(wf.charAt(0))){
                wf = workflows.get(wf).run(part.x, part.m, part.a, part.s);
            }
            if(wf.equals("A")){
                total+=part.x+part.m+part.a+part.s;
            }
        }
        System.out.println(total);
        System.out.println(workflows.get("in").solve(workflows));
    }

    private class Workflow{
        private final String name;
        private final ArrayList<WorkflowStep> workflowSteps = new ArrayList<>();
        private ArrayList<Range> ranges = new ArrayList<>();
        private boolean defaultPass;
        public Workflow(String str){
            name = str.split("\\{")[0];
            str = str.substring(name.length()+1, str.length()-1);
            for(String step : str.split(",")){
                String[] sections = step.split("[<>,:]");
                if(sections.length==1)workflowSteps.add(new WorkflowStep(sections[0]));
                else{
                    var variable = sections[0];
                    char operator = step.charAt(variable.length());
                    var value = Integer.parseInt(sections[1]);
                    workflowSteps.add(new WorkflowStep(variable, operator, value, sections[2]));
                }
            }
        }
        public String run(int x, int m, int a, int s){
            for(WorkflowStep step : workflowSteps){
                String str = step.run(x, m, a, s);
                if(str!=null)return str;
            }
            throw new IllegalArgumentException("Workflow failed to finish!");
        }
        private Object solve(HashMap<String, Workflow> workflows){
            System.out.println("Solving "+name+": "+workflowSteps.toString());
            defaultPass = workflowSteps.get(workflowSteps.size()-1).run(0, 0, 0, 0).equals("A");
            for(WorkflowStep step : workflowSteps){
                String res = step.result;
                var stepRange = new Range(step.variable, step.operator=='<'?0:step.value+1, step.operator=='>'?4000:step.value-1);
                if(res.equals("A")||res.equals("R")){
                    if(res.equals("A")==defaultPass)continue;
                    ranges.add(stepRange);
                }else{
                    var w = workflows.get(res);
                    var r = w.solve(workflows);
                    if(r instanceof String s)step.result = s;
                    else{
                        if(w.defaultPass!=defaultPass)r = invertRanges((ArrayList<Range>)r);
                        ranges.addAll(constrainRanges((ArrayList<Range>)r, stepRange));
                    }
                }
            }
            if(ranges.isEmpty())return defaultPass?"A":"R";
            System.out.println("Solved "+name+" into "+ranges.toString()+": "+(defaultPass?"A":"R"));
            return ranges;
        }
        private ArrayList<Range> constrainRanges(ArrayList<Range> ranges, Range constraint){
            for (Iterator<Range> it = ranges.iterator(); it.hasNext();) {
                Range range = it.next();
                if(range.v.equals(constraint.v)){
                    if(range.min>constraint.max||range.max<constraint.min)it.remove();
                    else{
                        range.max = Math.min(range.max,constraint.max);
                        range.min = Math.max(range.min,constraint.min);
                    }
                }
            }
            return ranges;
        }
        private ArrayList<Range> invertRanges(ArrayList<Range> ranges){
            ArrayList<Range> newRanges = new ArrayList<>();
            newRanges.addAll(invertRangesSameVar(filter(ranges, "x")));
            newRanges.addAll(invertRangesSameVar(filter(ranges, "m")));
            newRanges.addAll(invertRangesSameVar(filter(ranges, "a")));
            newRanges.addAll(invertRangesSameVar(filter(ranges, "s")));
            return newRanges;
        }
        private ArrayList<Range> filter(ArrayList<Range> ranges, String filter){
            ArrayList<Range> newRanges = new ArrayList<>();
            for(Range range : ranges){
                if(range.v.equals(filter))newRanges.add(range);
            }
            return newRanges;
        }
        private ArrayList<Range> invertRangesSameVar(ArrayList<Range> ranges){
            if(ranges.isEmpty())return ranges;
            int v = 0;
            ArrayList<Range> newRanges = new ArrayList<>();
            WHILE:while(v<=4000){
                for(Range range : ranges){
                    if(range.contains(v)){
                        v = range.max+1;
                        continue WHILE;
                    };
                }
                int max = 4000;
                for(Range range : ranges){
                    if(range.max<v)continue;
                    max = Math.min(range.min-1, max);
                }
                newRanges.add(new Range(ranges.get(0).v, v, max));
                v = max+1;
            }
            return newRanges;
        }
    }
    private static class Part{
        int x, m, a, s;
        public Part(String prt){
            String[] strs = prt.replaceAll("[{}a-z=]", "").split(",");
            x = Integer.parseInt(strs[0]);
            m = Integer.parseInt(strs[1]);
            a = Integer.parseInt(strs[2]);
            s = Integer.parseInt(strs[3]);
        }
    }

    private static class Range{
        private final String v;
        private int min;
        private int max;
        public Range(String v, int min, int max){
            this.v = v;
            this.min = min;
            this.max = max;
        }
        @Override
        public String toString(){
            return v+"="+min+"-"+max;
        }
        private boolean contains(int v){
            return v>=min&&v<=max;
        }
    }

    private class WorkflowStep{
        private int value;
        private String result;
        private String variable;
        private char operator;
        public WorkflowStep(String result){
            this.result = result;
        }
        public WorkflowStep(String variable, char operator, int value, String result){
            this.value = value;
            this.result = result;
            this.variable = variable;
            this.operator = operator;
        }
        public String run(int x, int m, int a, int s){
            if(variable==null)return result;
            int val = switch(variable){
                case "x" -> x;
                case "m" -> m;
                case "a" -> a;
                case "s" -> s;
                default -> throw new IllegalArgumentException("Invalid variable "+variable);
            };
            boolean res = switch(operator){
                case '>' -> val>value;
                case '<' -> val<value;
                default -> throw new IllegalArgumentException("Invalid operator "+operator);
            };
            return res?result:null;
        }
        @Override
        public String toString(){
            if(variable==null)return result;
            return variable+operator+""+value+":"+result;
        }
    }
}