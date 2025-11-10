import java.math.BigDecimal;

public class KontoVIP extends Konto {
    private BigDecimal debitLimit;
    private Double oprocentowanie;

    public KontoVIP(Osoba wlasciciel, BigDecimal balance, BigDecimal debitLimit, Double oprocentowanie) {
        super(wlasciciel, balance);
        this.debitLimit = debitLimit;
        this.oprocentowanie = oprocentowanie;
    }

    @Override
    public boolean paycheck(BigDecimal price) {
        if (price == null || !isDebitLimitEnough(price)) {
            System.out.println("Nie masz wystarczająco środków na koncie");
            return false;
        }

        balance = balance.subtract(price);
        return true;
    }

    @Override
    public boolean transfer(BigDecimal price, Rachunek rachunek) {
        if (rachunek == null || price == null || !isDebitLimitEnough(price)) {
            System.out.println("Nie masz wystarczająco środków na koncie");
            return false;
        }

        rachunek.setBalance(rachunek.getBalance().add(price));
        balance = balance.subtract(price);
        return true;
    }

    private boolean isDebitLimitEnough(BigDecimal price) {
        return debitLimit.compareTo(balance.subtract(price)) < 0;
    }

    @Override
    public void update() {
        balance = balance.multiply(new BigDecimal(1 - oprocentowanie));
    }

    @Override
    public String toString() {
        return String.format("%s\nStan konta: %.2f\nLimit debetu: %.2f\nOprocentowanie: %.2f", wlasciciel.toString(), balance, debitLimit, oprocentowanie);
    }
}
