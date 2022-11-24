package com.proyecto.spring;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.proyecto.spring.model.Game;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class Test13_isDataBaseComplete {

	/*@LocalServerPort
    private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void contextLoads() {
		ResponseEntity<Game[]> response = restTemplate.getForEntity("http://localhost:" + port + "/games", Game[].class);
	    Game[] games = response.getBody();
		assertTrue(games.length >= 16599);
	}*/
}
