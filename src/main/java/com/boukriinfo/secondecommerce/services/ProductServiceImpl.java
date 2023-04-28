package com.boukriinfo.secondecommerce.services;

import com.boukriinfo.secondecommerce.entities.Category;
import com.boukriinfo.secondecommerce.entities.Product;
import com.boukriinfo.secondecommerce.exceptions.ProductNotFoundException;
import com.boukriinfo.secondecommerce.repositories.CategoryRepository;
import com.boukriinfo.secondecommerce.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final KafkaTemplate<String, Product> kafkaTemplate;


    public ProductServiceImpl(ProductRepository productRepository, KafkaTemplate<String, Product> kafkaTemplate) {
        this.productRepository = productRepository;
        this.kafkaTemplate = kafkaTemplate;
    }
    @KafkaListener(topics = "topic-add-product", containerFactory = "kafkaListenerContainerProductFactory")
    public Product saveProduct(Product product) {
        log.info("Product is saved {} ", product);
        Product savedProduct = productRepository.save(product);
        return null;
    }

    @KafkaListener(topics = "topic-up-product", containerFactory = "kafkaListenerContainerProductFactory")
    public Product updateProduct(Product product) {
        Product productUpdate = productRepository.findById(product.getId()).orElseThrow(() -> new ProductNotFoundException("Product by Id :"+product.getId()+" not found"));
        if(productUpdate!=null){
            productRepository.save(product);
        }
        return product;
    }
}
