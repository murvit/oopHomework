package lesson7.recursion;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RecursionTask1 {

    private static void listAll(String path, ArrayList<String> res)
            throws IOException {
        File dir = new File(path);
        File[] list = dir.listFiles();

        for (File f : list) {
            if (f.getName().length() > 5 && (f.getName().charAt(1) == 'A' || f.getName().charAt(1) == 'a')) {

                if (f.isFile()) {
                    res.add("F: " + f.getCanonicalPath());
                } else {
                    res.add("D: " + f.getCanonicalPath());
                    listAll(f.getCanonicalPath(), res);
                }
            }
        }
    }

    public static void main(String[] args) {
        final String path = "C:\\";
        ArrayList<String> res = new ArrayList<String>();

        try {
            listAll(path, res);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : res)
            System.out.println(s);
    }
}