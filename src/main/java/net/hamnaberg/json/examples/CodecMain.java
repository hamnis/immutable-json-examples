package net.hamnaberg.json.examples;

import io.vavr.collection.List;
import io.vavr.control.Option;
import net.hamnaberg.json.codec.Codecs;
import net.hamnaberg.json.codec.DecodeResult;
import net.hamnaberg.json.codec.JsonCodec;
import net.hamnaberg.json.jackson.JacksonStreamingParser;
import net.hamnaberg.json.Json;

public class CodecMain {

    public static void main(String[] args) {

        Json.JValue data = new JacksonStreamingParser().parseUnsafe(CodecMain.class.getResourceAsStream("/person.json"));
        System.out.println("data = " + data);

        JsonCodec<Person> personcodec = Codecs.codec(
                PersonIso.INSTANCE,
                Codecs.CString.field("name"),
                Codecs.OptionCodec(MyCodecs.localDateJsonCodec).field("birthDate"),
                Codecs.listCodec(Codecs.CString).field("interests"));

        DecodeResult<Person> person3 = personcodec.fromJson(data);
        System.out.println("person3 = " + person3);
        Json.JValue data2 = personcodec.toJson(person3.unsafeGet());
        System.out.println("data2 = " + data2);
        Person p2 = new Person("John Doe", Option.none(), List.empty());
        Json.JValue data3 = personcodec.toJson(p2);
        System.out.println("data3 = " + data3);

        DecodeResult<Person> person4 = personcodec.fromJson(data3);
        System.out.println("person4 = " + person4);
    }
}
