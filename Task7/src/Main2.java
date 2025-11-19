public class Main2 {
    public static void main(String[] args) {
        Thread ping = new Thread(new MyThread(MyThread.PING));
        Thread pong = new Thread(new MyThread(MyThread.PONG));

        ping.start();
        pong.start();
    }
}