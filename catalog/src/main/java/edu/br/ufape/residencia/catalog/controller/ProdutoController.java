package edu.br.ufape.residencia.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.br.ufape.residencia.catalog.model.Produto;
import edu.br.ufape.residencia.catalog.repository.RepositorioProduto;

@RestController
public class ProdutoController {
	
	@Autowired
	private RepositorioProduto repositorio;

	@GetMapping(value = "/produto")
	public List<Produto> getProduto() {
		return repositorio.findAll();
	}
	
	@GetMapping(value = "/produto/{id}")
	public Produto getProduto(@PathVariable long id) {
		return repositorio
				.findById(id)
				.orElseThrow(() -> new RuntimeException());
	}
	
	@PostMapping(value = "/produto")
	public Produto create(@RequestBody Produto produto) {
		return repositorio.save(produto);
	}

}
