package lesson8.filesystemtask4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by VMurashkin on 05.06.2015.
 * Starting!
 */

public class MyMain {
    public static void main(String[] args) throws IOException {
        MyFileSystem m = new MyFileSystem();
        m.help();
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String command = bis.readLine();
            if (command.equals("dir"))
                m.dir();
            else if (command.equals("help"))
                m.help();
            else if (command.startsWith("md")) {
                String dName = command.substring(command.indexOf(" "));
                m.md(dName);
            }
            else if (command.startsWith("mf")){
                String fName = command.substring(command.indexOf(" "));
                m.mf(fName);
            }
            else if (command.startsWith("rd")) {
                String dName = command.substring(command.indexOf(" "));
                m.rd(dName);
            }
            else if (command.startsWith("rf")) {
                String fName = command.substring(command.indexOf(" "));
                m.rf(fName);
            }
            else if (command.startsWith("cd")) {
                String cdName = command.substring(command.indexOf(" "));
                m.cd(cdName);
            }
            else if (command.equals("back")){
                m.back();
            }
            else if (command.equals("save")){
                m.save();
            }
            else if (command.equals("load")){
                m = m.load();
            }
            else if (command.equals("exit"))
                break;
        }
    }
}

