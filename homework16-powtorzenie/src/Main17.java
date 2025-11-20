import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main17 {
    public static void main(String[] args) {

        // ==================== ZADANIA Z PRACY Z CZASEM W JAVIE ====================

        // ------------------------------------------------------------------------
        // ZADANIE 1: Praca z LocalDateTime
        // ------------------------------------------------------------------------

        /*
         * Zadanie:
         * Napisz program, który pobiera aktualną datę i czas lokalny, a następnie wyświetla je w formacie "dd-MM-yyyy HH:mm:ss".
         * Następnie dodaj 5 dni i 3 godziny do tej daty i wyświetl wynik.
         *
         * Wiedza sprawdzana w tym zadaniu:
         * - Użycie klasy LocalDateTime do reprezentowania daty i czasu.
         * - Formatowanie daty za pomocą DateTimeFormatter.
         * - Operacje na datach (dodawanie dni, godzin).
         */

        // Pobranie aktualnej daty i czasu lokalnego
        LocalDateTime teraz = LocalDateTime.now();
        System.out.println("Aktualna data i czas: " + teraz);

        // Formatowanie daty i czasu
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String sformatowanaData = teraz.format(formatter);
        System.out.println("Sformatowana data i czas: " + sformatowanaData);

        // Dodanie 5 dni i 3 godzin
        LocalDateTime przyszlaData = teraz.plusDays(5).plusHours(3);
        String sformatowanaPrzyszlaData = przyszlaData.format(formatter);
        System.out.println("Data po dodaniu 5 dni i 3 godzin: " + sformatowanaPrzyszlaData);

        // Wyjaśnienie:
        // - LocalDateTime.now() pobiera aktualną datę i czas bez strefy czasowej.
        // - DateTimeFormatter pozwala na formatowanie daty do podanego wzorca.
        // - Metody plusDays() i plusHours() pozwalają na dodawanie określonej liczby dni i godzin.

        // ------------------------------------------------------------------------
        // ZADANIA - Praca z LocalDateTime
        // ------------------------------------------------------------------------

        /*
         * 1. Napisz program, który pobiera od użytkownika datę urodzenia w formacie "dd-MM-yyyy" i oblicza jego wiek.
         *
         * 2. Napisz program, który tworzy listę ważnych dat (np. świąt) i wyświetla je posortowane według daty.
         *
         * 3. Napisz program, który oblicza różnicę w dniach między dwoma datami podanymi przez użytkownika.
         *
         * 4. Napisz program, który pobiera aktualną datę i wyświetla ją w różnych formatach (np. "yyyy/MM/dd", "dd MMMM yyyy").
         *
         * 5. Napisz program, który sprawdza, czy podana data jest przeszła, teraźniejsza czy przyszła w stosunku do aktualnej daty.
         */

        // ------------------------------------------------------------------------
        // ZADANIE 2: Użycie klasy Timestamp
        // ------------------------------------------------------------------------

        /*
         * Zadanie:
         * Napisz program, który konwertuje obiekt LocalDateTime na Timestamp i odwrotnie.
         * Wyświetl wyniki konwersji.
         *
         * Wiedza sprawdzana w tym zadaniu:
         * - Konwersja między LocalDateTime a Timestamp.
         * - Rozumienie, że Timestamp reprezentuje określony punkt w czasie z precyzją do nanosekund.
         */

        // Konwersja LocalDateTime do Timestamp
        LocalDateTime aktualnaDataCzas = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(aktualnaDataCzas);
        System.out.println("\nLocalDateTime: " + aktualnaDataCzas);
        System.out.println("Timestamp: " + timestamp);

        // Konwersja Timestamp do LocalDateTime
        Timestamp obecnyTimestamp = new Timestamp(System.currentTimeMillis());
        LocalDateTime ldtZTimestamp = obecnyTimestamp.toLocalDateTime();
        System.out.println("Obecny Timestamp: " + obecnyTimestamp);
        System.out.println("LocalDateTime z Timestamp: " + ldtZTimestamp);

        // Wyjaśnienie:
        // - Metoda valueOf() klasy Timestamp konwertuje LocalDateTime na Timestamp.
        // - Metoda toLocalDateTime() pozwala na konwersję w drugą stronę.
        // - Timestamp jest często używany w bazach danych do przechowywania znaczników czasu.

        // ------------------------------------------------------------------------
        // ZADANIA - Użycie klasy Timestamp
        // ------------------------------------------------------------------------

        /*
         * 1. Napisz program, który pobiera od użytkownika datę i czas w formacie "yyyy-MM-dd HH:mm:ss" i konwertuje ją na Timestamp.
         *
         * 2. Napisz program, który pobiera aktualny Timestamp i dodaje do niego 2 godziny, a następnie wyświetla wynik.
         *
         * 3. Napisz program, który oblicza różnicę w milisekundach między dwoma Timestampami.
         *
         * 4. Napisz program, który konwertuje Timestamp na datę w strefie czasowej UTC.
         *
         * 5. Napisz program, który zapisuje aktualny Timestamp do bazy danych (symulacja) i odczytuje go z powrotem.
         */

        // ------------------------------------------------------------------------
        // ZADANIE 3: Praca z OffsetDateTime i zrozumienie UTC
        // ------------------------------------------------------------------------

        /*
         * Zadanie:
         * Napisz program, który pobiera aktualną datę i czas w strefie czasowej UTC.
         * Następnie konwertuj tę datę na czas w strefie czasowej systemu lokalnego i wyświetl obie daty.
         *
         * Wiedza sprawdzana w tym zadaniu:
         * - Użycie klasy OffsetDateTime do reprezentowania daty i czasu z przesunięciem.
         * - Rozumienie, czym jest UTC (Coordinated Universal Time) – uniwersalny czas koordynowany.
         * - Konwersja między strefami czasowymi.
         */

        // Pobranie aktualnej daty i czasu w UTC
        OffsetDateTime terazUTC = OffsetDateTime.now(ZoneOffset.UTC);
        System.out.println("\nAktualna data i czas w UTC: " + terazUTC);

        // Konwersja na strefę czasową systemu lokalnego
        OffsetDateTime terazLokalny = terazUTC.withOffsetSameInstant(ZoneOffset.ofHours(2)); // Przykładowo UTC+2
        System.out.println("Aktualna data i czas w strefie lokalnej: " + terazLokalny);

        // Alternatywnie, możemy użyć ZoneId.systemDefault()
        ZonedDateTime terazSystemowy = terazUTC.atZoneSameInstant(ZoneId.systemDefault());
        System.out.println("Aktualna data i czas w strefie systemowej: " + terazSystemowy);

        // Wyjaśnienie:
        // - OffsetDateTime reprezentuje datę i czas z przesunięciem od UTC.
        // - ZoneOffset.UTC reprezentuje strefę czasową UTC (przesunięcie 0).
        // - Metoda withOffsetSameInstant() pozwala na konwersję między strefami czasowymi, zachowując ten sam punkt w czasie.
        // - ZoneId.systemDefault() pobiera domyślną strefę czasową systemu.

        // ------------------------------------------------------------------------
        // ZADANIA - Praca z OffsetDateTime i UTC
        // ------------------------------------------------------------------------

        /*
         * 1. Napisz program, który pobiera aktualną datę i czas w strefie czasowej Tokio i konwertuje ją na czas w strefie Nowego Jorku.
         *
         * 2. Napisz program, który sprawdza, ile godzin różnicy jest między strefą czasową użytkownika a UTC.
         *
         * 3. Napisz program, który pobiera od użytkownika datę i czas w jednej strefie czasowej i wyświetla ją w innej wybranej strefie.
         *
         * 4. Napisz program, który oblicza czas trwania lotu między dwoma miastami w różnych strefach czasowych.
         *
         * 5. Napisz program, który wyświetla listę wszystkich dostępnych stref czasowych w Javie.
         */

        // ------------------------------------------------------------------------
        // ZADANIE 4: Problemy ze wspieraniem stref czasowych
        // ------------------------------------------------------------------------

        /*
         * Zadanie:
         * Napisz program, który symuluje planowanie spotkania między osobami w trzech różnych strefach czasowych (np. Londyn, Nowy Jork, Tokio).
         * Ustal godzinę spotkania w strefie UTC i wyświetl lokalny czas dla każdej z tych stref.
         *
         * Wiedza sprawdzana w tym zadaniu:
         * - Rozumienie problemów związanych ze strefami czasowymi.
         * - Konwersja czasu między różnymi strefami czasowymi.
         * - Uwzględnienie zmiany czasu (DST) w różnych strefach.
         */

        // Ustalamy godzinę spotkania w UTC
        LocalDateTime dataSpotkaniaUTC = LocalDateTime.of(2023, Month.OCTOBER, 15, 14, 0);
        ZonedDateTime spotkanieUTC = dataSpotkaniaUTC.atZone(ZoneId.of("UTC"));
        System.out.println("\nGodzina spotkania w UTC: " + spotkanieUTC);

        // Strefy czasowe dla miast
        ZoneId strefaLondyn = ZoneId.of("Europe/London");
        ZoneId strefaNowyJork = ZoneId.of("America/New_York");
        ZoneId strefaTokio = ZoneId.of("Asia/Tokyo");

        // Konwersja czasu na lokalne strefy czasowe
        ZonedDateTime spotkanieLondyn = spotkanieUTC.withZoneSameInstant(strefaLondyn);
        ZonedDateTime spotkanieNowyJork = spotkanieUTC.withZoneSameInstant(strefaNowyJork);
        ZonedDateTime spotkanieTokio = spotkanieUTC.withZoneSameInstant(strefaTokio);

        // Wyświetlenie godzin spotkania w różnych strefach
        System.out.println("Godzina spotkania w Londynie: " + spotkanieLondyn);
        System.out.println("Godzina spotkania w Nowym Jorku: " + spotkanieNowyJork);
        System.out.println("Godzina spotkania w Tokio: " + spotkanieTokio);

        // Wyjaśnienie:
        // - Używamy ZonedDateTime do reprezentowania daty i czasu z informacją o strefie czasowej.
        // - Metoda withZoneSameInstant() konwertuje czas na inną strefę, zachowując ten sam moment w czasie.
        // - Różnice w strefach czasowych są automatycznie uwzględniane, w tym zmiany czasu (DST).

        // ------------------------------------------------------------------------
        // ZADANIA - Problemy ze wspieraniem stref czasowych
        // ------------------------------------------------------------------------

        /*
         * 1. Napisz program, który planuje połączenie konferencyjne między osobami w Sydney, Berlinie i San Francisco. Wyświetl lokalne godziny dla każdego uczestnika.
         *
         * 2. Napisz program, który sprawdza, czy podana data w strefie czasowej użytkownika istnieje, biorąc pod uwagę zmianę czasu (np. przy przejściu na czas letni/brakująca godzina).
         *
         * 3. Napisz program, który oblicza różnicę czasu między dwoma strefami w określonym dniu, uwzględniając zmiany czasu.
         *
         * 4. Napisz program, który pobiera datę i czas od użytkownika oraz strefę czasową, a następnie wyświetla czas w UTC.
         *
         * 5. Napisz program, który symuluje zegar światowy, wyświetlając aktualny czas w kilku wybranych miastach na świecie.
         */
    }
}