package com.meli.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meli.dominio.Stats;
import com.meli.servicio.MutanteService;
import com.meli.servicio.StatsService;

@RestController
@RequestMapping("/stats")
public class StatsController {
	@Autowired
	private StatsService statsService; 

	@GetMapping
	public ResponseEntity<?> Stats() {
		Map<String, String> response = new HashMap<String, String>();
		String mensaje;
		
		Stats stats = statsService.GetStats();

		mensaje = "count_mutant_dna: " +  stats.getCantidadMutantes() 
			+ "; count_human_dna: " + stats.getCantidadHumanos() 
			+ "; ratio: " + stats.getRatio();

		response.put("message", mensaje);
		
		return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
	}
}
