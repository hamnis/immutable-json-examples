package net.hamnaberg.json.examples;

import net.hamnaberg.json.codec.Decoders;
import net.hamnaberg.json.codec.DecodeJson;

import java.time.LocalDate;

import static net.hamnaberg.json.codec.FieldDecoder.*;

public class MyExtractors {

    public static DecodeJson<Person> personExtractor = Decoders.decode(
            TString("name"),
            TOptional("birthDate", Decoders.DString.map(LocalDate::parse)),
            TList("interests", Decoders.DString),
            Person::new
    );
}
