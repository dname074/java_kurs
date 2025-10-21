import exception.ItemAlreadyAvailableException;
import exception.ItemIsNotAvailableException;
import exception.ItemNotFoundException;

import java.util.List;
import java.util.Scanner;

public class UserInteface {
    private final Scanner scanner = new Scanner(System.in);
    private final Library library;

    public UserInteface(Library library) {
        this.library = library;
    }

    protected void menu() {
        Option option = null;

        while (option!=Option.EXIT) {
            printOptions();
            System.out.println("Wybierz opcje: ");
            option = Option.getOptionFromInt(getIntFromUser());

            switch(option) {
                case PRINT_ITEMS -> printItemsFromLibrary();
                case BORROW_ITEM -> borrowItemByTitle();
                case RETURN_ITEM -> returnItemByTitle();
                case PRINT_ITEMS_AMOUNT -> printItemsAmount();
                case EXIT -> exitMessage();
            }
        }
    }

    private void printOptions() {
        for (Option value : Option.values()) {
            System.out.println(value.toString());
        }
    }

    private int getIntFromUser() {
        while (true) {
            String input = scanner.nextLine();

            if (input.matches("[1-5]")) {
                return Integer.parseInt(input);
            } else {
                System.err.println("Podaj poprawna wartosc");
            }
        }
    }

    private void printItemsFromLibrary() {
        List<LibraryItem> availableItems = library.getItems(true);
        List<LibraryItem> borrowedItems = library.getItems(false);

        System.out.println("Dostępne: ");
        printItems(availableItems);
        System.out.println("Już wypożyczone: ");
        printItems(borrowedItems);
    }

    private void printItems(List<LibraryItem> itemsList) {
        printMovies(itemsList);
        printBooks(itemsList);
    }

    private void printMovies(List<LibraryItem> itemsList) {
        System.out.println("Filmy: ");
        for (LibraryItem item : itemsList) {
            if (item instanceof Movie) {
                System.out.println(item);
            }
        }
    }

    private void printBooks(List<LibraryItem> itemsList) {
        System.out.println("Ksiazki: ");
        for (LibraryItem item : itemsList) {
            if (item instanceof Book) {
                System.out.println(item);
            }
        }
    }

    private void borrowItemByTitle() {
        String title = getTitleFromUser();
        try {
            LibraryItem borrowedItem = library.borrowItem(title);
            System.out.printf("Wypozyczony przedmiot: \n%s\n", borrowedItem);
        } catch (ItemNotFoundException | ItemIsNotAvailableException e) {
            System.err.println(e.getMessage());
        }
    }

    private void returnItemByTitle() {
        String title = getTitleFromUser();
        try {
            library.returnItem(title);
            System.out.println("Zwrocono przedmiot");
        } catch (ItemNotFoundException | ItemAlreadyAvailableException e) {
            System.err.println(e.getMessage());
        }
    }

    private String getTitleFromUser() {
        System.out.println("Podaj tytul: ");
        return scanner.nextLine();
    }

    private void printItemsAmount() {
        System.out.printf("W bibliotece znajduje sie %d przedmiotow\n", library.printItemsNumber());
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
