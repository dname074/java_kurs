import java.util.Scanner;

public class Calculator {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String ifContinue = "y";
        double a;
        char operator;
        double b;
        Double result = null;

        while (!ifContinue.equals("n")) {
            System.out.println("Podaj pierwszą liczbę");
            a = getDouble();
            System.out.println("Podaj operator");
            operator = scanner.nextLine().charAt(0);
            System.out.println("Podaj druga liczbe");
            b = getDouble();

            if (b == 0 && (operator == '/' || operator == '%')) {
                System.out.println("Nie mozna dzielic przez 0");
                continue;
            }

            result = switch (operator) {
                case '+' -> a + b;
                case '-' -> a - b;
                case '*' -> a * b;
                case '/' -> a / b;
                case '%' -> a % b;
                case '^' -> pow(a, b);
                default -> null;
            };

            if (result == null) {
                System.out.println("Niepoprawne dane");
                continue;
            }

            System.out.println(result);

            System.out.println("Czy chcesz kontynuować?");
            ifContinue = scanner.nextLine();
        }
        checkIfEven(result);
    }

    private static double getDouble() {
        double number = scanner.nextDouble();
        scanner.nextLine();
        return number;
    }

    private static double pow(double a, double b) {
        double power = 1;

        for (int i = 0; i < b; i++) {
            power = power * a;
        }
        return power;
    }

    private static void checkIfEven(Double result) {
        if (result != null) {
            System.out.println(result % 2 == 0 ? "Ostatni wynik jest parzysty" : "Ostatni wynik jest nieparzysty");
        } else {
            System.out.println("Wynik null");
        }
    }
}
