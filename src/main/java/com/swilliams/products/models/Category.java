package com.swilliams.products.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.swilliams.products.models.Product;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="categories_products",
		joinColumns=@JoinColumn(name="category_id"),
		inverseJoinColumns=@JoinColumn(name="product_id")
	)
	private List<Product> products;
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<Product> getProducts(){
		return products;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
