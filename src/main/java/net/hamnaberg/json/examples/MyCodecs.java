package net.hamnaberg.json.examples;

import net.hamnaberg.json.Codecs;
import net.hamnaberg.json.JsonCodec;

import java.time.LocalDate;

public class MyCodecs {
    public static JsonCodec<LocalDate> localDateJsonCodec =
            Codecs.StringCodec.tryNarrow(LocalDate::parse, LocalDate::toString);
}
