package edu.br.ufape.residencia.catalog.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.ufape.residencia.catalog.dto.CategoryRequest;
import edu.br.ufape.residencia.catalog.dto.CategoryResponse;
import edu.br.ufape.residencia.catalog.dto.ProductRequest;
import edu.br.ufape.residencia.catalog.dto.ProductResponse;
import edu.br.ufape.residencia.catalog.exception.NotFoundException;
import edu.br.ufape.residencia.catalog.service.CategoryService;
import edu.br.ufape.residencia.catalog.service.ProductService;

@Service
public class Facade {
	@Autowired
	private CategoryService categoryService; 
	@Autowired
	private ProductService productService;
	public CategoryResponse createCategory(CategoryRequest categoryRequest) {
		return categoryService.createCategory(categoryRequest);
	}
	public List<CategoryResponse> findAllCategories() {
		return categoryService.findAllCategories();
	}
	public List<CategoryResponse> findCategoryByName(String name) {
		return categoryService.findCategoryByName(name);
	}
	public List<CategoryResponse> findSubcategories(long parent) {
		return categoryService.findSubcategories(parent);
	}
	public CategoryResponse loadCategory(long id) throws NotFoundException {
		return categoryService.loadCategory(id);
	}
	public ProductResponse createProduct(ProductRequest ProductRequest) {
		return productService.createProduct(ProductRequest);
	}
	public List<ProductResponse> findAllProducts() {
		return productService.findAllProducts();
	}
	public List<ProductResponse> findProductByCategory(long categoryId) {
		return productService.findProductByCategory(categoryId);
	}
	public ProductResponse loadProduct(long id) {
		return productService.loadProduct(id);
	}

	
}
