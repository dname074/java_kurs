package Exercise1time;

import java.time.LocalDateTime;
import java.util.Objects;

public class Osoba {
    private String firstName;
    private String lastName;
    private String zone;
    private LocalDateTime meetingDate;

    public Osoba(String firstName, String lastName, String zone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zone = zone;
    }

    public String getZone() {
        return zone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Osoba osoba = (Osoba) o;
        return Objects.equals(firstName, osoba.firstName) && Objects.equals(lastName, osoba.lastName) && Objects.equals(zone, osoba.zone) && Objects.equals(meetingDate, osoba.meetingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, zone, meetingDate);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", firstName, lastName, zone);
    }
}
