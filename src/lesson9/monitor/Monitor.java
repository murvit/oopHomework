package lesson9.monitor;

import java.lang.InterruptedException;
import java.util.*;
import java.io.*;

public class Monitor extends Thread {

    private final String PATH;
    private int timeout;
    private Map<String, Long> prev = new HashMap<>();
    private Map<String, Long> curr = new HashMap<>();
    private IFileEvents events;
    boolean keepRunning = true;

    public Monitor(String path) {
        PATH = path;
        prev = createArray();
    }

    public void start() {
        while (keepRunning) {

            curr = createArray();
            compareArrays(prev, curr);
            prev = curr;

            System.out.println("Waiting...");
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.exit(0);
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

    private void doFileAdded(Map.Entry path) {
        if (events != null)
            events.onFileAdded(path);
    }

    private void doFileDeleted(Map.Entry path) {
        if (events != null)
            events.onFileDeleted(path);
    }

    private void doFileChanged(Map.Entry path) {
        if (events != null)
            events.onFileChanged(path);
    }

    private void compareArrays(Map<String, Long> previous, Map<String, Long> current) {

        for (Map.Entry<String, Long> it : previous.entrySet()) {
            if (!current.containsKey(it.getKey()))
                doFileDeleted(it);
        }

        for (Map.Entry<String, Long> it : current.entrySet()) {
            if (!previous.containsKey((it.getKey())))
                doFileAdded(it);
            else {
                if (!it.getValue().equals(previous.get(it.getKey()))) {
                    doFileChanged(it);
                }
            }
        }
    }

    private Map<String, Long> createArray() {
        File file = new File(PATH);
        File[] list = file.listFiles();
        Map<String, Long> result = new HashMap<>();
        for (File f : list)
            try {
                result.put(f.getCanonicalPath(), f.lastModified());
            } catch (IOException e) {
                e.printStackTrace();
            }
        return result;
    }
}
