package edu.br.ufape.residencia.catalog.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import edu.br.ufape.residencia.catalog.model.Category;
import edu.br.ufape.residencia.catalog.model.Image;
import edu.br.ufape.residencia.catalog.model.Product;
import lombok.Data;

@Data
public class ProductRequest {
	private String name;
	private String detail;
	private Date releaseDate;
	private boolean status;
	private List<Image> images;
	@NotBlank
	private long categoryId;
	
	public Product toProduct() {
		return Product.builder()
				.name(name)
				.detail(detail)
				.releaseDate(releaseDate)
				.status(status)
				.images(images)
				.category(					
						Category.builder()
						.id(categoryId)
						.build())
				.build();
	}
}
