package com.meli.mutante;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan({"com.meli","com.meli.dominio","com.meli.controller"})
class MutanteApplicationTests {

	@Test
	void contextLoads() {
	}
}
