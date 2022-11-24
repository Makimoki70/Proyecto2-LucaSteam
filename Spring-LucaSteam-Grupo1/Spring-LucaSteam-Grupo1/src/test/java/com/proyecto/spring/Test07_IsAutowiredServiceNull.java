package com.proyecto.spring;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyecto.spring.service.GameServiceImpl;

@SpringBootTest
public class Test07_IsAutowiredServiceNull {
    //Comprobamos que se carga el Autowired de controller
    //Lo usaremos para llamar al servicio REST
	@Autowired	
	private GameServiceImpl serv;
	
	@Test
	void contextLoads() {
		Boolean resultado = serv.equals(null);
		assertFalse(resultado);
	}
}