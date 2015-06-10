package lesson9.monitor;

import java.lang.InterruptedException;
import java.util.Arrays;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Monitor {

    private String path;
    private int timeout;
    private List<File> prev = new LinkedList<>();
    private List<File> curr = new LinkedList<>();
    private IFileEvents events;

    public Monitor(String path) {
        this.path = path;
        prev = createArray();
    }

    public void start() {
        while (true) {
            curr = createArray();
            compareArrays(prev, curr);
            prev = curr;

            System.out.println("Waiting...");
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException ex) {
                return;
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
                File curr = current.get(i);
                File prev = previous.get(i);
                long timeCurr = curr.lastModified();
                long timePrev = prev.lastModified();
                if (current.get(i).lastModified() != previous.get(i).lastModified())
                    doFileChanged(current.get(i));
                else
                    System.out.println(current.get(i).lastModified() + " : " + previous.get(i).lastModified());
            }
        }


    }

    private List<File> createArray() {

        File file = new File(path);
        File[] list = file.listFiles();
        return new LinkedList<>(Arrays.asList(list));

    }
}
