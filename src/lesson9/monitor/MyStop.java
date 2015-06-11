package lesson9.monitor;

/**
 * Created by VMurashkin on 11.06.2015.
 * to interrupt our monitor
 */

class MyStop extends Thread {
    private Monitor m;

    public MyStop(Monitor m) {
        this.m = m;
    }

    public void run() {
        m.keepRunning = false;
    }
}

