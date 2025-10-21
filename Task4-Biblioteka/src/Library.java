import exception.ItemAlreadyAvailableException;
import exception.ItemIsNotAvailableException;
import exception.ItemNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private List<LibraryItem> libraryItems = new ArrayList<>();

    public void addItem(LibraryItem item) {
        if (item!=null) {
            libraryItems.add(item);
        }
    }

    public List<LibraryItem> getItems(boolean availableItems) {
        List<LibraryItem> items = new ArrayList<>();

        for (LibraryItem item : libraryItems) {
            if (availableItems) {
                if (!item.isBorrowed()) {
                    items.add(item);
                }
            } else {
                if (item.isBorrowed()) {
                    items.add(item);
                }
            }
        }
        return items;
    }

    public LibraryItem borrowItem(String title) {
        LibraryItem item = findItemByTitle(title).orElseThrow(() -> new ItemNotFoundException("Nie znaleziono szukanego przedmiotu w bibliotece"));

        if (!item.isBorrowed()) {
            item.setBorrowed(true);
            return item;
        }
        throw new ItemIsNotAvailableException("Szukany przedmiot nie jest w tej chwili dostepny");
    }

    public void returnItem(String title) throws ItemAlreadyAvailableException {
        LibraryItem item = findItemByTitle(title).orElseThrow(() -> new ItemNotFoundException("Podany przedmiot nie nalezy do tej biblioteki"));

        if (!item.isBorrowed()) {
            throw new ItemAlreadyAvailableException("Ten przedmiot jest juz dostepny w bibliotece");
        }
        item.setBorrowed(false);
    }

    private Optional<LibraryItem> findItemByTitle(String title) {
        for (LibraryItem item : libraryItems) {
            if (item.getTitle().equals(title)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    public Integer printItemsNumber() {
        return LibraryItem.getAmount();
    }
}
