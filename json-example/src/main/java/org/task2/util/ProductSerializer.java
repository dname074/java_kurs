package org.task2.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.task2.Product;

import java.io.IOException;

public class ProductSerializer extends StdSerializer<Product> {
    public ProductSerializer() {
        this(null);
    }

    public ProductSerializer(Class<Product> t) {
        super(t);
    }

    @Override
    public void serialize(Product product, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("product_name", product.getName());
        String cents = String.valueOf(convertPLNtoCENTS(product.getPrice()));
        jsonGenerator.writeStringField("price_in_cents", cents);
        jsonGenerator.writeEndObject();
    }

    private double convertPLNtoCENTS(double PLN) {
        return (PLN * 0.28) * 100;
    }
}
