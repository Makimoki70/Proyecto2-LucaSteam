package com.proyecto.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="games")
public class Game {
	private int id;
	@NotEmpty(message = "El nombre no debe ser vacío") //Si el valor esta vacio, saldra este mensaje
	private String nombre;
	@NotEmpty(message = "Es necesario indicar una plataforma")
	private String plataforma;
	//VALORES APLICADOS EN FECHA
	@Max(value = 2022) //Valor maximo
	@Min(value = 1980) //Valor minimo
	private int year;
	@NotEmpty(message = "Es necesario indicar un genero")
	private String genero;
	@NotEmpty(message = "Es necesario indicar un editor")
	private String editor;
	
	
	public Game() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", nombre=" + nombre + ", plataforma=" + plataforma + ", year=" + year + ", genero="
				+ genero + ", editor=" + editor + "]";
	}
}
