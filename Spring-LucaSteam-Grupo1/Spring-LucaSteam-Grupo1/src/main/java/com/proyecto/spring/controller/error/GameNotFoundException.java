package com.proyecto.spring.controller.error;

public class GameNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GameNotFoundException() {
		super("Epic Fail: No existe el estudiante");
		// TODO Auto-generated constructor stub
	}
	
	public GameNotFoundException(Long id) {
		
		super("Epic Fail: No existe el estudiante " + id);
		
	}
	
	
}
