public enum FuelType {
    PETROL("Benzyna", 6.99),
    DIESEL("Diesel", 6.99),
    ELECTRIC("Elektryczne", 2.99);

    private final String name;
    private final double price;

    FuelType(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", name, price);
    }
}
