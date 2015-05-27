package lesson5.findfiles;

import util.Constants;

import java.io.*;

/**
 * Created by VMurashkin on 27.05.2015.
 * String Hello to 1234
 */
public class HelloTo1234 {

    public void changeHello(String file) {
        String text = "";
        StringBuilder build = new StringBuilder();

        // reading file

        String filename = Constants.FILE_PATH_LESSON_5 + file;
        try (BufferedReader br = new BufferedReader(new FileReader(filename));) {
            while ((text = br.readLine()) != null){
                build.append(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //change Hello to 1234

        text = build.toString();
        text = text.replaceAll("Hello", "1234");

        //write file

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename));){
            bw.write(text, 0, text.length());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        HelloTo1234 h = new HelloTo1234();
        h.changeHello("5.txt");
    }

}
