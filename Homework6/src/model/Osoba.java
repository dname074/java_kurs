package model;

public class Osoba {
    private final String imie;
    private final String nazwisko;
    private final String numer;

    public Osoba(String imie, String nazwisko, String numer) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numer = numer;
    }

    public String getNumer() {
        return numer;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", imie, nazwisko, numer);
    }
}
