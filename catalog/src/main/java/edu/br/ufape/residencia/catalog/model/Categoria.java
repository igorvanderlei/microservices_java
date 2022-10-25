package edu.br.ufape.residencia.catalog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String descricao;
	private String detalhes;
	private String icone;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoriaPai;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

	public Categoria getCategoriaPai() {
		return categoriaPai;		

	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public Categoria(String descricao, String detalhes, String icone, Categoria categoriaPai) {
		this.descricao = descricao;
		this.detalhes = detalhes;
		this.icone = icone;
		this.categoriaPai = categoriaPai;
	}

	public Categoria() {
	}
	
	
	
	

}
