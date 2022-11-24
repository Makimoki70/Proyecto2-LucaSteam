package com.proyecto.spring.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.proyecto.spring.utilities.TratamientoDatos;


@Entity
@Table(name="games")
public class Game {
	private int id;
	@NotEmpty(message = "El nombre no debe ser vacío") //Si el valor esta vacio, saldra este mensaje
	private String nombre;
	//@NotEmpty(message = "Es necesario indicar una plataforma")
	private Plataforma plataforma;
	//VALORES APLICADOS EN FECHA
	@Max(value = 2022) //Valor maximo
	@Min(value = 1980) //Valor minimo
	private int year;
	//@NotEmpty(message = "Es necesario indicar un genero")
	private Genero genero;
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
		return this.plataforma.getPlataforma();
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = TratamientoDatos.tratarEnumPlataforma(plataforma);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenero() {
		return this.genero.getGenero();
	}
	
	public void setGenero(String genero) {
		this.genero = TratamientoDatos.tratarEnumGenero(genero);
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(editor, other.editor) && genero == other.genero
				&& Objects.equals(nombre, other.nombre) && plataforma == other.plataforma && year == other.year;
	}
}
