package lesson2.Cars;

public class Engine {
    private double mileage;
    private boolean started;

    public int getVolume() {
        return volume;
    }

    private int volume;
    
    public Engine(double mileage, int volume) {
        this.mileage = mileage;
        this.volume=volume;
    }
    
    public double getMileage() {
        return mileage;
    }

    
    public void addMileage(double mileage) {
        if (started)
            this.mileage += mileage;
    }
    
    public boolean isStarted() {
        return started;
    }
    
    public void turnOn() {
        started = true;
    }
    
    public void turnOff() {
        started = false;
    }
}
