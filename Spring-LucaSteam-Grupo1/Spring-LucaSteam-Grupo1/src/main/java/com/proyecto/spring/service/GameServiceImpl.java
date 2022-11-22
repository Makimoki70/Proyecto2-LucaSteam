package com.proyecto.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.spring.model.Game;
import com.proyecto.spring.repository.GameDAO;

@Service("gameService")
public class GameServiceImpl implements GameService {
	
	@Autowired
	private GameDAO data;
	

	@Override
	public Game addGame(Game game) {
		// TODO Auto-generated method stub	
		
		
		return data.save(game);
		
	}
	
	

}
