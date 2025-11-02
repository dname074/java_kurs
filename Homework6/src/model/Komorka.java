package model;

import java.awt.*;
import java.util.Arrays;

public class Komorka extends Telefon {
    private final String[] ostatniePolaczenia;
    private int callCounter = 0;
    public static final int MAX_CALLS = 10;

    public Komorka(String interfejsKomunikacyjny, Color color) {
        super(interfejsKomunikacyjny, color);
        this.ostatniePolaczenia = new String[MAX_CALLS];
    }

    @Override
    public void zadzwon(String numer) {
        super.zadzwon(numer);
        ostatniePolaczenia[callCounter] = numer;
        callCounter++;
    }

    public String[] getOstatniePolaczenia() {
        return ostatniePolaczenia;
    }

    @Override
    public void wyswietlHistoriePolaczen() {
        Arrays.stream(ostatniePolaczenia)
                .forEach(System.out::println);
    }
}
