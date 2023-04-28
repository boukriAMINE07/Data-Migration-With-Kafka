package com.boukriinfo.secondecommerce.deserializer;

import com.boukriinfo.secondecommerce.entities.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class CategoryDeserializer implements Deserializer<Category> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {}

    @Override
    public Category deserialize(String topic, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        Category category = null;
        try {
            category = mapper.readValue(data, Category.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public void close() {}

}
