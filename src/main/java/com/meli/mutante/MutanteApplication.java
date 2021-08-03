package com.meli.mutante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.meli")
public class MutanteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutanteApplication.class, args);
	}
}
