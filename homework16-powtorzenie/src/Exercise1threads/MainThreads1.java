package Exercise1threads;

public class MainThreads1 {
    public static void main(String[] args) {
        Thread evenThread = new Thread(new Thread1(true));
        Thread oddThread = new Thread(new Thread1(false));

        evenThread.start();
        oddThread.start();
    }
}
