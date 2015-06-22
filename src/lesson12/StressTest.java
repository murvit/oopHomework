package lesson12;


import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by VMurashkin on 22.06.2015.
 * Lesson 12 Task2
 */
public class StressTest implements Runnable {

    private String server;
    private int port;
    private int counter;

    public StressTest() {
        this.server = "java.com";
        this.port = 80;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        byte[] buff = new byte[1];
        try (Socket socket = new Socket(server, port);
             InputStream bis = socket.getInputStream();
        )

        {
            for (int i = 0; i < 100; i++) {
                bis.read(buff);
                //              System.out.println("Thread # " + counter + " iteration: " + i + " : " + buff[0]);
            }

        } catch (IOException e) {
            System.out.println("Something wrong");
            e.printStackTrace();
        }
        System.out.println("Thread #" + counter + " ended");
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3000);
        for (int i = 0; i < 3000; i++) {
            StressTest test = new StressTest();
            test.setCounter(i);
            executor.execute(test);
        }
        executor.shutdown();
        System.out.println("Main is ended");
    }
}
