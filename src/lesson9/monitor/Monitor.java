package lesson9.monitor;

import java.lang.InterruptedException;
import java.util.Arrays;
import java.io.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Monitor {

    private final String PATH;
    private int timeout;
    private List<File> prev = new LinkedList<>();
    private List<File> curr = new LinkedList<>();
    private IFileEvents events;

    public Monitor(String path) {
        PATH = path;
        prev = createArray();
        curr = createArray();
    }

    public void start() {
        while (true) {

      //      System.out.println("!start: " + prev.get(0).lastModified() + " " + curr.get(0).lastModified());
            curr = createArray();
     //       System.out.println("!after: " + prev.get(0).lastModified() + " " + curr.get(0).lastModified());
            compareArrays(prev, curr);
      //      System.out.println("compar: " + prev.get(0).lastModified() + " " + curr.get(0).lastModified());
            prev = curr;

            System.out.println("finish: " + prev.get(0).lastModified() + " " + curr.get(0).lastModified());

            System.out.println("Waiting...");
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int value) {
        timeout = value;
    }

    public IFileEvents getEvents() {
        return events;
    }

    public void setEvents(IFileEvents value) {
        events = value;
    }

    private void doFileAdded(File path) {
        if (events != null)
            events.onFileAdded(path);
    }

    private void doFileDeleted(File path) {
        if (events != null)
            events.onFileDeleted(path);
    }

    private void doFileChanged(File path) {
        if (events != null)
            events.onFileChanged(path);
    }

    private void compareArrays(List<File> previous, List<File> current) {

        for (File it : previous) {
            if (!current.contains(it))
                doFileDeleted(it);
        }

        for (int i = 0; i < current.size(); i++) {
            if (!previous.contains(current.get(i)))
                doFileAdded(current.get(i));
            else {
                if (current.get(i).lastModified() != previous.get(i).lastModified())
                    doFileChanged(current.get(i));
            }
        }
    }

    private List<File> createArray() {
        File file = new File(PATH);
        File[] list = file.listFiles();
        return new LinkedList<>(Arrays.asList(list));
    }
}
