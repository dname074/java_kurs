import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static final int POPULAR_THRESHOLD = 3;

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Laptop", "Electronics", new BigDecimal("3000")),
                new Product("Phone", "Electronics", new BigDecimal("2000")),
                new Product("TV", "Electronics", new BigDecimal("4000")),
                new Product("Table", "Furniture", new BigDecimal("800")),
                new Product("Chair", "Furniture", new BigDecimal("400")),
                new Product("Lamp", "Home", new BigDecimal("200"))
        );

        List<Order> orders = List.of(
                new Order("Alice", "Laptop", 1, "North"),
                new Order("Bob", "Phone", 2, "North"),
                new Order("Charlie", "Laptop", 1, "West"),
                new Order("Alice", "Table", 3, "East"),
                new Order("David", "Laptop", 2, "South"),
                new Order("Eve", "TV", 1, "North"),
                new Order("Frank", "Laptop", 1, "West"),
                new Order("Alice", "Chair", 2, "North"),
                new Order("Charlie", "Phone", 1, "East"),
                new Order("Eve", "Lamp", 5, "South")
        );

        getPopularProducts(orders);

        getRegionsByCategory(orders, products).forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println(getMostExpensiveProduct(orders, products));
    }

    private static List<String> getPopularProducts(List<Order> orders) {
        return getProductsWithClients(orders)
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() > POPULAR_THRESHOLD)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static Map<String, Set<String>> getProductsWithClients(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getProductName,
                        Collectors.mapping(Order::getClientName, Collectors.toSet())
                ));
    }

    private static Map<String, BigDecimal> getCostsSumPerClient(List<Order> orders, List<Product> products) {
        Map<String, BigDecimal> productsWithPrice = getProductsWithPrice(products);
        return orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getClientName,
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                order -> productsWithPrice.getOrDefault(order.getProductName(), BigDecimal.ZERO)
                                        .multiply(BigDecimal.valueOf(order.getQuantity())),
                                BigDecimal::add
                        )
                ));
    }

    private static Map<String, BigDecimal> getProductsWithPrice(List<Product> products) {
        return products.stream()
                .collect(Collectors.toMap(
                        Product::getName,
                        Product::getPrice
                ));
    }

    private static Map<String, Set<String>> getRegionsByCategory(List<Order> orders, List<Product> products) {
        Map<String, String> productsCategories = getProductsWithCategories(products);
        return orders.stream()
                .collect(Collectors.groupingBy(
                        order -> productsCategories.get(order.getProductName()),
                        Collectors.mapping(Order::getRegion, Collectors.toSet())
                ));
    }

    private static Map<String,String> getProductsWithCategories(List<Product> products) {
        return products.stream()
                .collect(Collectors.toMap(
                        Product::getName,
                        Product::getCategory
                ));
    }

    private static Product getMostExpensiveProduct(List<Order> orders, List<Product> products) {
        Set<String> orderedProducts = getOrderedProducts(orders);

        return products.stream()
                .filter(p -> orderedProducts.contains(p.getName()))
                .max(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono zadnego produktu"));
    }

    private static Set<String> getOrderedProducts(List<Order> orders) {
        return orders.stream()
                .map(Order::getProductName)
                .collect(Collectors.toSet());
    }

    private static Map<String, Boolean> getRegionsWithElectronicsCategoryBought(List<Order> orders, List<Product> products) {
        Map<String, String> productsWithCategory = getProductsWithCategories(products);

        return orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getRegion,
                        Collectors.mapping(order -> "Electronics".equalsIgnoreCase(productsWithCategory.get(order.getProductName())),
                                Collectors.reducing(false, (a,b) -> a || b)
                                )
                ));
    }
}