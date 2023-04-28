package com.boukriinfo.secondecommerce.services;


import com.boukriinfo.secondecommerce.entities.Category;

public interface CategoryService {
    Category saveCategory(Category category);
    Category updateCategory(Category category);

}
