import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Rachunek> kontaBankowe = Arrays.asList(
                new Rachunek(new Osoba("Jan", "Kowalski", 45), new BigDecimal(1500)),
                new Konto(new Osoba("Karol", "Nowak", 20), new BigDecimal(400)),
                new KontoVIP(new Osoba("Maciek", "Batat", 38), new BigDecimal(800), new BigDecimal(-5000), 0.03)
                );

        Rachunek destAccount = new Konto(new Osoba("Dorian", "Smykalka", 50), new BigDecimal(0));

        System.out.println("Konta przed zmianami: ");
        kontaBankowe.forEach(System.out::println);

        System.out.println("Konta po zmianach: ");
        Konto.zmienOprocentowanie(0.07);
        kontaBankowe.forEach(konto -> {
            if (!konto.payment(new BigDecimal(300))) {
                System.out.println("Wprowadź kwotę");
            }
            if (!konto.paycheck(new BigDecimal(200))) {
                System.out.println("Nie masz wystarczająco środków na koncie");
            }
            if (!konto.transfer(new BigDecimal(100), destAccount)) {
                System.out.println("Nie masz wystarczająco środków na koncie");
            }
            konto.update();
            System.out.println(konto);
        });
        System.out.println("---------");

        kontaBankowe.get(2).transfer(new BigDecimal(6000), destAccount);
        System.out.println(kontaBankowe.get(2));
        System.out.println(destAccount);
    }
}
