package lesson2.Cars;

public class Car {
    private String name;
    private Engine engine; // �����
    private Climate climate = new Climate(); // ������-��������

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
    
    // ������� �����
    public void turnOn() {
        engine.turnOn();
        climate.turnOn();
        climate.setTemperature(21);
    }
    
    // ��������� �����
    public void turnOff() {
        climate.turnOff();
    	engine.turnOff();
    }
    
    // ���������� ��������
    public double start(int speed, double hours) {
        if (engine.isStarted()) { // ��� �� ������� �����
        	// ���������� ���������
        	double distance = hours * speed;
        	engine.addMileage(distance);
            fuel = distance * engine.getVolume()/20000;
            return fuel;
        }
        return 0;
    }
}