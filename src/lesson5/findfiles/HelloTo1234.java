package lesson5.findfiles;

import util.Constants;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by VMurashkin on 27.05.2015.
 * String Hello to 1234
 */
public class HelloTo1234 {

    public void changeHello(String file) {
char[] chars=null;
        try (FileReader fr = new FileReader(Constants.FILE_PATH_LESSON_5 + file)) {
            int i = fr.read(chars);
            System.out.println("I=" + i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        HelloTo1234 h = new HelloTo1234();
        h.changeHello("5.txt");
    }

}
