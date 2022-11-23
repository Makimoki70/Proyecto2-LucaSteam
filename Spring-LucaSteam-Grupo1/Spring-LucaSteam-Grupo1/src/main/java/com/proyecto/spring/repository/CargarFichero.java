package com.proyecto.spring.repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.proyecto.spring.model.Game;

@Component
public class CargarFichero {
	
	@Autowired
	private GameDAO datos;
	
	public void cargaInicial() throws FileNotFoundException, IOException    {		
			
		if(datos.findAll().isEmpty()) {
		
			CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/vgsales.csv"),',','"');
			csvReader.readNext();
			String [] data = csvReader.readNext();			
			
			while (null!=data) {
				//System.out.println(data[1]);
				Game game = new Game ();
				
				game.setNombre(data[1]);
				
				game.setPlataforma(data[2]);
				
				try {
					game.setYear(Integer.parseInt(data[3]));
				}catch (NumberFormatException e) {
					game.setYear(1980);
				}
				
				game.setGenero(data[4]);			
								
				game.setEditor(data[5]);	
				
				datos.save(game);
				
				data = csvReader.readNext();				
			}	
		}
	}
	

}
