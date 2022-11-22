package com.proyecto.spring.service;

import org.springframework.stereotype.Service;

import com.proyecto.spring.model.Game;

@Service
public interface gameService {

	public void addGame(Game game);
	
}
