package com.proyecto.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyecto.spring.repository.CargarFichero;

@SpringBootTest
public class Test04_AutowiredRepository {
	//Comprobamos que se carga el Autowired de controller
    //Lo usaremos para llamar al servicio REST
	@Autowired	
	private CargarFichero data;
	
	@Test
	void contextLoads() {
		assertThat(data).isNotNull();
	}
}