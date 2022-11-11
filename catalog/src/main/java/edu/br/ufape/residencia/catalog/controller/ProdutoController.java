package edu.br.ufape.residencia.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.br.ufape.residencia.catalog.dto.ProductRequest;
import edu.br.ufape.residencia.catalog.dto.ProductResponse;
import edu.br.ufape.residencia.catalog.facade.Facade;

@RestController
public class ProdutoController {
	
	@Autowired
	private Facade facade;

	@GetMapping(value = "/catalog/produto")
	public List<ProductResponse> listAll() {
		return facade.findAllProducts();
	}
	
	@GetMapping(value = "/catalog/produto/{id}")
	public ProductResponse getProduct(@PathVariable long id) {
		return facade
				.loadProduct(id);
	}
	
	@PostMapping(value = "/catalog/produto")
	public ProductResponse create(@RequestBody ProductRequest produto) {
		return facade.createProduct(produto);
	}

}
