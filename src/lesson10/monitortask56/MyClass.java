package lesson10.monitortask56;

import util.Constants;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class MyClass {

    static class MyStop extends Thread {
        private Monitor s;

        public MyStop(Monitor s) {
            this.s = s;
        }

        public void run() {
            s.stop();
        }
    }

    private static class MyEvents implements IFileEvents {
        public void onFileChanged(String path) {
            System.out.println("File changed: " + path);
            dir();
        }

        public void onFileAdded(String path) {
            System.out.println("File added: " + path);
            dir();
        }

        public void onFileDeleted(String path) {
            System.out.println("File deleted: " + path);
            dir();
        }

        public void dir() {
            SimpleDateFormat sf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
            File[] all = new File(Constants.FILE_PATH_LESSON_10 + "tmp/").listFiles();
            System.out.println("All files:");
            for (File f : all) {
                try {
                    System.out.format("%s date: %s length: %s %n",
                            f.getCanonicalPath(),
                            sf.format(f.lastModified()),
                            f.length());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Monitor m = new Monitor(Constants.FILE_PATH_LESSON_10 + "tmp/");
        m.setTimeout(2000);
        m.setEvents(new MyEvents());
        m.start();

        Runtime.getRuntime().addShutdownHook(new MyStop(m));
    }
}