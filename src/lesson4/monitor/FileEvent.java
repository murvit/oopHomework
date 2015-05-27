package lesson4.monitor;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileEvent implements IFileEvent {
    @Override
    public void onFileAdded(File f) {
		long time = f.lastModified();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        System.out.println("File added: " + f + " time: "+ sf.format(time));
    }
}
