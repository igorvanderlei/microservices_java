package edu.br.ufape.residencia.catalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.br.ufape.residencia.catalog.model.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	public List<Category> findByNameContaining(String descricao);
	public List<Category> findByParentCategory_Id(long id);
}
