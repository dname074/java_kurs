import java.util.concurrent.Callable;

public class Adder implements Callable<Integer> {
    private final int start;
    private final int end;
    private final int[] array;

    public Adder(int start, int end, int[] array) {
        this.start = start;
        this.end = end;
        this.array = array;
    }

    @Override
    public Integer call() {
        int sum=0;
        for (int i=start; i<end; i++) {
            sum+=array[i];
        }
        return sum;
    }
}

