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

    public Optional<LibraryItem> borrowItem(String title) {
        for (LibraryItem item : libraryItems) {
            if (item.getTitle().equals(title) && !item.isBorrowed()) {
                item.setBorrowed(true);
                return Optional.of(item);
            }
        }

        return Optional.empty();
    }

    public boolean returnItem(String title) {
        for (LibraryItem item : libraryItems) {
            if (item.getTitle().equals(title)) {
                item.setBorrowed(false);
                return true;
            }
        }

        return false;
    }

    public Integer printItemsNumber() {
        return LibraryItem.getAmount();
    }
}
