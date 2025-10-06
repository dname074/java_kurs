import java.util.Scanner;

public class Piramida {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj wielkosc trojkata: ");

        int x = scanner.nextInt();

        for (int i = 0; i < x; i+=2) {
            for (int j = 0; j < (x - i) / 2; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
