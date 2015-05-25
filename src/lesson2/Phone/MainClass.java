package lesson2.Phone;

import java.util.HashMap;
import java.util.Map;

public class MainClass {


    public static void main(String[] args) {
        // Phone p = new Phone(); ошибка т.к. класс абстрактный

        Nokia3310 nokia = new Nokia3310();
        nokia.setNumber("111-22-33");

        IPhone iphone = new IPhone();
        iphone.setNumber("222-33-44");

        IPhone5 iphone5 = new IPhone5();
        iphone5.setNumber("333-44-55");

        SamsungS4 samsung = new SamsungS4();
        samsung.setNumber("444-55-66");

        System.out.println("----------------------------------");

        System.out.println("Nokia3310 screent size: " + nokia.getScreenSize());
        nokia.call("222-33-44");
        nokia.sendSMS("567-78-89", "text message");
        System.out.println("Call counter: " + nokia.getCallCounter() + " SMS Counter: " + nokia.getSmsCounter());

        System.out.println("----------------------------------");

        System.out.println("IPhone screent size: " + iphone.getScreenSize());
        iphone.call("333-44-55");
        iphone.sendSMS("567-78-89", "text message");
        System.out.println("Call counter: " + iphone.getCallCounter() + " SMS Counter: " + iphone.getSmsCounter());


        System.out.println("----------------------------------");


        System.out.println("IPhone screent size: " + iphone5.getScreenSize());
        iphone5.call("444-55-66");
        iphone5.sendSMS("567-78-89", "text message");
        System.out.println("Call counter: " + iphone5.getCallCounter() + " SMS Counter: " + iphone5.getSmsCounter());


        System.out.println("----------------------------------");

        System.out.println("Samsung S4 screent size: " + samsung.getScreenSize());
        samsung.call("111-22-33");
        samsung.sendSMS("567-78-89", "text message");
        System.out.println("Call counter: " + samsung.getCallCounter() + " SMS Counter: " + samsung.getSmsCounter());


    }
}
