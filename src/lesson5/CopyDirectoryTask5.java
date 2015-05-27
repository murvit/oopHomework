package lesson5;

import util.Constants;

import java.io.*;

/**
 * Created by User on 27.05.2015.
 * Lesson 5 Task 5
 */
public class CopyDirectoryTask5 {

    public void copyDirectoryTo(String depart, String destin) {
        File departure = new File(depart);
        File dir[] = departure.listFiles();
        int i;

        for (File f : dir)
            if (f.isFile()) {
                try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
                     BufferedOutputStream bous = new BufferedOutputStream(new FileOutputStream(destin + f.getName()));) {
                    while ((i = bis.read()) != -1) {
                        bous.write(i);
                    }

                } catch (IOException e) {
                    System.out.println("Somethig wrong");
                    e.getStackTrace();
                }
            }
    }

    public static void main(String[] args) {
        CopyDirectoryTask5 copy = new CopyDirectoryTask5();
        copy.copyDirectoryTo(Constants.FILE_PATH_LESSON_5, Constants.FILE_PATH_LESSON_5 + "tmp/");
    }

}
