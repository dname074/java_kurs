import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Audi", "A5", 2016, FuelType.DIESEL, 5);
        Motorcycle motor = new Motorcycle("BMW", "jakis", 2015, FuelType.PETROL);

        car.refuel(5);
        motor.refuel(31);
        car.drive();
        motor.drive();

        List<Vehicle> vehicles = new ArrayList<>();
        List<Drivable> vehicles2 = new ArrayList<>();

        vehicles.add(car);
        vehicles.add(motor);

        vehicles2.add(car);
        vehicles2.add(motor);

        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
        }

        for (Drivable vehicle : vehicles2) {
            vehicle.drive();
        }
    }
}
