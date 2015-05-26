package lesson2.Phone;

/**
 * Created by User on 25.05.2015.
 * class SamsungS4
 */
public class SamsungS4 extends Phone {

    public SamsungS4() {
        System.out.println("Samsungs4 constructor");

        touch = true;
        hasWifi = true;
        screenSize = 5;
    }

    @Override
    public void sendSMS(String number, String message) {
        System.out.println("Samsung S4 class is sending sms " + message + " to " + number + " Hello");
        super.sendSMS(number, message);
    }

    @Override
    public void call(String number) {
        System.out.println("SamsungS4 class is calling " + number);
        super.call(number);
    }
}
