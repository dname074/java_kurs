import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<LibraryItem> items = new ArrayList<>();

    public User(String username) {
        this.username = username;
    }

    public List<LibraryItem> getItems() {
        return items;
    }

    public void addItem(LibraryItem) {
        this.items = items;
    }
}
