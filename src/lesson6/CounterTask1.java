package lesson6;

/**
 * Created by User on 31.05.2015.
 * Lesson 6 Task1
 */
public class CounterTask1 extends Thread {
    int start, finish;

    CounterTask1(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public void run() {

        for (int i = start; i < finish + 1; i++) {

            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                return;
            }
        }

    }

    public static void main(String[] args) {
        CounterTask1 c = new CounterTask1(100, 200);
        c.start();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        c.interrupt();
    }

}
