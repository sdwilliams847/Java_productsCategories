package com.swilliams.products.controllers;

import java.util.List;

import javax.validation.Valid;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.swilliams.products.models.Category;
import com.swilliams.products.models.Product;
import com.swilliams.products.services.CategoryService;
import com.swilliams.products.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	private ProductService pS;
	private CategoryService cS;
	
	public ProductController(ProductService pS, CategoryService cS) {
		this.pS=pS;
		this.cS=cS;
	}
	
	@RequestMapping("/new")
	public String product(@ModelAttribute("product") Product product) {
		return "product.jsp";
	}
	
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("product") Product product, BindingResult res) {
		if(res.hasErrors()) {
			return "product";
		}else {
			pS.create(product);
			return "redirect:/products/new";
		}
	}
	
	@RequestMapping("{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		
		Optional<Product> product = pS.find(id);
		model.addAttribute("product",product.get());		
		model.addAttribute("categories", cS.all());

		return "showproduct.jsp";
	}
	
	@PostMapping("/join/{product_id}")
	public String join(@RequestParam("category_id") Long category_id, @PathVariable("product_id") Long product_id) {

		Optional<Product> product = pS.find(product_id);
		Product prod = product.get();

		List<Category> categories = prod.getCategories();
		Optional<Category> category = cS.find(category_id);
		
		Category cat = category.get();
		categories.add(cat);
		
		prod.setCategories(categories);
		
		pS.update(prod);
		
		
		return "redirect:/products/"+product_id;
		
	}
	

}
