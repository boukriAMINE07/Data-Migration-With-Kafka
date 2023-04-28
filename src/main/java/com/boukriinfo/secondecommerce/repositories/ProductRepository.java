package com.boukriinfo.secondecommerce.repositories;

import com.boukriinfo.secondecommerce.entities.Category;
import com.boukriinfo.secondecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Long>{

}
