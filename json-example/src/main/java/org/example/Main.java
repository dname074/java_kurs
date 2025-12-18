package org.example;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Main {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        SimpleModule module = new SimpleModule("CustomUserDeserializer", new Version(1, 0, 0, null, null, null));
        module.addDeserializer(User.class, new CustomUserDeserializer());
        module.addSerializer(User.class, new CustomUserSerializer());
        objectMapper.registerModule(module);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setDateFormat(formatter);
        Institution institution = objectMapper.readValue(new File("D:\\Java\\javaKurs\\java_kurs\\json-example\\src\\main\\resources\\Institution.json"), Institution.class);

        String newJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(institution);
        System.out.println(newJson);
    }
}