package com.proyecto.spring;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyecto.spring.controller.GameController;

@SpringBootTest
public class Test06_IsAutowiredControllerNull {
    //Comprobamos que se carga el Autowired de controller
    //Lo usaremos para llamar al servicio REST
	@Autowired	
	private GameController controller;
	
	@Test
	void contextLoads() {
		Boolean resultado = controller.equals(null);
		assertFalse(resultado);
	}
}