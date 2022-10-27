package edu.br.ufape.residencia.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.ufape.residencia.catalog.dto.CategoryRequest;
import edu.br.ufape.residencia.catalog.dto.CategoryResponse;
import edu.br.ufape.residencia.catalog.exception.NotFoundException;
import edu.br.ufape.residencia.catalog.model.Category;
import edu.br.ufape.residencia.catalog.repository.CategoryRepository;



@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repository;
	
	public CategoryResponse createCategory(CategoryRequest categoryRequest) {
		
		return new CategoryResponse(repository.save(categoryRequest.toCategory()));
	}
	
	public List<CategoryResponse> findAllCategories() {
		List<Category> list = repository.findAll();
		return list.stream().map(CategoryResponse::new).toList();
	}
	
	public List<CategoryResponse> findCategoryByName(String name) {
		List<Category> list = repository.findByNameContaining(name);
		return list.stream().map(CategoryResponse::new).toList();
	}
	
	public List<CategoryResponse> findSubcategories(long parent) {
		List<Category> list = repository.findByParentCategory_Id(parent);
		return list.stream().map(CategoryResponse::new).toList();
	}
	
	public CategoryResponse loadCategory(long id) throws NotFoundException {
		Category category = repository.findById(id).orElseThrow( () -> new NotFoundException("It doesn't exist Category with id = " + id));
		CategoryResponse categoryResponse = new CategoryResponse(category);
		categoryResponse.setNestedCategories(this.findSubcategories(id));
		return categoryResponse;
	}

}
