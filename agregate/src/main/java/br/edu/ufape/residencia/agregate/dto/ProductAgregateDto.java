package br.edu.ufape.residencia.agregate.dto;

import java.util.List;

import br.edu.ufape.residencia.util.dto.ProductDto;
import br.edu.ufape.residencia.util.dto.ReviewDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductAgregateDto {
	private ProductDto product;
	private List<ReviewDto> reviews;

}
