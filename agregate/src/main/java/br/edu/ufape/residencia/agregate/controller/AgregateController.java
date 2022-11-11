package br.edu.ufape.residencia.agregate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.ufape.residencia.agregate.dto.ProductAgregateDto;
import br.edu.ufape.residencia.util.dto.ProductDto;
import br.edu.ufape.residencia.util.dto.ReviewDto;

@RestController
@RequestMapping("/agregate/")
public class AgregateController {
	
	@Autowired
	private RestTemplate restTemplate;
	@Value("${app.product-service.host}")
	private String productHost;
	@Value("${app.review-service.host}")
	private String reviewHost;
		
	
	@GetMapping("{id}")
	public ProductAgregateDto get(@PathVariable long id) {
		String urlProduct = productHost + "/produto/" + id;
		String urlReview = reviewHost + "/review/product/" + id;
		
		ProductDto product = restTemplate.getForObject(urlProduct, ProductDto.class);
		List<ReviewDto> reviews = restTemplate.exchange(
										urlReview, 
										HttpMethod.GET, 
										null, 
										new ParameterizedTypeReference<List<ReviewDto>>() {})
								.getBody();
		return new ProductAgregateDto(product, reviews);
		
	}
	
	@GetMapping("product/{id}")
	public String getReviews(@PathVariable long id) {
		String urlReview = reviewHost + "/review/product/" + id;
		String json = restTemplate.getForObject(urlReview, String.class);
		return json;
	}
	
	
	
	

}
