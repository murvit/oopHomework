package lesson9.monitor;

import util.Constants;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class MyClass {

    private static class MyEvents implements IFileEvents {
        SimpleDateFormat sf = new SimpleDateFormat("dd.MM.YYYY hh:mm:ss");

        public void onFileAdded(Map.Entry path) {
            System.out.println("File added: " + path.getKey());
        }
        
        public void onFileDeleted(Map.Entry path) {
            System.out.println("File deleted: " + path.getKey());
        }

        @Override
        public void onFileChanged(Map.Entry path) {
            System.out.println("File changed: " + path.getKey() + " Time: " + sf.format(new Date((Long)path.getValue())));
        }

    }

    public static void main(String[] args) {
        Monitor m = new Monitor(Constants.FILE_PATH_LESSON_9);
        m.setTimeout(2000);
        m.setEvents(new MyEvents());
        m.start();
        Runtime.getRuntime().addShutdownHook(new MyStop(m));

    }
}