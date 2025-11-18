import java.util.List;

public class MyThread implements Runnable {
    private final List<int[]> arrayParts;
    private int index;

    public static long totalSum = 0;
    private static final Object lock = new Object();

    public MyThread(List<int[]> arrayParts, int index) {
        this.arrayParts = arrayParts;
        this.index = index;
    }

    @Override
    public void run() {
        int sum=0;
        for (int value : arrayParts.get(index)) {
            sum+=value;
        }
        synchronized (lock) {
            totalSum+=sum;
        }
    }
}
