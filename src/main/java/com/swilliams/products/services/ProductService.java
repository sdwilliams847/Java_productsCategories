package com.swilliams.products.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swilliams.products.models.Product;
import com.swilliams.products.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository pR;
	
	public ProductService(ProductRepository pR) {
		this.pR = pR;
	}
	
	public void create(Product product) {
		pR.save(product);
	}
	
	public ArrayList<Product> all(){
		return (ArrayList<Product>) pR.findAll();
	}
	
	public Optional<Product> find(Long id){
		return pR.findById(id);
	}
	
	public void destroy(Long id) {
		pR.deleteById(id);
	}
	
	public void update(Product prod) {
		pR.save(prod);
	}
}
