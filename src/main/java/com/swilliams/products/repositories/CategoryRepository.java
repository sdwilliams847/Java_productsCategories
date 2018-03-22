package com.swilliams.products.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swilliams.products.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long>{

}
