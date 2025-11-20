import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(Constants.THREADS_AMOUNT);
        int totalSum = 0;

        int[] array = createAndFillArray();
        int partSize = Constants.ARRAY_SIZE / Constants.THREADS_AMOUNT;

        for (int i=0; i<Constants.THREADS_AMOUNT; i++) {
            int start = i * partSize;
            int end = (i == Constants.THREADS_AMOUNT - 1)? Constants.ARRAY_SIZE: start + partSize;

            totalSum += executor.submit(new Adder(start,end,array)).get();
        }
        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        System.out.println(totalSum);
        System.out.println(endTime - startTime);
    }

    private static int[] createAndFillArray() {
        int[] array = new int[Constants.ARRAY_SIZE];
        Arrays.fill(array, 1);
        return array;
    }
}

