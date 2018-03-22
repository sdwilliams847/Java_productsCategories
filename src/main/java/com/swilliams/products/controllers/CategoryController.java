package com.swilliams.products.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.swilliams.products.models.Category;
import com.swilliams.products.models.Product;
import com.swilliams.products.services.CategoryService;
import com.swilliams.products.services.ProductService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private CategoryService cS;
	private ProductService pS;
	
	public CategoryController(CategoryService cS, ProductService pS) {
		this.cS = cS;
		this.pS = pS;
	}
	
	@RequestMapping("/new")
	public String createNew(Model model) {
		model.addAttribute("category",new Category());
		return "categories.jsp";
	}

	@PostMapping("/new")
	public String create( @Valid @ModelAttribute("category") Category cat, BindingResult res, RedirectAttributes re) {
		if(res.hasErrors()) {
			re.addFlashAttribute("errs",res.getAllErrors());
		}else {
			cS.create(cat);
		}
		return "redirect:/categories/new";
	}
	
	@RequestMapping("{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		
		Optional<Category> cat = cS.find(id);
		model.addAttribute("category",cat.get());
		model.addAttribute("products",pS.all());
		
		return "showcategory.jsp";
	}
	
	@PostMapping("/join/{category_id}")
	public String joinCategory(@PathVariable("category_id") Long category_id, @RequestParam("product_id") Long product_id) {
		
		Optional<Category> category = cS.find(category_id);
		Category cat = category.get();
		
		List<Product> prods = cat.getProducts();
		Optional<Product> product = pS.find(product_id);
		
		Product prod = product.get();
		prods.add(prod);
		
		cat.setProducts(prods);
		
		cS.update(cat);

		return "redirect:/categories/"+category_id;
	}
	
}
