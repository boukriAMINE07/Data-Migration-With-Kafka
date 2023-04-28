package com.boukriinfo.secondecommerce.services;


import com.boukriinfo.secondecommerce.entities.Product;

public interface ProductService {
    Product saveProduct(Product product);
    Product updateProduct(Product product);

}
