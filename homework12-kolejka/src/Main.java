import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        Thread producer = new Thread(() -> IntStream.range(1, 31).forEach(i -> queue.produce()));
        Thread consumer1 = new Thread(() -> IntStream.range(1, 11).forEach(i -> queue.consume()));
        Thread consumer2 = new Thread(() -> IntStream.range(1, 11).forEach(i -> queue.consume()));
        Thread consumer3 = new Thread(() -> IntStream.range(1, 11).forEach(i -> queue.consume()));

        producer.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}
