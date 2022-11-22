package com.proyecto.spring.utilities;


import com.proyecto.spring.model.Genero;
import com.proyecto.spring.model.Plataforma;

public class TratamientoDatos {
	
	public static Plataforma tratarEnumPlataforma(String stringPrincipal) {
		//Guardamos en un array todos los valores del Enum
		Plataforma[] arrayPlataforma = Plataforma.values();
		
		//Recorremos el array, buscando el values ("") de cada token del enum
		for (Plataforma p : arrayPlataforma) {
			if (p.getPlataforma().equals(stringPrincipal)) {
				return p;
			}
		}
		//En caso de no encontrar en la lista el valor, devolvemos el por defecto
		return Plataforma.Defecto;
	}
	
	public static Genero tratarEnumGenero(String stringPrincipal) {
		Genero[] arrayGenero = Genero.values();
		for (Genero g : arrayGenero) {
			if (g.getGenero().equals(stringPrincipal)) {
				return g;
			}
		}
		return Genero.Defecto;
	}
	
	
	
}