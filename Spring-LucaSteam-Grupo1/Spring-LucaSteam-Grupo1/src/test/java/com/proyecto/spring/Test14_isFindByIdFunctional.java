package com.proyecto.spring;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.proyecto.spring.controller.GameController;
import com.proyecto.spring.model.Game;

@WebMvcTest(GameController.class)
public class Test14_isFindByIdFunctional {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private GameController gc;

	@Test
	void contextLoads() throws Exception {
		
		Game gamePrueba = new Game();
		gamePrueba.setNombre("gamePrueba");
		gamePrueba.setPlataforma("PS4");
		gamePrueba.setYear(1998);
		gamePrueba.setGenero("Accion");
		gamePrueba.setEditor("Test");
		
		when(gc.findById(1)).thenReturn(Optional.of(gamePrueba));
		
		mockMvc
			.perform(get("http://localhost:8082/games/1"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("gamePrueba")));
	}
}