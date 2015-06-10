package lesson9;

import util.Constants;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by VMurashkin on 10.06.2015.
 */
public class Test {
    public static void main(String[] args) {
        while (true) {
            File file = new File(Constants.FILE_PATH_LESSON_9);
            File[] list = file.listFiles();
            List<File> lf = new LinkedList<>(Arrays.asList(list));
            System.out.println("lf1: " + lf.get(0).lastModified());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<File> lf2 = new LinkedList<>(Arrays.asList(list));
            System.out.println("lf2: " + lf2.get(0).lastModified());

        }
    }
}
