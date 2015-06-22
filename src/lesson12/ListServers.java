package lesson12;

import util.Constants;

import java.io.*;
import java.net.*;
import java.util.Properties;

/**
 * Created by VMurashkin on 22.06.2015.
 * Lesson 12 Task 1
 */
public class ListServers {

    public void makeReport() {
        Properties property = new Properties();
        String server;
        try (FileInputStream fis = new FileInputStream(Constants.FILE_PATH_LESSON_12 + "servers.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
             FileOutputStream fos = new FileOutputStream(Constants.FILE_PATH_LESSON_12 + "servers.properties")
        ) {

            while ((server = reader.readLine()) != null) {
                try {
                    new Socket(server, 80);
                    property.setProperty(server , "Online");
                    System.out.println("'" + server + "'" + " is online");
                }
                catch (UnknownHostException ue) {
                    property.setProperty(server , "Offline");
                    System.out.println("'" + server + "'" + " is offline");
                }
            }
            property.store(fos, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ListServers ls = new ListServers();
        ls.makeReport();
    }
}
