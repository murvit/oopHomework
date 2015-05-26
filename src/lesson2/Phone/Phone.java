package lesson2.Phone;

import java.util.*;

public abstract class Phone {

    protected boolean touch;
    protected boolean hasWifi;
    protected int screenSize;
    protected int callCounter;
    protected int smsCounter;
    String number;

    protected static Map<String, Phone> phones = new HashMap<>();


    public void setNumber(String number) {
        this.number = number;
        phones.put(number, this);
    }

    public int getSmsCounter() {
        return smsCounter;
    }

    public int getCallCounter() {
        return callCounter;
    }

    public Phone() {
        System.out.println("Phone constructor");

    }

    public boolean isTouch() {
        return touch;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void call(String number) {

        this.callCounter++;
        Phone phone = phones.get(number);
        phone.answer(number);
    }

    public void sendSMS(String number, String message) {

        this.smsCounter++;
    }

    public void answer(String number){

        System.out.println("Hello! This is " + this.getClass());
    }

}
