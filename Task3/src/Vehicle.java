import java.util.Objects;

abstract class Vehicle {
    private String brand;
    private String model;
    private int year;
    private double tank;
    private FuelType fuelType;
    public static final double MAX_FUEL = 30;

    public Vehicle(String brand, String model, int year, FuelType fuelType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.tank = 0;
    }

    public void displayInfo() {
        System.out.printf("""
                Brand - %s
                Model - %s
                Year - %d
                Fuel Type - %s
                """, brand, model, year, fuelType.toString());
    }

    public void refuel(double liters) {
        System.out.printf("%.2f litrow - %.2f zl\n", liters, liters * fuelType.getPrice());
        System.out.print("Tankuje ");
        setTank(getTank() + liters);
    }

    public double getTank() {
        return tank;
    }

    public void setTank(double tank) {
        this.tank = tank;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return year == vehicle.year && Objects.equals(brand, vehicle.brand) && Objects.equals(model, vehicle.model) && fuelType == vehicle.fuelType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, fuelType);
    }
}
