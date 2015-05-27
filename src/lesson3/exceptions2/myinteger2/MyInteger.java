package lesson3.exceptions2.myinteger2;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by VMurashkin on 26.05.2015.
 * Analog of ParseInteger
 */

public class MyInteger {


    public static int MyParseInteger(String s) throws NoDigitException {
        int result = 0;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c<48 || c>57)
                throw new NoDigitException ("Your string is not digit");
            result += (c-48)*Math.pow(10, (s.length()-(i+1)));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Enter string");
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        String input = sc.nextLine();
        int x = 0;
        try {
            x = MyInteger.MyParseInteger(input);
        } catch (NoDigitException e) {
            e.printStackTrace();
        }
        // To show x = integer we multiply it by 10;
        int x10 = x * 10;
        System.out.println("X * 10 = " + x10);
    }

}
