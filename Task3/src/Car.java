public class Car extends Vehicle implements Drivable {
    private int doors;

    public Car(String brand, String model, int year, FuelType fuelType, int doors) {
        super(brand, model, year, fuelType);
        this.doors = doors;
    }

    @Override
    public void drive() {
        if (getTank() < 0.2) {
            System.out.println("Brak paliwa");
        } else if (getTank() + 0.2 > MAX_FUEL) {
            System.out.println("Nie ma tyle miejsca w baku");
        } else {
            System.out.println("Jade autem");
            setTank(getTank() - 0.2);
            System.out.println("Stan paliwa: " + getTank());
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Doors - " + doors);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters);
        System.out.print("auto\n");
    }
}
