package net.hamnaberg.json.examples;

import io.vavr.collection.List;
import io.vavr.control.Option;
import net.hamnaberg.json.codec.DecodeResult;
import net.hamnaberg.json.Json;
import net.hamnaberg.json.jackson.JacksonStreamingParser;

import java.time.LocalDate;

import static net.hamnaberg.json.examples.MyExtractors.personExtractor;

public class ExtractMain {
    public static void main(String[] args) {
        Person p1 = new Person("John Doe", Option.some(LocalDate.of(1982, 1, 1)), List.empty());
        System.out.println("p1 = " + p1);
        Json.JValue data = new JacksonStreamingParser().parseUnsafe(ExtractMain.class.getResourceAsStream("/person.json"));
        System.out.println("data = " + data);

        DecodeResult<Person> decodePerson = personExtractor.fromJson(data);
        System.out.println("decodePerson = " + decodePerson);
    }
}
