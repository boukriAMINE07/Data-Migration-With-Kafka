package com.boukriinfo.secondecommerce.deserializer;

import com.boukriinfo.secondecommerce.entities.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class ProductDeserializer implements Deserializer<Product> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {}

    @Override
    public Product deserialize(String topic, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        Product product = null;
        try {
            product = mapper.readValue(data, Product.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void close() {}

}
