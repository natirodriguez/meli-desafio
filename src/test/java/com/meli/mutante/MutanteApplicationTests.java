package com.meli.mutante;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan(basePackages = "com.meli")
class MutanteApplicationTests {

	@Test
	void contextLoads() {
	}
}
