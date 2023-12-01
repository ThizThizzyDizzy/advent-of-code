package aoc2023.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Day{
    public final String input;
    public Day(int day){
        this.input = read("day"+day);
    }
    public abstract void run();
    public String read(String name){
        File f = new File("src/aoc2023/input/"+name+".txt");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)))){
            String s = "";
            String line;
            while((line = reader.readLine())!=null){
                s+=line+"\n";
            }
            return s.stripTrailing();
        } catch (IOException ex) {
            Logger.getLogger(Day.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}