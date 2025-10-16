import java.util.*;

public class Main {
    private static Map<Long, List<Point>> pointsMap = new HashMap<>();
    private static Random randomizer = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ile chcesz wygenerowac punktow?");
        int amount = scanner.nextInt();
        generatePoints(amount);
        printMap();
    }

    private static void generatePoints(int amount) {
        for (int i = 0; i < amount; i++) {
            long x = randomizer.nextInt(0,10);
            long y = randomizer.nextInt(0,10);

            addToMap(new Point(x, y));
        }
    }

    private static void addToMap(Point point) {
        long x = point.getX();

        if (!pointsMap.containsKey(x)) {
            pointsMap.put(x, new ArrayList<>());
            System.out.println("Dodano nowy klucz");
        }

        pointsMap.get(x).add(point);
    }

    private static void printMap() {
//        pointsMap.forEach((key, points) -> {
//            System.out.println("Klucz: " + key);
//            points.forEach(System.out::println);
//        }); wczesniejsza wersja

        for (Map.Entry<Long, List<Point>> longListEntry : pointsMap.entrySet()) {
            Long key = longListEntry.getKey();
            List<Point> points = longListEntry.getValue();

            System.out.println("Klucz " + key);
            System.out.println("Wartosci: ");
            for (Point p : points) {
                System.out.println(p + " ");
            }
        }
    }
}
