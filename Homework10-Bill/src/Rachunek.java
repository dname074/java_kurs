public class Rachunek {
    protected Osoba wlasciciel;
    protected double balance;

    public Rachunek(Osoba wlasciciel, double balance) {
        this.wlasciciel = wlasciciel;
        this.balance = balance;
    }

    public boolean payment(Double price) {
        if (price == null) {
            return false;
        }
        balance += price;
        return true;
    }

    public boolean paycheck(Double price) {
        if (price == null || balance < price) {
            return false;
        }

        balance -= price;
        return true;
    }

    public boolean transfer(Double price, Rachunek rachunek) {
        if (rachunek == null || price == null) {
            return false;
        }

        rachunek.setBalance(rachunek.getBalance() + price);
        return true;
    }

    public void update() {
        System.out.println("Rachunek podstawowy");
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("Account owner: %s \nAccount balance %f", wlasciciel.toString(), balance);
    }
}
