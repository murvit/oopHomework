package lesson10.userdatabasetask7;

import util.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by VMurashkin on 14.06.2015.
 * Main
 */
public class MainClass {

    public static void main(String[] args) throws IOException {
        UserDatabase database = new UserDatabase();
        database.help();
        while (true){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter command");
            String command = reader.readLine();
            if (command.equals("search"))
                database.search();
            else if (command.equals("add"))
                database.add();
            else if (command.equals("remove"))
                database.remove();
            else if (command.equals("list"))
                database.list();
            else if (command.equals("save"))
                database.save(Constants.FILE_PATH_LESSON_10 + "database.txt");
            else if (command.equals("load"))
                database.load(Constants.FILE_PATH_LESSON_10 + "database.txt");
            else if (command.equals("exit"))
                break;


        }

    }
}
