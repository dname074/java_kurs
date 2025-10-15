public class Motorcycle extends Vehicle implements Drivable {
    public Motorcycle(String brand, String model, int year,
                      FuelType fuelType, Double fuelConsumption,
                      Double tankCapacity) {
        super(brand, model, year, fuelType, fuelConsumption, tankCapacity);
    }

    @Override
    public void drive(double kilometers) {
        double fuelConsumed = countFuelConsumption(kilometers);

        if (!isFuelEnough(fuelConsumed)) {
            System.out.println("Nie wystarczylo ci paliwa");
            System.out.printf("Do ukonczenia trasy zabraklo %.2f km\n",
                    countMissingKilometers(fuelConsumed));
            setTank(0);
        } else {
            System.out.println("Jade motorem");
            setTank(getTank() - fuelConsumed);
            System.out.printf("Stan paliwa %.2f\n", getTank());
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }

    @Override
    public void refuel(Double liters) {
        if (isTankFull(liters)) {
            System.out.println("Nie ma tyle miejsca w baku");
        } else {
            super.refuel(liters);
            System.out.println("motor");
        }
    }
}
