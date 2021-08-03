package com.meli.dominio;

import java.util.List;

import javax.validation.constraints.NotNull;

public class SecuenciaADN {
	@NotNull
	private List<String> adn;

	public List<String> getAdn() {
		return adn;
	}

	public void setAdn(List<String> adn) {
		this.adn = adn;
	}
	
	public String[] ConvertirAArray()
	{
		return adn.stream().toArray(String[] ::new);
	}
}
