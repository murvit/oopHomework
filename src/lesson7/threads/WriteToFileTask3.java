package lesson7.threads;

import util.Constants;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by VMurashkin on 04.06.2015.
 * Write to file from different threads Lesson 7 task 3
 */
public class WriteToFileTask3 implements Runnable {
    int start;
    byte[] data;
    File file;

    WriteToFileTask3(int start, byte[] data, File file) {
        this.start = start;
        this.data = data;
        this.file = file;
    }

    @Override
    public void run() {
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            raf.seek(start);
            raf.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        int threadsNumber = 10;
        Thread[] thread = new Thread[threadsNumber];
        File file = new File(Constants.FILE_PATH_LESSON_5 + "1234.txt");
        for (byte i = 0; i < threadsNumber; i++) {
            byte[] byteData = new byte[10];
            for (int j = 0; j < byteData.length; j++) {
                byteData[j] = (byte) (i+48);
            }
            thread[i] = new Thread(new WriteToFileTask3(i * byteData.length, byteData, file));
            thread[i].start();
        }
        for (int i = 0; i < threadsNumber; i++) {
            try {
                thread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("File write complete!");
    }

}
