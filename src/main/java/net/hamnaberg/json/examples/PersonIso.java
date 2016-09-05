package net.hamnaberg.json.examples;

import javaslang.Tuple3;
import javaslang.collection.List;
import javaslang.control.Option;
import net.hamnaberg.json.Iso;

import java.time.LocalDate;

public enum PersonIso implements Iso<Person, Tuple3<String, Option<LocalDate>, List<String>>> {
    INSTANCE;

    @Override
    public Tuple3<String, Option<LocalDate>, List<String>> get(Person person) {
        return new Tuple3<>(person.name, person.birthDate, person.interests);
    }

    @Override
    public Person reverseGet(Tuple3<String, Option<LocalDate>, List<String>> t) {
        return t.transform(Person::new);
    }
}
