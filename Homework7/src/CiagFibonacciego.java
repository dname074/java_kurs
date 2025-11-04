import java.util.ArrayList;
import java.util.List;

public class CiagFibonacciego {
    private static List<Long> sequence = new ArrayList<>();

    static {
        sequence.add(0L);
        sequence.add(1L);
    }

    public static void main(String[] args) {
        System.out.println(count(60));
    }

    private static long count(int n) {
        return countFibonacciSequenceImproved(n);
    }

    private static long countFibonacciSequence(int n) {
        if (n == 0) {
            return 0;
        } else if (n==1) {
            return 1;
        } else {
            return countFibonacciSequence(n-1) + countFibonacciSequence(n-2);
        }
    }

    private static long countFibonacciSequenceImproved(int n) {
        if (sequence.size() <= n) {
            sequence.add(countFibonacciSequenceImproved(n-1) + countFibonacciSequenceImproved(n-2));
        }
        return sequence.get(n);
    }
}
