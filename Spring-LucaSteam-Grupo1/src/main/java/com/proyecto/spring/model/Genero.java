package com.proyecto.spring.model;

public enum Genero {
	Action("Action"),
	Adventure("Adventure"),
	Fighting("Fighting"),
	Misc("Misc"),
	Platform("Platform"),
	Puzzle("Puzzle"),
	Racing("Racing"),
	Roleplaying("Role-Playing"),
	Shooter("Shooter"),
	Simulation("Simulation"),
	Sports("Sports"),
	Strategy("Strategy"),
	Defecto("No tiene genero valido");

	private String genero;
	
	private Genero () {
		
	}

	private Genero(String genero) {
		this.genero = genero;
	}
	
	public String getGenero() {
		return genero;
	}
	
	
	public String toString() {
		return this.name();
	}
}
