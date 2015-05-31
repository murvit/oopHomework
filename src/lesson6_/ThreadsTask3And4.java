package lesson6_;

/**
 * Created by User on 31.05.2015.
 * Lesson 6 Task 3
 */
public class ThreadsTask3And4 extends Thread {

    public ThreadsTask3And4(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        System.out.println("Thread number " + this.getName() + " started");
        while (!interrupted()) {

        }
        System.out.println("Thread " + this.getName() + " interrupted");
    }

    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("my");
        ThreadsTask3And4[] tt3list = new ThreadsTask3And4[100];
        for (int i = 0; i < 100; i++) {
            tt3list[i] = new ThreadsTask3And4(tg, "" + i);
            tt3list[i].start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tg.interrupt();

    }
}

