import java.util.List;

public class Client {
    private final String firstName;
    private final String lastName;
    private final List<String> shoppingHistory;

    public Client(String firstName, String lastName, List<String> shoppingHistory) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.shoppingHistory = shoppingHistory;
    }

    public List<String> getShoppingHistory() {
        return shoppingHistory;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", shoppingHistory=" + shoppingHistory +
                '}';
    }
}
