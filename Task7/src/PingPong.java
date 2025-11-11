import static java.lang.Thread.sleep;

public class PingPong implements Runnable {
    public static final String PING = "PING";
    public static final String PONG = "PONG";
    private final String name;

    public PingPong(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            if (name.equals(PING)) {
                printLoop();
            }
            if (name.equals(PONG)){
                sleep(500);
                printLoop();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    private void printLoop() throws InterruptedException {
        for (int i=0; i<10; i++) {
            System.out.println(name);
            sleep(1000);
        }
    }
}
