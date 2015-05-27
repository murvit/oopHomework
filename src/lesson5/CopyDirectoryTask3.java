package lesson5;

import util.Constants;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;


/**
 * Created by User on 27.05.2015.
 * Lesson 5 Task3
 */
public class CopyDirectoryTask3 {

    public void copyDirectoryTo(String depart, String destin) {
        File departure = new File(depart);
        File destination = new File(destin);
        File dir[] = departure.listFiles();
        for (File f : dir) {
            if (f.isFile()) {
                try {
                    Files.copy(f.toPath(), destination.toPath().resolve(f.getName()));
                    System.out.println("copy " + f.getName() + " to " + destination);
                } catch (FileAlreadyExistsException e) {
                    System.out.println("Error: " + f.getName() + " is already exists in" + destination);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        CopyDirectoryTask3 copy = new CopyDirectoryTask3();
        copy.copyDirectoryTo(Constants.FILE_PATH_LESSON_5, Constants.FILE_PATH_LESSON_5 + "tmp/");
    }

}
