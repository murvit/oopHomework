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
        DatabaseWork work = new DatabaseWork();
        UserDatabase userDatabase = new UserDatabase(work);
        userDatabase.help();
        boolean exit = false;
        while (!exit) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter command");
            String command = reader.readLine();
            switch (command) {
                case "search":
                    userDatabase.search();
                    break;
                case "add":
                    userDatabase.add();
                    break;
                case "remove":
                    userDatabase.remove();
                    break;
                case "list":
                    userDatabase.list();
                    break;
                case "save":
                    userDatabase.save(Constants.FILE_PATH_LESSON_10 + "database.txt");
                    break;
                case "load":
                    userDatabase.load(Constants.FILE_PATH_LESSON_10 + "database.txt");
                    break;
                case "exit":
                    exit = true;
                    break;
            }


        }

    }


}
