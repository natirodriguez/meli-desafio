package com.meli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.any;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.dominio.SecuenciaADN;
import com.meli.servicio.MutanteService;
import com.meli.servicio.StatsService;

@ComponentScan(basePackages = "com.meli.controller")
@SpringBootTest
@AutoConfigureMockMvc
@EnableWebMvc
@ContextConfiguration(classes = MutanteControllerTest.class)
public class MutanteControllerTest {
	@MockBean
	private MutanteService mutanteService;
	@MockBean
	private StatsService statsService; 
	@InjectMocks
	private MutanteController controller;
	@Autowired 
	private MockMvc mockMvc;

	@Test
	public void mutanteResponseOK() throws Exception {
		SecuenciaADN secuenciaADN = new SecuenciaADN();
		String[] adnMutante = {"ATGCGA","CAGTGC","TTATGT","GGAAGG","CCCCTA","TCACTG"};   
		secuenciaADN.setAdn(Arrays.asList(adnMutante));
		when(mutanteService.EsMutante(adnMutante)).thenReturn(true);
		when(statsService.GuardarGenoma(adnMutante)).thenReturn(any());

		mockMvc.perform(
				MockMvcRequestBuilders.post("/mutante")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(asJsonString(secuenciaADN)))
				.andExpect(status().isOk());

		verify(mutanteService, times(1)).EsMutante(adnMutante);
		verify(statsService, times(1)).GuardarGenoma(adnMutante);
		verifyNoMoreInteractions(mutanteService, statsService);
	}
	
	private static String asJsonString(final Object obj) {
		try {
			return (new ObjectMapper()).writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
