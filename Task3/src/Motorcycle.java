public class Motorcycle extends Vehicle implements Drivable {
    public Motorcycle(String brand, String model, int year, FuelType fuelType) {
        super(brand, model, year, fuelType);
    }

    @Override
    public void drive() {
        if (getTank() < 0.2) {
            System.out.println("Brak paliwa");
        } else {
            System.out.println("Jade motorem");
            setTank(getTank() - 0.2);
            System.out.println("Stan paliwa: " + getTank());
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }

    @Override
    public void refuel(double liters) {
        if (getTank() + liters > MAX_FUEL) {
            System.out.println("Nie ma tyle miejsca w baku");
        } else {
            super.refuel(liters);
            System.out.print("motor\n");
        }
    }
}
