package edu.br.ufape.residencia.catalog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.br.ufape.residencia.catalog.dto.CategoryRequest;
import edu.br.ufape.residencia.catalog.dto.CategoryResponse;
import edu.br.ufape.residencia.catalog.exception.NotFoundException;
import edu.br.ufape.residencia.catalog.facade.Facade;
import org.springframework.security.oauth2.jwt.Jwt;

@RestController
public class CategoriaController {
	@Autowired
	private Facade facade;
	
	@PostMapping(value = "/catalog/categoria")
	public CategoryResponse create(@RequestBody @Valid CategoryRequest category) {
		
		return facade.createCategory(category);
	}
	
	@GetMapping(value = "/catalog/categoria/{id}")
	public CategoryResponse find(@PathVariable long id) throws NotFoundException {
		return facade.loadCategory(id);
	}
	
	@GetMapping(value = "/catalog/categoria")
	@PreAuthorize("hasAnyAuthority('CADASTRAR_PRODUTO')")
	public List<CategoryResponse> listAll() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Jwt principal = (Jwt) authentication.getPrincipal();
		System.out.println(principal.getClaimAsString("email"));
		System.out.println(principal.getId());
		System.out.println(authentication.getAuthorities());
		System.out.println(authentication.getCredentials());
		System.out.println(authentication.getName());
		
		return facade.findAllCategories();
	}
	
	
}
