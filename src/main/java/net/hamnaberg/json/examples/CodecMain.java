package net.hamnaberg.json.examples;

import javaslang.collection.List;
import javaslang.control.Option;
import net.hamnaberg.json.Codecs;
import net.hamnaberg.json.DecodeResult;
import net.hamnaberg.json.Json;
import net.hamnaberg.json.JsonCodec;
import net.hamnaberg.json.io.JacksonStreamingParser;

public class CodecMain {

    public static void main(String[] args) {

        Json.JValue data = new JacksonStreamingParser().parse(CodecMain.class.getResourceAsStream("/person.json"));
        System.out.println("data = " + data);

        JsonCodec<Person> personcodec = Codecs.codec3(
                PersonIso.INSTANCE,
                Codecs.StringCodec,
                Codecs.OptionCodec(MyCodecs.localDateJsonCodec),
                Codecs.listCodec(Codecs.StringCodec)).
                apply("name", "birthDate", "interests");

        DecodeResult<Person> person3 = personcodec.fromJson(data);
        System.out.println("person3 = " + person3);
        Option<Json.JValue> data2 = personcodec.toJson(person3.unsafeGet());
        System.out.println("data2 = " + data2);
        Person p2 = new Person("John Doe", Option.none(), List.empty());
        Json.JValue data3 = personcodec.toJson(p2).get();
        System.out.println("data3 = " + data3);

        DecodeResult<Person> person4 = personcodec.fromJson(data3);
        System.out.println("person4 = " + person4);
    }
}
