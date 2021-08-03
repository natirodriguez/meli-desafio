package com.meli.servicio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import com.meli.excepciones.DNAExcepcion;

@ComponentScan(basePackages = "com.meli")
@SpringBootTest
@ContextConfiguration(classes = MutanteServiceTest.class)
public class MutanteServiceTest {
	String[] ADNMutante = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	String[] sinADNMutante = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
	String[] cadenaInvalida = {"TC", "CT"};
	String[] caracterInvalido = {"PTGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};

	@Autowired
	private MutanteService mutanteService;
	
    @Test
    public void matrizSinADNMutantePorFila()
    {
    	assertFalse(mutanteService.LectorDeFilas(sinADNMutante));
    }

    @Test
    public void matrizConADNMutantePorFila()
    {
		assertTrue(mutanteService.LectorDeFilas(ADNMutante));
    }
    
    @Test
    public void matrizSinADNMutantePorColumna()
    {
		assertFalse(mutanteService.LectorDeColumnas(sinADNMutante));
    }
    
    @Test
    public void matrizConADNMutantePorColumna()
    {
		assertTrue(mutanteService.LectorDeColumnas(ADNMutante));
    }
    
    @Test
    public void matrizConADNMutantePorDiagonal()
    {
		assertTrue(mutanteService.LectorDeDiagonales(ADNMutante));
    }
    
    @Test
    public void matrizSinADNMutantePorDiagonal()
    {
    	assertFalse(mutanteService.LectorDeDiagonales(sinADNMutante));
    }
  
    @Test
    public void TablaTamanioInvalidoException()
    {
    	DNAExcepcion excepcion = assertThrows(DNAExcepcion.class, () -> mutanteService.EsMutante(cadenaInvalida));
        assertEquals("La tabla debe de ser mínimo de 4 X 4", excepcion.getMessage());
    }
    
    @Test
    public void CaracterInvalido()
    {
    	DNAExcepcion excepcion = assertThrows(DNAExcepcion.class, () -> mutanteService.EsMutante(caracterInvalido));
    	assertEquals("El caracter P es invalido", excepcion.getMessage());
    }
}
