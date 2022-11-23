package com.example.spring.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Estudiante {
	
	private Long id;
	@NotEmpty(message="El nombre no debe de estar vacío")
	private String nombre;
	@NotEmpty(message="Necesitamos que indiques un apellido")
	private String lastname;
	@Max (value = 2022)
	@Positive
	@Size(min=3, max=30)
	private String year;
	
	public Estudiante() {
		super();
	}
	
	public Estudiante(Long id,String nombre,
			String lastname, String year) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.lastname = lastname;
		this.year = year;
	}
	
	

	public Estudiante(String nombre, String lastname,
		String year) {
		super();
		this.nombre = nombre;
		this.lastname = lastname;
		this.year = year;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", lastname=" + lastname + ", year=" + year + "]";
	
	}
	
	
	
	
	
}
