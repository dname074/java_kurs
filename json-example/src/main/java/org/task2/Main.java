package org.task2;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.task2.util.EmployeeDeserializer;
import org.task2.util.EmployeeSerializer;
import org.task2.util.PersonDeserializer;
import org.task2.util.PersonSerializer;
import org.task2.util.ProductDeserializer;
import org.task2.util.ProductSerializer;

import java.io.File;
import java.io.IOException;

public class Main {
    private final static File PERSON_FILE = new File("D:\\Java\\javaKurs\\java_kurs\\json-example\\src\\main\\resources\\Person.json");
    private final static File PRODUCT_FILE = new File("D:\\Java\\javaKurs\\java_kurs\\json-example\\src\\main\\resources\\Product.json");
    private final static File EMPLOYEE_FILE = new File("D:\\Java\\javaKurs\\java_kurs\\json-example\\src\\main\\resources\\Employee.json");
    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        configureMapperForPerson();
        configureMapperForProduct();
        configureMapperForEmployee();
        Person person = mapper.readValue(PERSON_FILE, Person.class);
        Product product = mapper.readValue(PRODUCT_FILE, Product.class);
        Employee employee = mapper.readValue(EMPLOYEE_FILE, Employee.class);

        mapper.writerWithDefaultPrettyPrinter().writeValue(PERSON_FILE, person);
        mapper.writerWithDefaultPrettyPrinter().writeValue(PRODUCT_FILE, product);
        mapper.writerWithDefaultPrettyPrinter().writeValue(EMPLOYEE_FILE, employee);
    }

    private static void configureMapperForProduct() {
        SimpleModule productModule = new SimpleModule("ProductModule", new Version(1,0,0,null,null,null));
        productModule.addSerializer(Product.class ,new ProductSerializer());
        productModule.addDeserializer(Product.class, new ProductDeserializer());
        mapper.registerModule(productModule);
    }

    private static void configureMapperForEmployee() {
        SimpleModule employeeModule = new SimpleModule("EmployeeModule", new Version(1,0,0,null,null,null));
        employeeModule.addSerializer(Employee.class, new EmployeeSerializer());
        employeeModule.addDeserializer(Employee.class, new EmployeeDeserializer());
        mapper.registerModule(employeeModule);
    }

    private static void configureMapperForPerson() {
        SimpleModule personModule = new SimpleModule("PersonModule", new Version(1, 0, 0, null, null, null));
        personModule.addSerializer(Person.class, new PersonSerializer());
        personModule.addDeserializer(Person.class, new PersonDeserializer());
        mapper.registerModule(personModule);
    }
}
