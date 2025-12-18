package org.task2.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.task2.Product;

import java.io.IOException;

public class ProductDeserializer extends StdDeserializer<Product> {
    public ProductDeserializer(Class<?> vc) {
        super(vc);
    }

    public ProductDeserializer() {
        this(null);
    }

    @Override
    public Product deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Product product = new Product();
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode root = codec.readTree(jsonParser);

        product.setName(root.get("product_name").asText());
        double priceInPLN = (root.get("price_in_cents").asDouble() / 100) / 0.28;
        product.setPrice(priceInPLN);

        return product;
    }
}
