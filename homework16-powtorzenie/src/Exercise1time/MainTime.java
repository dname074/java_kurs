package Exercise1time;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainTime {
    public static void main(String[] args) {
        List<Osoba> people = Arrays.asList(new Osoba("John", "Doe", "Europe/London"),
                new Osoba("Kim", "Yang", "Asia/Tokyo"),
                new Osoba("Mike", "Mitchell", "America/New_York"));
        Map<Osoba, ZonedDateTime> zonedMeetingsDates = new HashMap<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        ZonedDateTime meetingUTC = ZonedDateTime.of(2025, 12, 5, 15, 30, 0, 0,ZoneId.of("UTC"));

        System.out.println("UTC meeting time: " + meetingUTC.format(formatter));

        for (Osoba person : people) {
            if (!zonedMeetingsDates.containsKey(person)) {
                zonedMeetingsDates.put(person, meetingUTC.withZoneSameInstant(ZoneId.of(person.getZone())));
            }
        }

        zonedMeetingsDates
                .forEach((person, zonedDateTime) -> System.out.printf("%s %s \n", person.toString(), zonedDateTime.format(formatter)));
    }
}
