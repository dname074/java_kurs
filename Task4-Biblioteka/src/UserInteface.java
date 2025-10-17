import java.util.List;
import java.util.Scanner;

public class UserInteface {
    private final Scanner scanner = new Scanner(System.in);

    protected void menu(Library library) {
        printOptions();
        System.out.println("Wybierz opcje: ");
        Option option = Option.getOptionFromInt(scanner.nextInt());

        switch(option) {
            case PRINT_ITEMS -> printAvailableItems(library);
            case BORROW_ITEM -> borrowItemByTitle(library);
            case RETURN_ITEM -> returnItemByTitle(library);
            case PRINT_ITEMS_AMOUNT -> printItemsAmount(library);
            case EXIT -> exitMessage();
        }
    }

    private void printOptions() {
        for (Option value : Option.values()) {
            System.out.println(value.toString());
        }
    }

    private void printAvailableItems(Library library) {
        List<LibraryItem> libraryItems = library.getAvailableItems();

        for (LibraryItem libraryItem : libraryItems) {
            System.out.println("Filmy: ");
            if (libraryItem instanceof Movie) {
                System.out.println(libraryItem);
            }
            System.out.println("Ksiazki: ");
            if (libraryItem instanceof Book) {
                System.out.println(libraryItem);
            }
        }
    }

    private void borrowItemByTitle() {

    }

    private void returnItemByTitle(Library library) {
        System.out.println("Podaj tytul: ");
        String title = scanner.nextLine();


    }

    private void printItemsAmount() {

    }

    private void exitMessage() {
        System.out.println("Koniec programu");
    }

    enum Option {
        PRINT_ITEMS(1, "Pokaz dostępne przedmioty"),
        BORROW_ITEM(2, "Wypozycz przedmiot"),
        RETURN_ITEM(3, "Oddaj przedmiot"),
        PRINT_ITEMS_AMOUNT(4, "Wyswietl liczbe przedmiotow w systemie"),
        EXIT(5, "Wyjscie");

        private final String description;
        private final int value;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        public static Option getOptionFromInt(int number) {
            return Option.values()[number-1];
        }

        @Override
        public String toString() {
            return String.format("%d. %s", value, description);
        }
    }
}
