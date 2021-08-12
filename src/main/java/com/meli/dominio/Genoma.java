package com.meli.dominio;

import javax.persistence.*;
@Entity
public class Genoma {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true)
	private String[] dna;
	@Column
	private Boolean esHumano;
	
	public Genoma(String[] dna, Boolean esHumano)
	{
		this.dna = dna;
		this.esHumano = esHumano;
	}
	
	public Genoma() {
	}

	public String[] getDna() {
		return dna;
	}
	public void setDna(String[] dna) {
		this.dna = dna;
	}
	public Boolean getEsHumano() {
		return esHumano;
	}
	public void setEsHumano(Boolean esHumano) {
		this.esHumano = esHumano;
	}
}
