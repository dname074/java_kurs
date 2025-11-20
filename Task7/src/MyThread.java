import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread implements Runnable {
    public final static String PING = "PING";
    public final static String PONG = "PONG";
    private final String name;

    private final static Lock lock = new ReentrantLock();
    private final static Condition pingTurnCondition = lock.newCondition();
    private final static Condition pongTurnCondition = lock.newCondition();

    private static boolean isPing = true;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i=0; i<10; i++) {
                if (name.equals(PING)) {
                    ping();
                }
                if (name.equals(PONG)) {
                    pong();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void ping() throws InterruptedException{
        lock.lock();
        try {
            while (!isPing) {
                pingTurnCondition.await();
            }
            System.out.println(PING);
            isPing = false;
            pongTurnCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    private void pong() throws InterruptedException{
        lock.lock();
        try {
            while (isPing) {
                pongTurnCondition.await();
            }
            System.out.println(PONG);
            isPing = true;
            pingTurnCondition.signal();
        } finally {
            lock.unlock();
        }
    }
}
