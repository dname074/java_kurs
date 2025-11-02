package model;

import java.awt.*;

public class Telefon {
    private final String interfejsKomunikacyjny;
    private final Color color;

    public Telefon(String interfejsKomunikacyjny, Color color) {
        this.interfejsKomunikacyjny = interfejsKomunikacyjny;
        this.color = color;
    }

    public void zadzwon(String numer) {
        System.out.println(numer);
    }

    public void wyswietlHistoriePolaczen() {
        System.out.println("Brak historii");
    }
}
