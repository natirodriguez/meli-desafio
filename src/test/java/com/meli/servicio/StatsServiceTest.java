package com.meli.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

import com.meli.dominio.Stats;
import com.meli.repository.StatsRepository;

@ComponentScan(basePackages = "com.meli")
@SpringBootTest
@ContextConfiguration(classes = StatsServiceTest.class)
public class StatsServiceTest {
	@Mock
	private StatsRepository statsRepository;
	@Mock
	private MutanteService mutanteService; 
	@InjectMocks
	private StatsService statsService;
	
	String[] ADNMutante = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

    @Test
    public void noExisteADNCreoGenoma()
    {
    	when(statsRepository.existsByDna(ADNMutante)).thenReturn(false);
    	statsService.GuardarGenoma(ADNMutante);
    	verify(statsRepository, times(1)).save(any());
    }
    
    @Test
    public void existeADN()
    {
    	when(statsRepository.existsByDna(ADNMutante)).thenReturn(true);
    	statsService.GuardarGenoma(ADNMutante);
    	verify(statsRepository, times(1)).findByDna(ADNMutante);
    }
	
    @Test
    public void getStats()
    {
		long mutanteMockCantidad = 40;
		long humanoMockCantidad = 100;
		
    	when(statsRepository.countByEsHumano(true)).thenReturn(humanoMockCantidad);
    	when(statsRepository.countByEsHumano(false)).thenReturn(mutanteMockCantidad);

		Stats result = statsService.GetStats();
		
		assertEquals(mutanteMockCantidad, result.getCantidadMutantes());
		assertEquals(humanoMockCantidad, result.getCantidadHumanos());
    }
}