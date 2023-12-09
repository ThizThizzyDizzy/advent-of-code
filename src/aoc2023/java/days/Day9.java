package aoc2023.java.days;
import aoc2023.java.Day;
import java.util.ArrayList;
public class Day9 extends Day{
    public Day9(){
        super(9);
    }
    @Override
    public void run(){
        long total = 0;
        long total2 = 0;
        for(String s : input.split("\n")){
            String[] strs = s.split(" ");
            int[] ints = new int[strs.length];
            for(int i = 0; i<strs.length; i++)ints[i] = Integer.parseInt(strs[i]);
            Report report = new Report(ints);
            total+=report.extrapolate();
            total2+=report.reverseExtrapolate();
        }
        System.out.println(total);
        System.out.println(total2);
    }

    private static class Report{
        public ArrayList<ReportRow> rows = new ArrayList<>();
        public Report(int[] vals){
            ReportRow row = new ReportRow(vals);
            rows.add(row);
            while(!row.isEmpty()){
                row = new ReportRow(row);
                rows.add(row);
            }
        }
        public int extrapolate(){
            int val = -1;
            for(int i = rows.size()-1; i>=0; i--){
                ReportRow current = rows.get(i);
                ReportRow lower = i==rows.size()-1?null:rows.get(i+1);
                val = current.extrapolate(lower);
            }
            return val;
        }
        public int reverseExtrapolate(){
            int val = -1;
            for(int i = rows.size()-1; i>=0; i--){
                ReportRow current = rows.get(i);
                ReportRow lower = i==rows.size()-1?null:rows.get(i+1);
                val = current.reverseExtrapolate(lower);
            }
            return val;
        }
    }
    private static class ReportRow{
        public ArrayList<Integer> values = new ArrayList<>();
        public ReportRow(ReportRow parent){
            for(int i = 0; i<parent.values.size()-1; i++){
                values.add(parent.values.get(i+1)-parent.values.get(i));
            }
        }
        public ReportRow(int[] vals){
            for(int i : vals)values.add(i);
        }
        public boolean isEmpty(){
            for(int i : values)if(i!=0)return false;
            return true;
        }
        private int extrapolate(ReportRow lower){
            if(isEmpty()){
                values.add(0);
                return 0;
            }
            int val = values.get(values.size()-1)+lower.values.get(values.size()-1);
            values.add(val);
            return val;
        }
        private int reverseExtrapolate(ReportRow lower){
            if(isEmpty()){
                values.add(0, 0);
                return 0;
            }
            int val = values.get(0)-lower.values.get(0);
            values.add(0, val);
            return val;
        }
    }
}