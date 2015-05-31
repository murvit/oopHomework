package lesson6;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by User on 31.05.2015.
 * Lesson 6 Task 2
 */
public class TimerTask2 extends Thread {
    SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
    Scanner sc = new Scanner(System.in);

    @Override
    public void run() {
        while (!interrupted()) {
            System.out.println("Current time is " + sf.format(new Date()));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                return;
            }
        }
    }


    public static void main(String[] args) {
        TimerTask2 tt2 = new TimerTask2();
        tt2.start();

        Scanner sc = new Scanner(System.in);
        System.out.println("Press 'Q' to exit");
        if (sc.nextLine().equalsIgnoreCase("Q"))
            tt2.interrupt();

    }
}


