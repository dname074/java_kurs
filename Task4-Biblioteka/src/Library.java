import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<LibraryItem> libraryItems = new ArrayList<>();

    public List<LibraryItem> getAvailableItems() {
        return libraryItems;
    }

    public LibraryItem borrowItem(String title) {
        for (int i = 0; i < libraryItems.size(); i++) {
            if (libraryItems.get(i).getTitle().equals(title)) {
                return libraryItems.get(i);
            }
        }

        return null;
    }

    public void returnItem(LibraryItem item) {
        libraryItems.add(item);
    }

    public Integer printItemsNumber() {
        return libraryItems.size();
    }
}
