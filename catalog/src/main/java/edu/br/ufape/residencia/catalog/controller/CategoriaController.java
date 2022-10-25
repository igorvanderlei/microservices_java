package edu.br.ufape.residencia.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.residencia.util.dto.CategoyDto;
import edu.br.ufape.residencia.catalog.model.Categoria;
import edu.br.ufape.residencia.catalog.repository.RepositorioCategoria;


@RestController
public class CategoriaController {
	@Autowired
	private RepositorioCategoria repositorio;
	
	@PostMapping(value = "/categoria")
	public Categoria criarCategoria(@RequestBody CategoyDto categoria) {
		
		return null; //repositorio.save(categoria);
	}
	
	@GetMapping(value = "/categoria")
	public List<Categoria> listarCategorias() {
		return repositorio.findAll();
	}
	
	
}
