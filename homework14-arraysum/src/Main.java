import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static int[] array;
    private static List<int[]> arrayParts = new ArrayList<>();

    public static void main(String[] args) {
        createArray();
        partitionArray();
        Thread[] threadsArray = new Thread[Constants.THREADS_AMOUNT];
        for (int i=0; i<Constants.THREADS_AMOUNT; i++) {
            int index = i;
            threadsArray[i] = new Thread(() -> {
                for (int value : arrayParts.get(index)) {
                    Adder.add(value);
                }
            });
        }

        for (Thread thread : threadsArray) {
            thread.start();
        }
        for (Thread thread : threadsArray) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(Adder.sum);
    }

    private static void createArray() {
        array = new int[Constants.ARRAY_SIZE];
        Arrays.fill(array, 1);
    }

    private static void partitionArray() {
        int threadResponsibility = Constants.ARRAY_SIZE / Constants.THREADS_AMOUNT;
        for (int i=0; i<Constants.THREADS_AMOUNT; i++) {
            arrayParts.add(Arrays.copyOfRange(array, i*threadResponsibility, (i+1)*threadResponsibility));
        }
    }
}
