package com.proyecto.spring.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.spring.model.Game;

public interface GameService {
	
	//Para crear juego (C)
	public Game addGame (Game game);
	
	//Para mostrar un juego (R)
	List<Game> findAll();
		
	Optional<Game> findById(int id);
	
	//Para hacer update (U)
	public void update(Game game);
		
	//Para Borrar por id (D)
	public void deleteById(int id);

	public List<Game> FindByPublisher(String name); //Buscar por Editor (Nintendo)
}
