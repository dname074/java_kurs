public class CiagFibonacciego {
    public static void main(String[] args) {
        System.out.println(count(48));
    }

    private static int count(int n) {
        return countFibonacciSequence(n);
    }

    private static int countFibonacciSequence(int n) {
        if (n == 0) {
            return 0;
        } else if (n==1) {
            return 1;
        } else {
            return countFibonacciSequence(n-1) + countFibonacciSequence(n-2);
        }
    }
}
