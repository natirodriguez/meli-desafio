package com.meli.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.meli.dominio.Genoma;

@Repository
@Component
public interface StatsRepository extends CrudRepository<Genoma, Long> {
	boolean existsByDna(String[] dna); 
	Long countByEsHumano(boolean esHumano);
	Optional<Genoma> findByDna(String[] dna);
}