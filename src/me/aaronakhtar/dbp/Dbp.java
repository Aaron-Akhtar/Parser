package me.aaronakhtar.dbp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Dbp {

    protected static final File target = new File("./target.txt");
    protected static final File output = new File("./output.txt");
    protected static final int max = 10000;
    protected static volatile int running = 0;

    public static void main(String[] args) {
        String s;
        try(BufferedReader reader = new BufferedReader(new FileReader(target))){
            int x = 0;
            while((s = reader.readLine()) != null){
                x++;
                while(running >= max){
                    System.out.println("waiting for release...");
                }
                new Thread(new DbpRunn(s, x)).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
