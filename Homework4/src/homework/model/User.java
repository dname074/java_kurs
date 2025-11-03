package homework.model;

import java.util.List;
import java.util.Objects;

public class User {
    private final String firstName;
    private final String lastName;
    private final Sex sex;
    private final int age;
    private final List<Account> accounts;
    private final List<Permit> permits;

    public User(String firstName, String lastName, Sex sex, int age, List<Account> accounts, List<Permit> permits) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
        this.accounts = accounts;
        this.permits = permits;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Permit> getPermits() {
        return permits;
    }

    @Override
    public String toString() {
        return "User: " +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", accounts=" + accounts +
                ", permits=" + permits;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && sex == user.sex && Objects.equals(accounts, user.accounts) && Objects.equals(permits, user.permits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, sex, age, accounts, permits);
    }
}
