package edu.br.ufape.residencia.catalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.br.ufape.residencia.catalog.model.Categoria;


@Repository
public interface RepositorioCategoria extends JpaRepository<Categoria, Long>{
	
	public List<Categoria> findByDescricaoContaining(String descricao);
}
