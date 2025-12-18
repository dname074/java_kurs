package org.task2.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.task2.Employee;

import java.io.IOException;

public class EmployeeSerializer extends StdSerializer<Employee> {
    public EmployeeSerializer(Class<Employee> t) {
        super(t);
    }

    public EmployeeSerializer() {
        this(null);
    }

    @Override
    public void serialize(Employee employee, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name", employee.getName());
        jsonGenerator.writeStringField("employee_id", "EMP-" + employee.getId());
        jsonGenerator.writeEndObject();
    }
}
