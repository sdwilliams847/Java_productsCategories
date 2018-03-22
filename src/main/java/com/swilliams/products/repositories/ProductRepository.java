package com.swilliams.products.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swilliams.products.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long>{

}
