public class Rachunek {
    private Osoba wlasciciel;
    private double balance;

    public Rachunek(Osoba wlasciciel, double balance) {
        this.wlasciciel = wlasciciel;
        this.balance = balance;
    }

    public boolean payment(double price) {

    }

    public boolean paycheck(double price) {

    }

    public boolean transfer(double price, Rachunek rachunek) {

    }

    public void update() {

    }

    @Override
    public String toString() {
        return String.format("Account owner: %s \nAccount balance %f", wlasciciel.toString(), balance);
    }
}
