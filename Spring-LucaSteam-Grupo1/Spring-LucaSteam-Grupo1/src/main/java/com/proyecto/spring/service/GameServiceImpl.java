package com.proyecto.spring.service;


import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.proyecto.spring.model.Game;
import com.proyecto.spring.repository.CargarFichero;
import com.proyecto.spring.repository.GameDAO;


@Service("gameService")
public class GameServiceImpl implements GameService {
	
	@Autowired
	private GameDAO data;
	
	@Autowired
	private CargarFichero carga;
	
	@Override
	public Game addGame(Game game) {
		return data.save(game);
	}

	@Override
	public void cargarDatos() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub

		carga.cargaInicial();
		
	}
	

	
	
	@Override
	public List<Game> findAll() {
		return data.findAll();
	}
	
	@Override
	public Optional<Game> findById(int id) {
		return data.findById(id);
	}
	
	@Override
	public Optional<Game> update(Game game) {
		
		Optional<Game> currentGame = data.findById(game.getId());
		if (!currentGame.isEmpty()) {
			currentGame = Optional.of(data.save(game));
		}
		
		return currentGame;
				
	}
	
	@Override
	public void deleteById(int id) {
		data.deleteById(id);
	}


	@Override
	public List<Game> findByPublisher(String name) { //Buscador de publisher (para Nintendo)
		return data.findByPublisher(name);
	}

	@Override
	public List<Game> findByGenre(String name){ // Buscador por genero.
		return data.findByGenre(name);
	}

	@Override
	public List<Game> sigloxx(){
		return data.sigloxx();
	}

	@Override
	public String demo(){
		return data.demo().toString();
	}

	
}

