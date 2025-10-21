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
        return findItemByTitle(title)
                .filter(item -> !item.isBorrowed())
                .map(item -> {
                    item.setBorrowed(true);
                    return item;
                });
    }

    public boolean returnItem(String title) {
        return findItemByTitle(title)
                .filter(LibraryItem::isBorrowed)
                .map(item -> {
                    item.setBorrowed(false);
                    return true;
                })
                .orElse(false);
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
