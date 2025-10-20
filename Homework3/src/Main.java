import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final Double R = 1.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj ilosc losowych punktow: ");
        int n = scanner.nextInt();

        List<Point> points = generatePoints(n);
        int numbersInsideCircle = countPointsInCircle(points);

        BigDecimal ratio = calculateRatio(numbersInsideCircle, n);

        BigDecimal PI = getPI(ratio);
        System.out.println("PI wynosi: " + PI);
    }

    private static List<Point> generatePoints(int n) {
        Random random = new Random();
        List<Point> points = new ArrayList<>();

        for (int i=0; i<n; i++) {
            points.add(new Point(random.nextDouble(-R,R), random.nextDouble(-R,R)));
        }
        return points;
    }

    private static int countPointsInCircle(List<Point> points) {
        int i = 0;

        for (Point point : points) {
            if (isPointInCircle(point)) {
                i++;
            }
        }
        return i;
    }

    private static boolean isPointInCircle(Point point) {
        return getSquareOfNumber(point.getX()) + getSquareOfNumber(point.getY()) <= getSquareOfNumber(R);
    }

    private static Double getSquareOfNumber(Double number) {
        return number*number;
    }

    private static BigDecimal calculateRatio(int nInCircle, int nTotal) {
        double ratio = (double) nInCircle / nTotal;

        return new BigDecimal(ratio);
    }

    private static BigDecimal getPI(BigDecimal ratio) {
        return ratio.multiply(new BigDecimal(4));
    }
}
