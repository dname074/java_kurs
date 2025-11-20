public class VolatileExample {
    public volatile static boolean x = true;
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("Jestem w watku 1");
            try {
                Thread.sleep(100L);
                System.out.println("watek pierwszy pospał");
                System.out.println("zmieniłęm flage na : false" );
                x = false;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("jestem w watku drugim ");
            while(x){
            }
            System.out.println("wyszedlem z petli waktu drugiego ");
//            while (x) {
//                synchronized (VolatileExample.class){};
//            }
//
//            System.out.println("wyszedłem z loopa");
        });
        thread2.start();
        thread1.start();
        Thread.sleep(200L);
    }
}