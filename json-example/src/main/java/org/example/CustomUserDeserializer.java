package org.example;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomUserDeserializer extends StdDeserializer<User> {
    public CustomUserDeserializer() {
        this(null);
    }

    public CustomUserDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public User deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        User user = new User();
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode root = codec.readTree(jsonParser);

        String username = root.get("username").asText();
        String password = root.get("password").asText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime createdAt = LocalDateTime.parse(root.get("createdAt").asText(), formatter);

        user.setUsername(username);
        user.setPassword(password);
        user.setCreatedAt(createdAt);

        return user;
    }
}
