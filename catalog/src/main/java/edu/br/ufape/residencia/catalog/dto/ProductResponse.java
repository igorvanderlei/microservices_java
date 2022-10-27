package edu.br.ufape.residencia.catalog.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import edu.br.ufape.residencia.catalog.model.Image;
import edu.br.ufape.residencia.catalog.model.Product;
import lombok.Data;

@Data
public class ProductResponse {
	private String name;
	private String detail;
	private Date releaseDate;
	private boolean status;
	private List<Image> images;
	@NotBlank
	private long categoryId;
	
	public ProductResponse(Product product) {
		this.name = product.getName();
		this.detail = product.getDetail();
		this.releaseDate = product.getReleaseDate();
		this.status = product.isStatus();
		this.images = product.getImages();
		if(product.getCategory() != null)
			this.categoryId = product.getCategory().getId();
		
	}
}
