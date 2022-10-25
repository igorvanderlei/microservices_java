package edu.br.ufape.residencia.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.br.ufape.residencia.catalog.model.Produto;

@Repository
public interface RepositorioProduto extends JpaRepository<Produto, Long>{

}
