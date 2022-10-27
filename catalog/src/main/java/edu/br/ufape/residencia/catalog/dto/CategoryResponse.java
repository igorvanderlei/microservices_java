package edu.br.ufape.residencia.catalog.dto;

import java.util.List;

import edu.br.ufape.residencia.catalog.model.Category;
import lombok.Data;

@Data
public class CategoryResponse {
	private long id;
	private String name;
	private String detail;
	private String icon;
	private long parentCategoryId;
	private List<CategoryResponse> nestedCategories;
	
	public CategoryResponse(Category c) {
		this.id = c.getId();
		this.name = c.getName();
		this.detail = c.getDetail();
		this.icon = c.getIcon();
		if(c.getParentCategory() != null)
			this.parentCategoryId = c.getParentCategory().getId();
	}
	
}
