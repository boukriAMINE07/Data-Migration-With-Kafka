package com.boukriinfo.secondecommerce.services;


import com.boukriinfo.secondecommerce.entities.Category;
import com.boukriinfo.secondecommerce.exceptions.CategoryNotFoundException;
import com.boukriinfo.secondecommerce.repositories.CategoryRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final KafkaTemplate<String, Category> kafkaTemplate;


    public CategoryServiceImpl(CategoryRepository categoryRepository, KafkaTemplate<String, Category> kafkaTemplate) {
        this.categoryRepository = categoryRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "topic-add-category")
    public Category saveCategory(Category category) {
        log.info("Category is saved {} ", category);
        Category savedCategory = categoryRepository.save(category);
        return savedCategory;
    }

    @KafkaListener(topics = "topic-up-category")
    public Category updateCategory(Category category) {
        Category categoryUpdate = categoryRepository.findById(category.getId()).orElseThrow(() -> new CategoryNotFoundException("Category by Id :" + category.getId() + " not found"));
        if(categoryUpdate!=null){
            categoryRepository.save(category);
        }

        return category;
    }


}
