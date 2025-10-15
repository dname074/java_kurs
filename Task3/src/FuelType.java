import java.math.BigDecimal;

public enum FuelType {
    PETROL("Benzyna", BigDecimal.valueOf(6.99)),
    DIESEL("Diesel", BigDecimal.valueOf(6.99)),
    ELECTRIC("Elektryczne", BigDecimal.valueOf(2.99));

    private final String name;
    private final BigDecimal price;

    FuelType(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", name, price);
    }
}
