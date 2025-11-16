import java.util.concurrent.atomic.AtomicInteger;

public class Adder {
    public static AtomicInteger sum = new AtomicInteger();

    public static void add(int value) {
        sum.addAndGet(value);
        System.out.println("Dodano " + value + " przez watek: " + Thread.currentThread());
    }
}
