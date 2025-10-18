import java.util.Objects;

public abstract class LibraryItem {
    private String title;
    private boolean isBorrowed;
    private static int amount = 0;

    public LibraryItem(String title) {
        this.title = title;
        isBorrowed = false;
        amount += 1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public static int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LibraryItem that = (LibraryItem) o;
        return isBorrowed == that.isBorrowed && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, isBorrowed);
    }

    @Override
    public String toString() {
        return "title: " + title + '\n';
    }
}
