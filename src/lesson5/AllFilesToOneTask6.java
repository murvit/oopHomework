package lesson5;

import util.Constants;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by User on 27.05.2015.
 * Lesson 5 Task 6
 */
public class AllFilesToOneTask6 {
    public void copyAllToOne(String out, String... input) {

        Vector<String> vf = new Vector<>();
        for (String s : input)
            vf.addElement(Constants.FILE_PATH_LESSON_5+s);

        MyEnum me = new MyEnum(vf);
        int i;
        InputStream is = new SequenceInputStream(me);
        try (FileOutputStream fs = new FileOutputStream(Constants.FILE_PATH_LESSON_5+out)){
            while ((i = is.read())!=-1){
                fs.write(i);
            }
        } catch (IOException e){
            e.getStackTrace();
        }

    }

    public static void main(String[] args) {
        AllFilesToOneTask6 all = new AllFilesToOneTask6();
        all.copyAllToOne("out.txt", "1.txt", "2.txt", "5.txt");
    }



    static class MyEnum implements Enumeration<FileInputStream> {

        private Enumeration<String> files;

        public MyEnum(Vector<String> files) {
            this.files = files.elements();
        }

        @Override
        public boolean hasMoreElements() {
            return files.hasMoreElements();
        }

        @Override
        public FileInputStream nextElement() {
            try {
                return new FileInputStream(files.nextElement());
            } catch (IOException e) {
                return null;
            }
        }
    }
}
