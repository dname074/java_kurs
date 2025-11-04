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
        super.zadzwon(numer);
        if (callCounter < MAX_CALLS) {
            ostatniePolaczenia[callCounter] = numer;
            callCounter++;
            return;
        }
        for (int i=1; i<ostatniePolaczenia.length; i++) {
            ostatniePolaczenia[i-1] = ostatniePolaczenia[i];
        }
        ostatniePolaczenia[MAX_CALLS-1] = numer;
    }

    @Override
    public void wyswietlHistoriePolaczen() {
        Arrays.stream(ostatniePolaczenia)
                .forEach(System.out::println);
    }
}
