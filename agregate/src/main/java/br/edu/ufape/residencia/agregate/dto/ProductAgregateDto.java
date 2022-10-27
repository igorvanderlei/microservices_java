package br.edu.ufape.residencia.agregate.dto;

import java.util.List;
import java.util.Map;

import br.edu.ufape.residencia.agregate.model.ProductStatistic;
import br.edu.ufape.residencia.util.dto.ProductDto;
import br.edu.ufape.residencia.util.dto.ReviewDto;
import lombok.Data;

@Data
public class ProductAgregateDto {
	private ProductDto product;
	private List<ReviewDto> reviews;
	private ProductStatistic statistic;
	
	
	public ProductAgregateDto(ProductDto product, List<ReviewDto> reviews) {
		this.product = product;
		this.reviews = reviews;
		this.statistic = new ProductStatistic(reviews);
	}

}
