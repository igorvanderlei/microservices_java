package br.edu.ufape.residencia.util.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ProductDto {
	private String descricao;
	private String detalhes;
	private Date lancamento;
	private boolean status;
}
