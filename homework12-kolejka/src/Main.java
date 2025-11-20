import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        Runnable producer = () -> IntStream.range(1, 31).forEach(i -> {
            try {
                sleep(queue.random.nextInt(1000));
                queue.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Runnable consumer = () -> IntStream.range(1, 11).forEach(i -> {
            try {
                sleep(1500);
                queue.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread producer1 = new Thread(producer);
        Thread consumer1 = new Thread(consumer);
        Thread consumer2 = new Thread(consumer);
        Thread consumer3 = new Thread(consumer);

        producer1.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}
