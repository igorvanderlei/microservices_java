package br.edu.ufape.residencia.reviews.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.residencia.reviews.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
	public List<Review> findByProductId(long productId);
}