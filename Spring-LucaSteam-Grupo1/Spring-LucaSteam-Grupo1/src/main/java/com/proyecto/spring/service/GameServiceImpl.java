package com.proyecto.spring.service;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.proyecto.spring.model.Game;
import com.proyecto.spring.repository.GameDAO;
import com.proyecto.spring.utilities.TratamientoDatos;

@Service("gameService")
public class GameServiceImpl implements GameService {
	
	@Autowired
	private GameDAO data;
	
	@Override
	public Game addGame(Game game) {
		return data.save(game);
	}


	@Override
	public void cargaInicial() throws FileNotFoundException, IOException    {
		// TODO Auto-generated method stub
		

			
			CSVReader csvReader = new CSVReader(new FileReader("resources/vgsales.csv"),',','"');
			csvReader.readNext();
			String [] data = csvReader.readNext();			
			
			while (null!=data) {
				
				Game game = new Game ();
				
				game.setNombre(data[1]);
				
				game.setPlataforma(data[2]);
				
				if(!data[3].equals("N/A")){
					game.setYear(Integer.parseInt(data[3]));
				}
				
				game.setGenero(data[4]);			
								
				game.setEditor(data[5]);
				
				
				
				data = csvReader.readNext();
			}	
		
		
		
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
	public void update(Game game) {
		data.save(game);
	}
	
	@Override
	public void deleteById(int id) {
		data.deleteById(id);
	}


	@Override
	public List<Game> findByPublisher(String name) { //Buscador de publisher (para Nintendo)
		return data.findByPublisher(name);
	}
}

