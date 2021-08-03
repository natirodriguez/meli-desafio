package com.meli.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meli.dominio.SecuenciaADN;
import com.meli.excepciones.DNAExcepcion;
import com.meli.servicio.MutanteService;

@RestController
@RequestMapping("/mutante")
public class MutanteController {
	@Autowired
	private MutanteService mutanteService; 
	
	public MutanteService getMutanteService() {
		return mutanteService;
	}
	public void setMutanteService(MutanteService mutanteService) {
		this.mutanteService = mutanteService;
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<?> EsMutante(@Valid @RequestBody SecuenciaADN secuenciaADN) {
		Map<String, String> response = new HashMap<String, String>();
		HttpStatus status;
		String mensaje;

		if(mutanteService.EsMutante(secuenciaADN.ConvertirAArray())) {
			status = HttpStatus.OK;
			mensaje = "Existen mutantes en la cadena de ADN";
		} else {
			status = HttpStatus.FORBIDDEN;
			mensaje = "Solo humanos";
		}
		response.put("message", mensaje);
		response.put("status", status.toString());
		
		return  new ResponseEntity<Map<String, String>>(response, status);
	}
	
	@ExceptionHandler(DNAExcepcion.class)
	public ResponseEntity<?> handleDNAExcepcion(DNAExcepcion e) {
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", e.getMessage());
		response.put("status", HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);
	}
}
