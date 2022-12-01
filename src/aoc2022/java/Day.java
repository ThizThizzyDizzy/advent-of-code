package aoc2022.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Day{
    public final String input;
    public Day(String input){
        this.input = read(input);
    }
    public abstract void run();
    public String read(String path){
        File f = new File("src/aoc2022/input/"+path);
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)))){
            String s = "";
            String line;
            while((line = reader.readLine())!=null){
                s+=line+"\n";
            }
            return s.trim();
        } catch (IOException ex) {
            Logger.getLogger(Day.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}