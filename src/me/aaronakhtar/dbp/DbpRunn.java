package me.aaronakhtar.dbp;

import java.io.FileWriter;
import java.io.PrintWriter;

public class DbpRunn implements Runnable{

    private static void write(String s){
        try(PrintWriter writer = new PrintWriter(new FileWriter(Dbp.output, true), true)){
            writer.write(s);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String line;
    private int num;

    public DbpRunn(String line, int num) {
        this.line = line;
        this.num = num;
    }

    @Override
    public void run() {
        Dbp.running++;
        String[] line = this.line.split(":");
        write(line[1] + ":" + line[3] + ":" + line[2] + "\n");
        System.out.println(line[1] + ":" + line[3] + ":" + line[2] + " -        ["+num+"] \n");
        Dbp.running--;
    }
}
