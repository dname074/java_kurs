package Exercise1threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread1 implements Runnable {
    boolean isThreadEven;

    private final static Lock lock = new ReentrantLock();
    private final static Condition isOddCondition = lock.newCondition();
    private final static Condition isEvenCondition = lock.newCondition();
    private static boolean isEven = false;

    public Thread1(boolean isThreadEven) {
        this.isThreadEven = isThreadEven;
    }

    @Override
    public void run() {
        for (int i=1; i<=10; i++) {
            if (isThreadEven && i%2==0) {
                printEven(i);
            }
            if (!isThreadEven && i%2!=0) {
                printOdd(i);
            }
        }
    }

    private void printEven(int value) {
        lock.lock();
        try {
            while (!isEven) {
                isEvenCondition.await();
            }
            System.out.println(value);
            isEven = false;
            isOddCondition.signal();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    private void printOdd(int value) {
        lock.lock();
        try {
            while (isEven) {
                isOddCondition.await();
            }
            System.out.println(value);
            isEven = true;
            isEvenCondition.signal();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }
    }
}
