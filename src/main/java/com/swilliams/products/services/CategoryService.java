package com.swilliams.products.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swilliams.products.models.Category;
import com.swilliams.products.repositories.CategoryRepository;


@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cR;
	
	public CategoryService(CategoryRepository cR) {
		this.cR = cR;
	}
	
	public void create(Category cat) {
		cR.save(cat);
	}
	
	public ArrayList<Category> all(){
		return (ArrayList<Category>) cR.findAll();
	}
	
	public Optional<Category> find(Long id){
		return cR.findById(id);
	}
	
	public void destroy(Long id) {
		cR.deleteById(id);
	}
	
	public void update(Category cat) {
		cR.save(cat);
	}
	
}
