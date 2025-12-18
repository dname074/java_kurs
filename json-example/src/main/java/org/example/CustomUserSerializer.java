package org.example;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class CustomUserSerializer extends StdSerializer<User> {
    public CustomUserSerializer() {
        this(null);
    }

    public CustomUserSerializer(Class<User> t) {
        super(t);
    }

    @Override
    public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("username", user.getUsername());
        jsonGenerator.writeStringField("password", user.getPassword());
        jsonGenerator.writeStringField("createdAt", user.getCreatedAt().format(formatter));
        jsonGenerator.writeEndObject();
    }
}
