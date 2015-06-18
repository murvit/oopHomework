package lesson11.serverclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by VMurashkin on 18.06.2015.
 * Client
 */
public class MyClient {

    public static void main(String[] args) {
        Socket clientSocket = null;
        BufferedReader is = null;
        int port = 7777;
        for (int i = 0; i < 50; i++) {
            try {
                System.out.println("Client started");
                clientSocket = new Socket("127.0.0.1", port);
                is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String response = "";
                while (true) {
                    if (!(response = is.readLine()).equals("!END"))
                        System.out.println(response);
                    else break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (clientSocket != null)
                        clientSocket.close();
                    if (is != null)
                        is.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
