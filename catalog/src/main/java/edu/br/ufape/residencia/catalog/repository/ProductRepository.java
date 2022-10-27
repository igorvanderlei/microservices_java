package edu.br.ufape.residencia.catalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.br.ufape.residencia.catalog.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	public List<Product> findByCategory_Id(long id);
	

}
