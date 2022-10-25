package br.edu.ufape.residencia.reviews.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.residencia.reviews.model.Review;
import br.edu.ufape.residencia.reviews.repository.ReviewRepository;

@RestController
@RequestMapping("/review/")
public class ReviewController {
	
	@Autowired
	private ReviewRepository repository;
	
	@PostMapping("/")
	public Review createReview(@RequestBody Review r) {
		return repository.save(r);
	}
	
	@GetMapping("product/{id}")
	public List<Review> getProductReviews(@PathVariable long id) {
		return repository.findByProductId(id);
	}

}
