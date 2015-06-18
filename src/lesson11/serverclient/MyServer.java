package lesson11.serverclient;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by VMurashkin on 18.06.2015.
 * Lesson 11 Task 3 Server
 */
public class MyServer {

    public static void main(String[] args) {
        int counter = 0;
        int port = 7777;
        ServerSocket serverSocket = null;
        Socket client = null;

        try {
            serverSocket = new ServerSocket(port);
            OutputStream ous = null;

            while (true) {
                try {
                    System.out.println("Server waiting for client");
                    client = serverSocket.accept();
                    System.out.println("Server working");
                    counter++;
                    Runtime r = Runtime.getRuntime();
                    String os = System.getProperty("os.name");
                    String processors = String.valueOf(r.availableProcessors());
                    String totalMemory = String.valueOf(r.totalMemory());
                    String result = String.format("Counter is: %s %nOS: %s %nProcessors: %s %nTotal memory for JVM: %s bytes %n!END",
                            counter,
                            os,
                            processors,
                            totalMemory);
                    ous = client.getOutputStream();
                    ous.write(result.getBytes());
                    ous.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (ous != null)
                        ous.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null)
                    serverSocket.close();
                if (client != null)
                    client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

