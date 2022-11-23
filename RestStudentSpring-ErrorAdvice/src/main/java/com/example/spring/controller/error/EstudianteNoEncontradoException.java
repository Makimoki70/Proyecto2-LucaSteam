package com.example.spring.controller.error;

public class EstudianteNoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EstudianteNoEncontradoException() {
		super("Epic Fail: No existe el estudiante");
		// TODO Auto-generated constructor stub
	}
	
	public EstudianteNoEncontradoException(Long id) {
		
		super("Epic Fail: No existe el estudiante " + id);
		
	}
	
	
}
