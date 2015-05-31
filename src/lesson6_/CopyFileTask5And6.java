package lesson6_;

import util.Constants;

import java.io.*;

/**
 * Created by VMurashkin on 31.05.2015.
 * Lesson 6 Task 5&6
 * Copy file by threads and progress bar
 */
public class CopyFileTask5And6 extends Thread {

    int start, blockSize;
    static String source = Constants.FILE_PATH_LESSON_6 + "1.txt";
    static String destination = Constants.FILE_PATH_LESSON_6 + "2.txt";
    static int counter = 0;

    public CopyFileTask5And6() {

    }

    public CopyFileTask5And6(String name, int start, int blockSize) {
        super(name);
        this.start = start;
        this.blockSize = blockSize;
    }

    @Override
    public void run() {

        byte[] buf = new byte[blockSize];
        try (RandomAccessFile fis = new RandomAccessFile(source, "r");
             RandomAccessFile fos = new RandomAccessFile(destination,"rw");) {
            fis.seek(start);
            int r = fis.read(buf);
 //           System.out.println("Read " + r + " Bytes");
 //           System.out.println("Thread " + this.getName() + " reading");
            fos.seek(start);
            fos.write(buf);
 //           System.out.println("Thread " + this.getName() + " writing");
            counter++;
            System.out.println("Done " + counter*10 + "%");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int splitFile(String source, int numberOfThreads) {
        double size = source.length();
        File f = new File(source);
        return (int) Math.ceil(size / numberOfThreads);
    }


    public static void main(String[] args) {
        CopyFileTask5And6 cf = new CopyFileTask5And6();
        int numberOfThreads = 10;
        int blockSize = cf.splitFile(source, numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            CopyFileTask5And6 copyFile = new CopyFileTask5And6("" + i, i * blockSize, blockSize);
            copyFile.start();
        }

    }
}

