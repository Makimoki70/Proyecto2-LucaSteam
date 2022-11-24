package com.proyecto.spring.controller.error;

import com.proyecto.spring.model.Genero;

public class GameNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GameNotFoundException() {
		super("Fallo: No existe el juego");
		// TODO Auto-generated constructor stub
	}
	
	public GameNotFoundException(Integer id) {
		super("Fallo: No existe el juego " + id);
	}
	
	public GameNotFoundException(String publisher) {
		super("Fallo: No existen juegos con editor: " + publisher);
	}
	
	public GameNotFoundException(Genero genero) {
		super("Fallo: No existen juegos del genero: " + genero.getGenero());
	}
}