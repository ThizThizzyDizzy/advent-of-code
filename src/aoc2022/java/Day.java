package aoc2022.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Day{
    public final String input;
    public Day(int day){
        this.input = read("day"+day);
        createDSSLBase("day"+day);
    }
    public abstract void run();
    public String read(String name){
        File f = new File("src/aoc2022/input/"+name+".txt");
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
    public void createDSSLBase(String name) {
        File f = new File("src/aoc2022/dssl/base/"+name+".dssl");
        if(!f.exists()){
            try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)))){
                writer.write("\"string.dssl\" import\n/input "+dsslFormat(input)+" def");
            }catch(IOException ex){
                Logger.getLogger(Day.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private String dsslFormat(String s) {
        if(true){
            return "\""+s.replace("\n", "\\n")+"\"";
        }
        //figure out what kind of thing it is
        boolean allNumbers = true;
        int longestNewlineChain = 0;
        String chain = "";
        for(int i = 1; i<s.length(); i++){
            chain+="\n";
            if(s.contains(chain))longestNewlineChain++;
        }
        for(char c : s.toCharArray()){
            if(c=='\n')continue;
            if(!Character.isDigit(c)){
                allNumbers = false;
            }
            break;
        }
        if(allNumbers){//special formatting! only numbers and newlines
            switch(longestNewlineChain){
                case 1:
                    //no blank lines, just one array
                    String result = "";
                    for(String str : s.split("\n")){
                        if(str.isEmpty())str = "null";
                        result += str+" ";
                    }
                    return "[ "+result.substring(1)+" ]";
                case 2:
                    result = "";
                    for(String strr : s.split("\n\n")){
                        result += "[ ";
                        for(String str : strr.split("\n")){
                            if(str.isEmpty())str = "null";
                            result += str+" ";
                        }
                        result = result.substring(0, result.length()-1)+" ] tuple ";
                    }
                    return "[ "+result.substring(0, result.length()-1)+" ] tuple";
                default:
                    //PANIC!
                    throw new UnsupportedOperationException("PANIC PANIC PANIC PANIC PANIC");
            }
        }
        //just do a tuple of individual characters because string manipulation doesn't exist yet
        s = s.replace("\n", "\\n");
        String result = "";
        for(char c : s.toCharArray())result+="'"+c+"' ";
        return "[ "+result.substring(0, result.length()-1)+" ] tuple";
    }
}