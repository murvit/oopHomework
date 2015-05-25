package lesson2.Cars;

public class MyClass {
    public static void main(String[] args) {
        Car bmw = new Car("BMW");
        Car ferrari = new Car("Ferrari", 20000, 2500);

        bmw.turnOn();
        ferrari.turnOn();
            
        final int[] speeds = new int[] {20, 60, 100};
            
        for (int s : speeds)
            bmw.fuel += bmw.start(s, 0.5);
        for (int s : speeds)
            ferrari.fuel += ferrari.start(s, 1);
            
        bmw.turnOff();
        ferrari.turnOff();
            
        System.out.println(bmw.getName() + " Mileage: " + bmw.getMileage()+ " Fuel: " + bmw.getFuel());
        System.out.println(ferrari.getName() + " Mileage: " + ferrari.getMileage() + " Fuel: " + ferrari.getFuel());


    }
}
