package com.proyecto.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.proyecto.spring.controller.GameController;

@SpringBootApplication
public class SpringLucaSteamGrupo1Application implements CommandLineRunner {

	@Autowired
	GameController gamecon;
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringLucaSteamGrupo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		gamecon.cargarDatos();
		
	}
}
