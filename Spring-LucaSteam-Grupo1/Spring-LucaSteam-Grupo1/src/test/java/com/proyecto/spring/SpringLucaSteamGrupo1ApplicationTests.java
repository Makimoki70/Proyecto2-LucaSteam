package com.proyecto.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyecto.spring.controller.GameController;
import com.proyecto.spring.model.Game;

@SpringBootTest
class SpringLucaSteamGrupo1ApplicationTests {

	@Autowired
	private GameController gameCont;
	
	@Test
	void contextLoads() {
		
		
		assertThat(gameCont).isNotNull();
		
	}

}
