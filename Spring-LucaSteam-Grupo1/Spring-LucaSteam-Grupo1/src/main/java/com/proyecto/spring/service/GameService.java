package com.proyecto.spring.service;


import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.List;
import java.util.Optional;


import com.proyecto.spring.model.Game;

public interface GameService {
	
	//Para crear juego (C)
	public Game addGame (Game game);
	

	public void cargarDatos() throws FileNotFoundException, IOException;	

	//Para mostrar un juego (R)
	List<Game> findAll();
		
	Optional<Game> findById(int id);
	
	//Para hacer update (U)
	public Optional<Game> update(Game game);
		
	//Para Borrar por id (D)
	public void deleteById(int id);

	public List<Game> findByPublisher(String name); //Buscar por Editor (Nintendo)





	

}
