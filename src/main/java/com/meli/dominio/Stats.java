package com.meli.dominio;

public class Stats {
	private long cantidadHumanos;
	private long cantidadMutantes;

	public Stats(long cantidadHumanos, long cantidadMutantes) {
		this.cantidadHumanos = cantidadHumanos; 
		this.cantidadMutantes = cantidadMutantes; 
	}

	public float getRatio() {
		if(cantidadHumanos != 0 && cantidadMutantes != 0) {
			return cantidadMutantes / cantidadHumanos;
		}
		
		return 1;
	}
	
	public long getCantidadHumanos() {
		return cantidadHumanos;
	}

	public void setCantidadHumanos(long cantidadHumanos) {
		this.cantidadHumanos = cantidadHumanos;
	}

	public long getCantidadMutantes() {
		return cantidadMutantes;
	}

	public void setCantidadMutantes(long cantidadMutantes) {
		this.cantidadMutantes = cantidadMutantes;
	}
}
