package com.proyecto.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyecto.spring.service.GameServiceImpl;

@SpringBootTest
public class Test03_IsAutowiredServiceNotNull {
    //Comprobamos que se carga el Autowired de controller
    //Lo usaremos para llamar al servicio REST
	@Autowired	
	private GameServiceImpl serv;
	
	@Test
	void contextLoads() {
		assertThat(serv).isNotNull();
	}
}
