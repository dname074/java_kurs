import java.math.BigDecimal;
import java.util.Objects;

abstract class Vehicle {
    private String brand;
    private String model;
    private int year;
    private Double tank;
    private FuelType fuelType;
    private Double fuelConsumption; // per 100 km
    private Double tankCapacity;

    public Vehicle(String brand, String model, int year,
                   FuelType fuelType, Double fuelConsumption,
                   Double tankCapacity) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
        this.tank = 0.0;
    }

    public void displayInfo() {
        System.out.printf("""
                Brand - %s
                Model - %s
                Year - %d
                Fuel Type - %s
                Average Fuel Consumption - %.2f
                Fuel Tank Capacity - %.2f
                """, brand, model, year, fuelType.toString(), fuelConsumption, tankCapacity);
    }

    protected Double countFuelConsumption(Double kilometers) {
        return (fuelConsumption * kilometers) / 100;
    }

    protected boolean isFuelEnough(Double fuelConsumed) {
        return tank >= fuelConsumed;
    }

    protected Double countMissingKilometers(Double fuelConsumed) {
        if (isFuelEnough(fuelConsumed)) {
            return 0.0;
        } else {
            double missingFuel = fuelConsumed - tank;
            return ((missingFuel) * 100) / fuelConsumption;
        }
    }

    protected boolean isTankFull(Double liters) {
        return getTank() + liters > tankCapacity;
    }

    private BigDecimal countFuelCost(Double liters) {
        return fuelType.getPrice().multiply(BigDecimal.valueOf(liters));
    }

    public void refuel(Double liters) {
        BigDecimal fuelCost = countFuelCost(liters);
        System.out.printf("%.2f litrow - %.2f zl\n", liters, fuelCost);
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
        return year == vehicle.year && Objects.equals(brand, vehicle.brand) && Objects.equals(model, vehicle.model)
                && Objects.equals(tank, vehicle.tank) && fuelType == vehicle.fuelType && Objects.equals(fuelConsumption, vehicle.fuelConsumption)
                && Objects.equals(tankCapacity, vehicle.tankCapacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, tank, fuelType, fuelConsumption, tankCapacity);
    }
}
