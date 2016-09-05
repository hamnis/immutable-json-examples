package net.hamnaberg.json.examples;

import net.hamnaberg.json.Codecs;
import net.hamnaberg.json.extract.Extractor;
import net.hamnaberg.json.extract.Extractors;

import java.time.LocalDate;

import static net.hamnaberg.json.extract.TypedField.*;

public class MyExtractors {

    public static Extractor<Person> personExtractor = Extractors.extract3(
            TString("name"),
            TOptional("birthDate", Codecs.StringCodec.map(LocalDate::parse)),
            TJArray("interests").mapToList(j -> j.asString().getOrElse("")),
            Person::new
    );
}
