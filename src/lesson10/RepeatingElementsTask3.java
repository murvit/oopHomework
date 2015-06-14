package lesson10;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by VMurashkin on 13.06.2015.
 * Lesson 10 Task 3
 */
public class RepeatingElementsTask3 {

    public <T> void count(T[] array) {

        Map<T, Integer> result = new TreeMap<>();
        for (T temp : array) {
            if (result.get(temp) == null)
                result.put(temp, 1);
            else
                result.put(temp, result.get(temp) + 1);

        }
        System.out.println(result);
    }


    public static void main(String[] args) {
        RepeatingElementsTask3 ret = new RepeatingElementsTask3();
        Integer[] arr1 = {1, 2, 3, 4, 5, 6, 4, 4, 2, 2, 2, 3};
        ret.count(arr1);
        String[] arr2 = {"str1", "str2", "str3", "str4", "str5", "str6", "str4", "str4", "str2", "str2", "str2", "str3"};
        ret.count(arr2);

    }

}
