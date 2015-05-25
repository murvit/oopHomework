package lesson2.Cars;

public class Car {
    private String name;
    private Engine engine; // мотор
    private Climate climate = new Climate(); // климат-контроль

    public double getFuel() {
        return fuel;
    }

    double fuel;
    
    public Car(String name) {
        this.name = name;
        engine = new Engine(0, 1800);
        this.fuel = 0;
    }
    
    public Car(String name, double mileage, int volume) {
        this.name = name;
        engine = new Engine(mileage, volume);
        this.fuel = 0;
    }
    
    public String getName() {
        return name;
    }
    
    public double getMileage() {
        return engine.getMileage();
    }
    
    // завести мотор
    public void turnOn() {
        engine.turnOn();
        climate.turnOn();
        climate.setTemperature(21);
    }
    
    // заглушить мотор
    public void turnOff() {
        climate.turnOff();
    	engine.turnOff();
    }
    
    // установить скорость
    public double start(int speed, double hours) {
        if (engine.isStarted()) { // еще не заведен мотор
        	// пройденная дистанция
        	double distance = hours * speed;
        	engine.addMileage(distance);
            fuel = distance * engine.getVolume()/20000;
            return fuel;
        }
        return 0;
    }
}