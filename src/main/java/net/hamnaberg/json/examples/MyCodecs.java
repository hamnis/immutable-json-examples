package net.hamnaberg.json.examples;

import net.hamnaberg.json.codec.Codecs;
import net.hamnaberg.json.codec.JsonCodec;

import java.time.LocalDate;

public class MyCodecs {
    public static JsonCodec<LocalDate> localDateJsonCodec =
            Codecs.CString.tryNarrow(LocalDate::parse, LocalDate::toString);
}
