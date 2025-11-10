import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<ShopItem> itemsList = Arrays.asList(
                new ShopItem("Chleb", 5.99),
                new ShopItem("Jajka", 8.99),
                new ShopItem("Makaron", 11.99),
                new ShopItem("Cola", 9.99),
                new ShopItem("Chipsy", 6.99),
                new ShopItem("Desperados", 5.99),
                new ShopItem("Baton", 3.99),
                new ShopItem("Mieso", 9.99),
                new ShopItem("Skyr", 5.99),
                new ShopItem("Serek wiejski", 3.99)
        );

        List<Client> clientsList = Arrays.asList(
                new Client("Adam", "Jakis", Arrays.asList("Chleb", "Jajka", "Makaron")),
                new Client("Piotr", "Nowak", Arrays.asList("Cola", "Chipsy", "Chleb", "Desperados", "Jajka", "Baton")),
                new Client("Jan", "Psichuta", Arrays.asList("Mieso", "Chipsy", "Skyr", "Jajka", "Serek wiejski"))
        );

        printBigShoppingClients(clientsList);

        System.out.printf("%.2f", getOverallShoppingPrice(clientsList, itemsList));
    }

    private static void printBigShoppingClients(List<Client> clientsList) {
        clientsList.stream()
                .filter(client -> client.getShoppingHistory().size() > 5)
                .forEach(System.out::println);
    }

    private static Double getOverallShoppingPrice(List<Client> clientsList, List<ShopItem> itemsList) {
        Map<String, Double> priceByName = itemsList.stream()
                .collect(Collectors.toMap(
                        ShopItem::getName,
                        ShopItem::getPrice
                ));

        return clientsList.stream()
                .flatMap(client -> client.getShoppingHistory().stream())
                .filter(priceByName::containsKey)
                .map(priceByName::get)
                .reduce(0.0, Double::sum);
    }
}

