package lesson3.Exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;


/**
 * Created by VMurashkin on 25.05.2015.
 * Example of exceptions
 */

public class ExampleFiveExceptions {

    public static void main(String[] args) {

        System.out.println("Exception 1");
        try {
            Reader reader = new FileReader("NoFile.txt");
        } catch (FileNotFoundException e) {
            System.out.println("There is no file");
            //           e.printStackTrace();
        }

        System.out.println("Exception 2");
        int[] a = new int[5];
        try {
            int i = a[1];
            a[6] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Your array index is out of bounds");
            //          e.printStackTrace();
        }

        System.out.println("Exception 3");
        String s = "d555566gf";
        try {
            int b = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("Illegal number format");
        }

        System.out.println("Exception 4");
        int zero = 0;
        try {
            int i = 123 / zero;
        } catch (ArithmeticException e) {
            System.out.println("You try to divide by zero");
        }

        System.out.println("Exception 5");
        String s1 = null;
        try {
            byte[] b = s1.getBytes(s1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            System.out.println("Argument is null");
        }
    }
}
