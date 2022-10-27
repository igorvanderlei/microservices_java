package edu.br.ufape.residencia.catalog.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import edu.br.ufape.residencia.catalog.model.Category;
import lombok.Data;

@Data
public class CategoryRequest {
	@NotBlank(message = "A descrição é obrigatória")
	@Length(min = 3, max=35, message = "A descrição deve ter entre 3 e 35 letras")
	private String name;
	private String detail;
	private String icon;
	private long parentCategoryId;

	public Category toCategory() {
		Category category = Category.builder()
				.name(name)
				.detail(detail)
				.icon(icon)
				.build();
		if(parentCategoryId > 0) {
			category.setParentCategory(
					Category.builder()
					.id(parentCategoryId)
					.build()
			);
		}
		return category;
	}

}
