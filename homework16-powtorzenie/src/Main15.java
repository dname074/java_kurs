import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main15 {
    public static void main(String[] args) {
        // ==================== ZADANIA Z SYNCHRONICZNOŚCI I ASYNCHRONICZNOŚCI ORAZ WĄTKÓW W JAVIE ====================

        // ------------------------------------------------------------------------
        // ZADANIE 1: Rozumienie synchroniczności i asynchroniczności
        // ------------------------------------------------------------------------

        /*
         * Zadanie:
         * Napisz program, który symuluje pobieranie danych z dwóch źródeł:
         * - Dane z bazy danych (operacja trwająca 3 sekundy)
         * - Dane z serwera API (operacja trwająca 5 sekund)
         * Wykonaj te operacje:
         * a) Synchronicznie (jedna po drugiej)
         * b) Asynchronicznie (obie jednocześnie)
         * Zmierz i porównaj czas wykonania w obu przypadkach.
         *
         * Wiedza sprawdzana w tym zadaniu:
         * - Rozumienie różnicy między wykonaniem synchronicznym a asynchronicznym.
         * - Umiejętność tworzenia wątków i zarządzania nimi.
         * - Pomiar czasu wykonania operacji.
         */

        // a) Wykonanie synchroniczne
        System.out.println("Wykonanie synchroniczne:");

        long startTimeSync = System.currentTimeMillis();

        pobierzDaneZBazy();
        pobierzDaneZSerwera();

        long endTimeSync = System.currentTimeMillis();
        long durationSync = endTimeSync - startTimeSync;

        System.out.println("Czas wykonania (synchronicznie): " + durationSync + " ms");

        // b) Wykonanie asynchroniczne
        System.out.println("\nWykonanie asynchroniczne:");

        long startTimeAsync = System.currentTimeMillis();

        Thread watekBazy = new Thread(() -> pobierzDaneZBazy());
        Thread watekSerwera = new Thread(() -> pobierzDaneZSerwera());

        watekBazy.start();
        watekSerwera.start();

        try {
            watekBazy.join();
            watekSerwera.join();
        } catch (InterruptedException e) {
            e.getMessage();
        }

        long endTimeAsync = System.currentTimeMillis();
        long durationAsync = endTimeAsync - startTimeAsync;

        System.out.println("Czas wykonania (asynchronicznie): " + durationAsync + " ms");

        // Wyjaśnienie:
        // - W wykonaniu synchronicznym metody pobierające dane są wywoływane jedna po drugiej.
        // - W wykonaniu asynchronicznym tworzymy dwa wątki, które wykonują metody jednocześnie.
        // - Metoda join() czeka na zakończenie wątków.
        // - Czas wykonania asynchronicznego powinien być krótszy niż sumaryczny czas operacji synchronicznych.

        // ------------------------------------------------------------------------
        // ZADANIA - Rozumienie synchroniczności i asynchroniczności
        // ------------------------------------------------------------------------

        /*
         * 1. Napisz program, który symuluje pobieranie trzech plików (każdy trwa 2 sekundy) i wykonaj to:
         *    a) Synchronicznie
         *    b) Asynchronicznie
         *    Porównaj czasy wykonania.
         *
         * 2. Napisz program, który symuluje wykonywanie dwóch niezależnych obliczeń matematycznych (każde trwa 4 sekundy):
         *    a) Wykonaj je synchronicznie.
         *    b) Wykonaj je asynchronicznie.
         *    Porównaj czasy wykonania.
         */

        // ------------------------------------------------------------------------
        // ZADANIE 2: Czym jest wątek i jak go uruchomić?
        // ------------------------------------------------------------------------

        /*
         * Zadanie:
         * Napisz program, który tworzy i uruchamia wątek, który wyświetla liczby od 1 do 5 z opóźnieniem 1 sekundy między każdą liczbą.
         * W tym samym czasie w wątku głównym wyświetlaj litery od 'A' do 'E' z opóźnieniem 1,5 sekundy.
         *
         * Wiedza sprawdzana w tym zadaniu:
         * - Tworzenie i uruchamianie wątków poprzez implementację interfejsu Runnable lub dziedziczenie po klasie Thread.
         * - Rozumienie współbieżnego wykonywania kodu w różnych wątkach.
         */

        // Tworzenie wątku poprzez implementację interfejsu Runnable
        Runnable liczbyRunnable = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Liczba: " + i);
                try {
                    Thread.sleep(1000); // Opóźnienie 1 sekundy
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread watekLiczby = new Thread(liczbyRunnable);
        watekLiczby.start();

        // W wątku głównym wyświetlamy litery
        char litera = 'A';
        for (int i = 0; i < 5; i++) {
            System.out.println("Litera: " + (char) (litera + i));
            try {
                Thread.sleep(1500); // Opóźnienie 1,5 sekundy
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Wyjaśnienie:
        // - Tworzymy obiekt Runnable jako wyrażenie lambda.
        // - Tworzymy wątek, przekazując Runnable do konstruktora Thread.
        // - Wątek główny wykonuje swoją pracę niezależnie od wątku liczbyRunnable.

        // ------------------------------------------------------------------------
        // ZADANIA - Tworzenie i uruchamianie wątków
        // ------------------------------------------------------------------------

        /*
         * 1. Napisz program, który tworzy wątek wyświetlający napisy "Ping" co 1 sekundę, a w wątku głównym wyświetla "Pong" co 1,5 sekundy.
         *
         * 2. Napisz program, który tworzy dwa wątki:
         *    - Pierwszy wyświetla liczby parzyste od 2 do 10.
         *    - Drugi wyświetla liczby nieparzyste od 1 do 9.
         *    Oba wątki działają jednocześnie.
         */

        // ------------------------------------------------------------------------
        // ZADANIE 3: Użycie Thread Pool (puli wątków)
        // ------------------------------------------------------------------------

        /*
         * Zadanie:
         * Napisz program, który tworzy pulę wątków o rozmiarze 3 (FixedThreadPool).
         * Następnie zgłoś do wykonania 5 zadań polegających na wyświetleniu nazwy wątku i numeru zadania.
         * Zakończ pulę wątków po wykonaniu zadań.
         *
         * Wiedza sprawdzana w tym zadaniu:
         * - Tworzenie i zarządzanie pulą wątków za pomocą klasy ExecutorService.
         * - Zgłaszanie zadań do wykonania przez pulę wątków.
         * - Zamykanie puli wątków po zakończeniu pracy.
         */

        System.out.println("\nUżycie Thread Pool:");

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Zgłaszamy 5 zadań do wykonania
        for (int i = 1; i <= 5; i++) {
            int numerZadania = i;
            executorService.submit(() -> {
                String nazwaWatku = Thread.currentThread().getName();
                System.out.println("Wykonuję zadanie " + numerZadania + " w wątku " + nazwaWatku);
            });
        }

        // Zakończenie puli wątków
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        // Wyjaśnienie:
        // - Tworzymy ExecutorService z trzema wątkami.
        // - Metoda submit() zgłasza zadania do wykonania.
        // - Metoda shutdown() zamyka pulę po wykonaniu wszystkich zadań.
        // - Metoda awaitTermination() czeka na zakończenie wszystkich zadań.

        // ------------------------------------------------------------------------
        // ZADANIA - Użycie Thread Pool
        // ------------------------------------------------------------------------

        /*
         * 1. Napisz program, który tworzy pulę wątków o rozmiarze 2 i zgłasza 10 zadań polegających na wyświetleniu liczby od 1 do 10.
         *
         * 2. Napisz program, który tworzy pulę wątków CachedThreadPool i zgłasza do niej 5 zadań, które symulują obciążające obliczenia (np. Thread.sleep()).
         */

        // ------------------------------------------------------------------------
        // ZADANIE 4: Użycie Future do pobierania wyników asynchronicznych zadań
        // ------------------------------------------------------------------------

        /*
         * Zadanie:
         * Napisz program, który tworzy pulę wątków i zgłasza zadanie obliczenia silni liczby podanej przez użytkownika.
         * Użyj interfejsu Future, aby pobrać wynik obliczenia po jego zakończeniu.
         *
         * Wiedza sprawdzana w tym zadaniu:
         * - Użycie interfejsu Future do reprezentowania wyniku asynchronicznego zadania.
         * - Pobieranie wyniku za pomocą metody get().
         */

        System.out.println("\nUżycie Future:");

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbę do obliczenia silni: ");
        int liczbaSilnia = scanner.nextInt();

        Future<Long> futureResult = executor.submit(() -> obliczSilnie(liczbaSilnia));

        try {
            Long wynikSilnia = futureResult.get(); // Metoda get() czeka na zakończenie zadania
            System.out.println("Silnia z " + liczbaSilnia + " wynosi " + wynikSilnia);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();

        // Wyjaśnienie:
        // - Metoda submit() zwraca obiekt Future, który reprezentuje wynik zadania.
        // - Metoda get() blokuje wątek główny, dopóki wynik nie będzie dostępny.



        // ------------------------------------------------------------------------
        // ZADANIA - Użycie Future
        // ------------------------------------------------------------------------

        /*
         * 1. Napisz program, który zgłasza zadanie obliczenia sumy liczb od 1 do N i pobiera wynik za pomocą Future.
         *
         * 2. Napisz program, który zgłasza kilka zadań obliczających potęgi liczby 2 (2^n) dla różnych n i zbiera wyniki za pomocą Future.
         */

        // ------------------------------------------------------------------------
        // ZADANIE 5: Użycie CompletableFuture do asynchronicznego przetwarzania
        // ------------------------------------------------------------------------

        /*
         * Zadanie:
         * Napisz program, który pobiera dane użytkownika z bazy danych (symulacja) i następnie wysyła do niego e-mail powitalny.
         * Wykorzystaj CompletableFuture, aby:
         * - Pobranie danych i wysłanie e-maila odbywało się asynchronicznie.
         * - Po zakończeniu wyświetl komunikat potwierdzający.
         *
         * Wiedza sprawdzana w tym zadaniu:
         * - Użycie CompletableFuture do asynchronicznego przetwarzania zadań.
         * - Łączenie zadań za pomocą metod thenApply(), thenAccept(), etc.
         */

        System.out.println("\nUżycie CompletableFuture:");

        CompletableFuture<Void> przyszlosc = CompletableFuture.supplyAsync(() -> pobierzDaneUzytkownika())
                .thenAccept(uzytkownik -> wyslijEmailPowitalny(uzytkownik));

        przyszlosc.join(); // Czekamy na zakończenie

        System.out.println("Proces rejestracji zakończony.");

        // Wyjaśnienie:
        // - Metoda supplyAsync() uruchamia zadanie asynchronicznie i zwraca CompletableFuture.
        // - Metoda thenAccept() wykonuje akcję po zakończeniu poprzedniego zadania.
        // - Metoda join() czeka na zakończenie wszystkich zadań.

        // ------------------------------------------------------------------------
        // ZADANIA- Użycie CompletableFuture
        // ------------------------------------------------------------------------

        /*
         * 1. Napisz program, który asynchronicznie pobiera cenę produktu z trzech różnych sklepów (symulacja) i po otrzymaniu wszystkich cen wyświetla najniższą.
         *
         * 2. Napisz program, który asynchronicznie pobiera dane pogodowe z serwera, a następnie wyświetla prognozę. W przypadku błędu wyświetl komunikat o problemie z połączeniem.
         */

        // ------------------------------------------------------------------------
        // ZADANIE 6: Zaawansowane - Użycie ExecutorService i Callable
        // ------------------------------------------------------------------------

        /*
         * Zadanie:
         * Napisz program, który tworzy pulę wątków i zgłasza do niej zadania implementujące interfejs Callable.
         * Każde zadanie powinno zwracać swój numer i nazwę wątku, w którym jest wykonywane.
         * Zbierz wyniki zadań i wyświetl je.
         *
         * Wiedza sprawdzana w tym zadaniu:
         * - Tworzenie zadań implementujących Callable<T>.
         * - Zgłaszanie zadań Callable do ExecutorService.
         * - Pobieranie wyników z Future.
         */

        System.out.println("\nUżycie ExecutorService i Callable:");

        ExecutorService executorCallable = Executors.newFixedThreadPool(3);

        List<Future<String>> listaWynikow = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            int numerZadania = i;
            Future<String> wynik = executorCallable.submit(() -> {
                String nazwaWatku = Thread.currentThread().getName();
                return "Zadanie " + numerZadania + " wykonane w wątku " + nazwaWatku;
            });
            listaWynikow.add(wynik);
        }

        for (Future<String> future : listaWynikow) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorCallable.shutdown();

        // Wyjaśnienie:
        // - Zadania Callable zwracają wartość.
        // - Metoda submit() zwraca Future, z którego możemy pobrać wynik.
        // - Możemy zbierać i przetwarzać wyniki po zakończeniu zadań.

        // ------------------------------------------------------------------------
        // ZADANIA - Użycie ExecutorService i Callable
        // ------------------------------------------------------------------------

        /*
         * 1. Napisz program, który tworzy pulę wątków i zgłasza zadania obliczające iloczyn dwóch losowych liczb. Zbierz i wyświetl wyniki.
         *
         * 2. Napisz program, który zgłasza kilka zadań pobierających zawartość stron internetowych (symulacja) i zwraca status pobrania. Zbierz i wyświetl wyniki.
         */

    }

    // Definicje metod używanych w zadaniach

    public static long obliczSilnie(int n) {
        long wynik = 1;
        for (int i = 1; i <= n; i++) {
            wynik *= i;
            try {
                Thread.sleep(200); // Symulacja obciążenia
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return wynik;
    }

    public static String pobierzDaneUzytkownika() {
        try {
            System.out.println("Pobieranie danych użytkownika...");
            Thread.sleep(2000); // Symulacja opóźnienia
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Jan Kowalski";
    }

    public static void wyslijEmailPowitalny(String uzytkownik) {
        try {
            System.out.println("Wysyłanie e-maila do " + uzytkownik);
            Thread.sleep(1000); // Symulacja opóźnienia
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("E-mail wysłany do " + uzytkownik);
    }

    public static void pobierzDaneZBazy() {
        try {
            System.out.println("Pobieranie danych z bazy danych...");
            Thread.sleep(3000); // Symulacja opóźnienia 3 sekundy
            System.out.println("Dane z bazy danych pobrane.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void pobierzDaneZSerwera() {
        try {
            System.out.println("Pobieranie danych z serwera...");
            Thread.sleep(5000); // Symulacja opóźnienia 5 sekund
            System.out.println("Dane z serwera pobrane.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}