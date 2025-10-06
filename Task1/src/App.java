import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj wymiary prostokatu: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        for (int i=0;i<x; i++) {
            for (int j=0; j<y; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
