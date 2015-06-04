package lesson7.threads;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by VMurashkin on 04.06.2015.
 * Lesson 7 Threads Task 2
 */
public class CountIntegerArrayTask2 implements Runnable {

    int start, end;
    volatile static long sum;
    int[] list;

    CountIntegerArrayTask2 (int start, int end, int[] list){
        this.start = start;
        this.end = end;
        this.list = list;

    }

    @Override
    public void run() {
        ReentrantLock thisLock = new ReentrantLock();
        long tmp = 0;
        for (int i = start; i < end + 1; i++) {
            tmp += list[i];
        }
        thisLock.lock();
        sum += tmp;
        thisLock.unlock();
    }

    public static void main(String[] args) {
        int[] array = new int[15000000];
        long result1 = 0;
        System.out.println("Making array");
        for (int i = 1; i < array.length; i++) {
            array[i] = i;
        }

        System.out.println("Counting sum normal");
        Date startNormal = new Date();
        for (int i = 0; i < array.length; i++) {
            result1 += array[i];
        }
        Date endNormal = new Date();
        System.out.println("Sum is " + result1 + " time (ms): " + (endNormal.getTime() - startNormal.getTime()));

        int numberOfThreads = 10;
        System.out.println("Counting sum in " + numberOfThreads + " threads");
        Date startThreads = new Date ();
        ThreadGroup tg = new ThreadGroup("my");
        Thread[] thread = new Thread[numberOfThreads];
        int buffer = array.length/numberOfThreads;
        for (int i = 0; i < numberOfThreads; i++) {
            thread[i] = new Thread(new CountIntegerArrayTask2(i*buffer, i*buffer+buffer-1, array));
            thread[i].start();
        }
        for (int i = 0; i<numberOfThreads; i++){
            try {
                thread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Date endThreads = new Date ();
        System.out.println("Sum is " + sum + " time (ms): " + (endThreads.getTime() - startThreads.getTime()));
    }
}
