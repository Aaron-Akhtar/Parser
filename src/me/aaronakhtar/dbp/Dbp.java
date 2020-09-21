package me.aaronakhtar.dbp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Dbp {

    protected static final File target = new File("./target.txt");
    protected static final File output = new File("./output.txt");

    public static void main(String[] args) {
        String s;
        try(BufferedReader reader = new BufferedReader(new FileReader(target))){
            int x = 0;
            while((s = reader.readLine()) != null){
                x++;
                new Thread(new DbpRunn(s, x)).start();
            }
        }catch (Exception e){

        }
    }

}
