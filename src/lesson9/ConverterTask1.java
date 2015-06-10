package lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by VMurashkin on 10.06.2015.
 * Lesson 9 Task 1
 */
public class ConverterTask1 {

    public <T> List<T> convertArrayToString(T[] array) {
        return Arrays.asList(array);
    }

    public static void main(String[] args) {
        ConverterTask1 ct = new ConverterTask1();

        String[] stringArray = {"str1", "str2", "str3", "str4"};
        List<String> listString = ct.convertArrayToString(stringArray);
        System.out.println(listString);

        Integer[] integerArray = {1, 2, 3, 4};
        List<Integer> listInteger = ct.convertArrayToString(integerArray);
        System.out.println(listInteger);

    }
}
