package model;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Smartfon extends Komorka {
    private final List<Osoba> znajomi;

    public Smartfon(String interfejsKomunikacyjny, Color color, List<Osoba> znajomi) {
        super(interfejsKomunikacyjny, color);
        this.znajomi = znajomi;
    }

    @Override
    public void zadzwon(String numer) {
        super.zadzwon(numer);
    }

    @Override
    public void wyswietlHistoriePolaczen() {
        String[] polaczenia = getOstatniePolaczenia();
        Arrays.stream(polaczenia)
                .limit(10)
                .forEach(number -> getPersonByNumber(number)
                        .ifPresentOrElse(
                                System.out::println,
                                () -> System.out.println(number)
                        ));
    }

    private Optional<Osoba> getPersonByNumber(String number) {
        return znajomi.stream()
                .filter(osoba -> osoba.getNumer().equals(number))
                .findFirst();
    }
}
