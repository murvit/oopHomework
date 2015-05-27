package lesson5;

import util.Constants;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * Created by User on 27.05.2015.
 */
public class AllFilesListTask4 {
    public void writeList(String path) {
        File file = new File(path);
        File[] listfiles = file.listFiles();
        SimpleDateFormat sf = new SimpleDateFormat("YYYY.MM.dd hh:mm:ss");
        for (File f : listfiles) {
            if (f.isFile()) {
                String result = f.getAbsolutePath() + " " + sf.format(f.lastModified());
                System.out.println(result);
            }
        }
    }

    public static void main(String[] args) {
        AllFilesListTask4 task = new AllFilesListTask4();
        task.writeList(Constants.FILE_PATH_LESSON_5);
    }

}
