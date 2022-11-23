package com.proyecto.spring.controller.error;

public class GameNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GameNotFoundException() {
		super("Fallo: No existe el juego");
		// TODO Auto-generated constructor stub
	}
	
	public GameNotFoundException(Long id) {
		
		super("Fallo: No existe el juego " + id);
		
	}
	
	
}
