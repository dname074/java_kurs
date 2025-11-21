package exercise2time;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class MainTime2 {
    public static void main(String[] args) {
        ZoneId warsawZone = ZoneId.of("Europe/Warsaw");
        ZoneId londonZone = ZoneId.of("Europe/London");
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        while (true){
            System.out.print("\r");
            System.out.printf("Warszawa: %s | Londyn: %s | Tokio: %s",
                    ZonedDateTime.now(warsawZone).format(formatter), ZonedDateTime.now(londonZone).format(formatter),
                    ZonedDateTime.now(tokyoZone).format(formatter));
            System.out.flush();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
