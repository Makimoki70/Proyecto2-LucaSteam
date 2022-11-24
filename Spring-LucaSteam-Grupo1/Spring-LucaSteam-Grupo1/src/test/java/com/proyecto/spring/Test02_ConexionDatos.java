package com.proyecto.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.proyecto.spring.model.Game;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Test02_ConexionDatos {
	//esto inyecta el puerto aleatorio definido anteriormente
    @LocalServerPort
    private int port;
	
    //Lo usaremos para llamar al servicio REST
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void contextLoads() {
		assertThat(restTemplate.getForObject("http://localhost:" + port + "/games/{id}", Game.class, 1).getNombre()).contains("Wii Sports");
	}
}