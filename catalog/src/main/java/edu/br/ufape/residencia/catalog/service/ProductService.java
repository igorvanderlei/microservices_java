package edu.br.ufape.residencia.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.ufape.residencia.catalog.dto.ProductRequest;
import edu.br.ufape.residencia.catalog.dto.ProductResponse;
import edu.br.ufape.residencia.catalog.model.Product;
import edu.br.ufape.residencia.catalog.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	
	public ProductResponse createProduct(ProductRequest ProductRequest) {
		return new ProductResponse(repository.save(ProductRequest.toProduct()));
	}
	
	public List<ProductResponse> findAllProducts() {
		List<Product> list = repository.findAll();
		return list.stream().map(ProductResponse::new).toList();
	}
	
	public List<ProductResponse> findProductByCategory(long categoryId) {
		List<Product> list = repository.findByCategory_Id(categoryId);
		return list.stream().map(ProductResponse::new).toList();
	}
	
	public ProductResponse loadProduct(long id) {
		return new ProductResponse( 
				repository.findById(id).orElseThrow( 
						() -> new RuntimeException("It doesn't exist Product with id = " + id)));
	}
	
}
