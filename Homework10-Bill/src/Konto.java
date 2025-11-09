public class Konto extends Rachunek {
    public static Double oprocentowanie = 0.05;

    public static void zmienOprocentowanie(Double noweOprocentowanie) {
        if (noweOprocentowanie != null) {
            oprocentowanie = noweOprocentowanie;
        }
    }

    @Override
    public void update() {
        balance = balance * (1 - oprocentowanie);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
