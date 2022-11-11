package br.edu.ufape.residencia.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.residencia.inventory.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>{
	
}
