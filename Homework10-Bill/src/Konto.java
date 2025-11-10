import java.math.BigDecimal;

public class Konto extends Rachunek {
    public static Double oprocentowanie = 0.05;

    public Konto(Osoba wlasciciel, BigDecimal balance) {
        super(wlasciciel, balance);
    }

    public static void zmienOprocentowanie(Double noweOprocentowanie) {
        if (noweOprocentowanie != null) {
            oprocentowanie = noweOprocentowanie;
        } else {
            System.out.println("Wprowadź nowe oprocentowanie");
        }
    }

    @Override
    public void update() {
        balance = balance.multiply(new BigDecimal(1 - oprocentowanie));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
