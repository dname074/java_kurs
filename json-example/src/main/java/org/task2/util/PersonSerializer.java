package org.task2.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.task2.Person;

import java.io.IOException;

public class PersonSerializer extends StdSerializer<Person> {
    public PersonSerializer() {
        this(null);
    }

    public PersonSerializer(Class<Person> t) {
        super(t);
    }

    @Override
    public void serialize(Person person, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name", person.getName());
        jsonGenerator.writeFieldName("phone");
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("country_code", "+48");
        jsonGenerator.writeStringField("number", person.getPhoneNumber());
        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndObject();
    }
}
