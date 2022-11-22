package com.proyecto.spring.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.proyecto.spring.model.Game;

public interface GameService {
	
	public Game addGame (Game game);
	
	public void cargaInicial() throws FileNotFoundException, IOException;
	
}
