package main;

import model.Komorka;
import model.Osoba;
import model.Smartfon;
import model.Telefon;

import java.awt.Color;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Osoba> znajomi = List.of(
                new Osoba("Jan", "Kowalski", "123-456-789"),
                new Osoba("Anna", "Nowak", "987-654-321"),
                new Osoba("Piotr", "Wiśniewski", "555-666-777")
        );

        List<Telefon> telefony = List.of(
                new Telefon("Analogowy", Color.BLACK),
                new Komorka("GSM", Color.BLUE),
                new Smartfon("LTE", Color.RED, znajomi)
        );

        List<String> numery = List.of(
                "123-456-789", "111-222-333", "987-654-321", "444-555-666", "555-666-777",
                "777-888-999", "123-456-789", "222-333-444", "987-654-321", "666-777-888"
        );

        // Wywołania zadzwon() dla każdego telefonu i każdego numeru
        telefony.forEach(telefon ->
                numery.forEach(telefon::zadzwon)
        );

        // Wyświetlenie historii połączeń
        telefony.forEach(telefon -> {
            System.out.println("Historia polaczen");
            telefon.wyswietlHistoriePolaczen();
        });
    }
}