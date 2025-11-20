import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NewQueue {
    public static final int MAX_VALUES = 5;
    private final Queue<Integer> queue = new LinkedList<>();
    public static final Random random = new Random();
    private Lock lock = new ReentrantLock();
    private Condition queueFull = lock.newCondition();
    private Condition queueEmpty = lock.newCondition();

    public void produce() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() >= MAX_VALUES) {
                queueFull.await();
            }
            int value = random.nextInt(1,100);
            System.out.println("Producing value in queue: " + value);
            queue.add(value);
            queueEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void consume()  throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                queueEmpty.await();
            }
            System.out.println("Consuming value in queue: " + queue.poll() + " by thread " + Thread.currentThread());
            queueFull.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
