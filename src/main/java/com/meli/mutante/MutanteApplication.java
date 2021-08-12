package com.meli.mutante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.meli")
@EnableJpaRepositories("com.meli.repository")
@EntityScan("com.meli.dominio")
public class MutanteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutanteApplication.class, args);
	}
}
