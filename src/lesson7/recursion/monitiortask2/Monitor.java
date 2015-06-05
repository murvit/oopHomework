package lesson7.recursion.monitiortask2;


import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class Monitor {
    File file;
    IFileEvent event;

    public Monitor() {

    }

    public Monitor(File file, IFileEvent event) {
        this.file = file;
        this.event = event;
    }

    public void listAll(File file, List<File> res)
            throws IOException {
        File[] list = file.listFiles();
        for (File f : list) {
            res.add(f);
            if (f.isDirectory()){
                listAll(f, res);
            }
        }
    }



    public void start() throws IOException {
        List<File> filesNow = new ArrayList<>();

        while (true) {

            listAll(file, filesNow);

            // We compare only sizes of the lists , we can compare each element , but this is a simple example
            if (filesNow.size() !=  Main.listFiles.size()) {
                if (event != null)
                    event.direcoryChanged(filesNow);

                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            filesNow.clear();
            System.out.println("Waiting...");
        }
    }
}
