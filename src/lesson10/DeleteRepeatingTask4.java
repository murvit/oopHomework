package lesson10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by VMurashkin on 13.06.2015.
 * Lesson 10 Task 4
 */
public class DeleteRepeatingTask4 {

    public void deleteRepeating(String[] array) {
        Set<String> result = new LinkedHashSet<>(Arrays.asList(array));
        System.out.println(result);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String str = reader.readLine();
        str = str.replaceAll("\\s", "");
        String[] stringArray = str.split(",");
        DeleteRepeatingTask4 drt = new DeleteRepeatingTask4();
        drt.deleteRepeating(stringArray);
    }

}
