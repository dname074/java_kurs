package org.task2.util;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.task2.Employee;

import java.io.IOException;

public class EmployeeDeserializer extends StdDeserializer<Employee> {
    public EmployeeDeserializer(Class<?> vc) {
        super(vc);
    }

    public EmployeeDeserializer() {
        this(null);
    }

    @Override
    public Employee deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Employee employee = new Employee();
        ObjectCodec codec = jsonParser.getCodec();
        System.out.println(codec);
        JsonNode root = codec.readTree(jsonParser);

        employee.setName(root.get("name").asText());
        String[] values = root.get("employee_id").asText().split("-");
        employee.setId(Integer.parseInt(values[1]));

        return employee;
    }
}
