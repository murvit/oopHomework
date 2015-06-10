package lesson9.monitor;

import util.Constants;

import java.io.File;

public class MyClass {

    private static class MyEvents implements IFileEvents {
        public void onFileAdded(File path) {
            System.out.println("File added: " + path + " time: " + path.lastModified());
        }
        
        public void onFileDeleted(File path) {
            System.out.println("File deleted: " + path);
        }

        @Override
        public void onFileChanged(File path) {
            System.out.println("File changed: " + path + " time: " + path.lastModified());
        }


    }

    public static void main(String[] args) {
        Monitor m = new Monitor(Constants.FILE_PATH_LESSON_9);
        m.setTimeout(2000);
        m.setEvents(new MyEvents());
        m.start();
    }
}