package lesson9.monitor;

/**
 * Created by VMurashkin on 11.06.2015.
 * to interrupt our monitor
 */

class MyStop extends Thread {

    public MyStop() {
    }

    public void run() {
        Monitor.keepRunning = false;
        System.out.println("Stop by user (Message from MyStop)");

    }
}

