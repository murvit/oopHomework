package lesson7.recursion.monitiortask2;

import util.Constants;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<File> listFiles = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Monitor m = new Monitor(new File(Constants.FILE_PATH_LESSON_5), new FileEvent());
        m.listAll(new File (Constants.FILE_PATH_LESSON_5), listFiles);
        m.start();

    }
}