import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class MyQueue {
    public static final int MAX_VALUES = 5;
    private List<Integer> queue = new LinkedList<>();
    private final Random random = new Random();

    public synchronized void produce() {
        while (queue.size() >= MAX_VALUES) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int value = random.nextInt(1,100);
        System.out.println("Producing value in queue: " + value);
        try {
            sleep(random.nextInt(100,2500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        queue.add(value);
        notifyAll();
    }

    public synchronized void consume() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Consuming value in queue: " + queue.getFirst() + " by thread " + Thread.currentThread());
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        queue.removeFirst();
        notifyAll();
    }
}
