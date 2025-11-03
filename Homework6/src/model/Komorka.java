package model;

import java.awt.*;
import java.util.Arrays;

public class Komorka extends Telefon {
    protected final String[] ostatniePolaczenia;
    private int callCounter = 0;
    public static final int MAX_CALLS = 10;

    public Komorka(String interfejsKomunikacyjny, Color color) {
        super(interfejsKomunikacyjny, color);
        this.ostatniePolaczenia = new String[MAX_CALLS];
    }

    //todo: poprawic tą metodę, żeby przesuwała tablicę
    @Override
    public void zadzwon(String numer) {
        if (callCounter < MAX_CALLS) {
            super.zadzwon(numer);
            ostatniePolaczenia[callCounter] = numer;
            callCounter++;
        }
    }

    @Override
    public void wyswietlHistoriePolaczen() {
        Arrays.stream(ostatniePolaczenia)
                .forEach(System.out::println);
    }
}
