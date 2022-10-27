package br.edu.ufape.residencia.util.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ProductDto {
	private String name;
	private String detail;
	private Date releaseDate;
	private boolean status;
}
