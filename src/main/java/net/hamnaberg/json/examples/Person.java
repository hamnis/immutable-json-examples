package net.hamnaberg.json.examples;

import io.vavr.collection.List;
import io.vavr.control.Option;

import java.time.LocalDate;

public class Person {
    public final String name;
    public final Option<LocalDate> birthDate;
    public final List<String> interests;

    public Person(String name, Option<LocalDate> birthDate, List<String> interests) {
        this.birthDate = birthDate;
        this.name = name;
        this.interests = interests;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", interests=" + interests +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!name.equals(person.name)) return false;
        if (!birthDate.equals(person.birthDate)) return false;
        return interests.equals(person.interests);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + birthDate.hashCode();
        result = 31 * result + interests.hashCode();
        return result;
    }
}
