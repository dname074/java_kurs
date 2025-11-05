import java.util.ArrayList;
import java.util.List;

public class CiagFibonacciego {
    private static List<Long> sequence = new ArrayList<>();

    static {
        sequence.add(0L);
        sequence.add(1L);
    }

    public static void main(String[] args) {
        System.out.println(calculateFibonacci(60));
    }

    private static long calculateFibonacci(int n) {
        return calculateFibonacciSequenceImproved(n);
    }

    private static long calculateFibonacciSequence(int n) {
        if (n == 0) {
            return 0;
        } else if (n==1) {
            return 1;
        } else {
            return calculateFibonacciSequence(n-1) + calculateFibonacciSequence(n-2);
        }
    }

    private static long calculateFibonacciSequenceImproved(int n) {
        if (sequence.size() <= n) {
            sequence.add(calculateFibonacciSequenceImproved(n-1) + calculateFibonacciSequenceImproved(n-2));
        }
        return sequence.get(n);
    }
}
