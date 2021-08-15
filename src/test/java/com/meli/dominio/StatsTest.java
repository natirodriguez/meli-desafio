package com.meli.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

@ComponentScan(basePackages = "com.meli.dominio")
@SpringBootTest
@ContextConfiguration(classes = StatsTest.class)
public class StatsTest {
	@Test
	public void getRatio() {
		long cantidadMutantes = 40;
		long cantidadHumanos = 100;
		float radioExpected = cantidadMutantes / cantidadHumanos;

		Stats stats = new Stats(cantidadHumanos, cantidadMutantes);

		assertEquals(radioExpected, stats.getRatio(), 0);
	}
	
	@Test
	public void getRatioSinMutantesNiHumanos() {
		long cantidadMutantes = 0;
		long cantidadHumanos = 0;
		float radioExpected = 1; 

		Stats stats = new Stats(cantidadHumanos, cantidadMutantes);

		assertEquals(radioExpected, stats.getRatio(), 0);
	}
}
