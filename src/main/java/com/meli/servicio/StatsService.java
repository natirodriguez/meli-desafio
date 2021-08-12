package com.meli.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meli.dominio.Genoma;
import com.meli.dominio.Stats;
import com.meli.repository.StatsRepository;

@Service
public class StatsService {
	@Autowired
	private StatsRepository statsRepository;
	@Autowired
	private MutanteService mutanteService;
	
	public Genoma GuardarGenoma(String[] adn) {
		Genoma genoma; 
		if(!statsRepository.existsByDna(adn)) {
			genoma = new Genoma(adn, !mutanteService.EsMutante(adn));
			return statsRepository.save(genoma);
		} else {
			return statsRepository.findByDna(adn).orElse(new Genoma());
		}
	}

	public Stats GetStats()
	{
		long cantidadHumanos = statsRepository.countByEsHumano(true); 
		long cantidadMutantes = statsRepository.countByEsHumano(false); 
		
		return new Stats(cantidadHumanos, cantidadMutantes);
	}
	
	// Getters y setters
	public StatsRepository getStatsRepository() {
		return statsRepository;
	}
	public void setStatsRepository(StatsRepository statsRepository) {
		this.statsRepository = statsRepository;
	}
	public MutanteService getMutanteService() {
		return mutanteService;
	}
	public void setMutanteService(MutanteService mutanteService) {
		this.mutanteService = mutanteService;
	}
}
