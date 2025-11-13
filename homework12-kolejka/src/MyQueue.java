import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MyQueue {
    public static final int MAX_VALUES = 5;
    private final Queue<Integer> queue = new LinkedList<>();
    public static final Random random = new Random();

    public void produce() throws InterruptedException {
        synchronized (queue) {
            while (queue.size() >= MAX_VALUES) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            int value = random.nextInt(1,100);
            System.out.println("Producing value in queue: " + value);
            queue.add(value);
            queue.notifyAll();
        }
    }

    public void consume()  throws InterruptedException {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Consuming value in queue: " + queue.poll() + " by thread " + Thread.currentThread());
            queue.notifyAll();
        }
    }
}
