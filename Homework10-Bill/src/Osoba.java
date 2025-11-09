public class Osoba {
    private final String firstName;
    private final String lastName;
    private final int age;

    public Osoba(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", firstName, lastName, age);
    }
}
