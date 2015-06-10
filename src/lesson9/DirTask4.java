package lesson9;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by VMurashkin on 10.06.2015.
 * Lesson9 Task4
 */

public class DirTask4 {

    public void dirAndPrint (String path){
        File file = new File(path);
        if (file.isDirectory()){
            List<String> result = new ArrayList<>(Arrays.asList(file.list()));
            for (int i = 0; i < 5; i++) {
                System.out.println(result.get(i));

            }
        }
    }

    public static void main(String[] args) {
        DirTask4 dt = new DirTask4();
        dt.dirAndPrint("C:\\");
    }
}
