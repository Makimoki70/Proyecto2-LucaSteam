package com.proyecto.spring.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.proyecto.spring.model.Game;
import com.proyecto.spring.repository.GameDAO;
import com.proyecto.spring.utilities.TratamientoDatos;

@Service("gameService")
public class GameServiceImpl implements GameService {
	
	@Autowired
	private GameDAO data;
	

	@Override
	public Game addGame(Game game) {
		// TODO Auto-generated method stub	
		
		
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
				
				game.setPlataforma(TratamientoDatos.tratarEnumPlataforma(data[2]));
				
				if(!data[3].equals("N/A")){
					game.setFecha(Integer.parseInt(data[3]));
				}
				
				game.setGenero(TratamientoDatos.tratarEnumGenero(data[4]));			
								
				game.setEditor(data[5]);
				
				
				
				data = csvReader.readNext();
			}	
		
		
		
	}

	}
	
	


