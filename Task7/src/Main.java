public class Main {
    public static void main(String[] args) {
        Thread ping = new Thread(new PingPong(PingPong.PING));
        Thread pong = new Thread(new PingPong(PingPong.PONG));

        ping.start();
        pong.start();
    }
}
