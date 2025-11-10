import java.math.BigDecimal;

public class Rachunek {
    protected Osoba wlasciciel;
    protected BigDecimal balance;

    public Rachunek(Osoba wlasciciel, BigDecimal balance) {
        this.wlasciciel = wlasciciel;
        this.balance = balance;
    }

    public boolean payment(BigDecimal price) {
        if (price == null) {
            return false;
        }
        balance = balance.add(price);
        return true;
    }

    public boolean paycheck(BigDecimal price) {
        if (price == null || !isBalanceEnough(price)) {
            return false;
        }

        balance = balance.subtract(price);
        return true;
    }

    public boolean transfer(BigDecimal price, Rachunek rachunek) {
        if (rachunek == null || price == null || !isBalanceEnough(price)) {
            return false;
        }

        rachunek.setBalance(rachunek.getBalance().add(price));
        balance = balance.subtract(price);
        return true;
    }

    public void update() {
        System.out.println("Rachunek podstawowy");
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    private boolean isBalanceEnough(BigDecimal price) {
        return balance.compareTo(price) >= 0;
    }

    @Override
    public String toString() {
        return String.format("Account owner: %s \nAccount balance %.2f", wlasciciel.toString(), balance);
    }
}
