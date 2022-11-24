package com.proyecto.spring.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.proyecto.spring.controller.error.GameNotFoundException;
import com.proyecto.spring.model.Game;
import com.proyecto.spring.service.GameService;

import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@Validated
@RequestMapping("/games")
@Tag(name = "game", description = "the Games API")
public class GameController {

	@Autowired
	private GameService serv;
	
	public void cargarDatos() throws FileNotFoundException, IOException {
		
		serv.cargarDatos();
		
	}
	
	//Metodos que autoimplementa Spring con JPA
	//Listar Usuarios
	@GetMapping
	public List<Game> findAll() {
		return serv.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Game> findById(@PathVariable int id) {
		return serv.findById(id);
	}
	
	@GetMapping("/publisher/{name}")
	public List<Game> listGamesByPublisher(@PathVariable String name) { //Busqueda de publishers (para Nintendo)
		return serv.findByPublisher(name);
	}
	
	@GetMapping("/publisher/Nintendo")
	public List<Game> listGamesByNintendo() { 
		return serv.findByPublisher("Nintendo");
	}
	
	@GetMapping("/genre/{name}")
	public List<Game> listGamesByGenre(@PathVariable String name){
		return serv.findByGenre(name);
	}
	
	@GetMapping("/demo")
	public String demostracion(){
		return "Hay "+serv.demo().length()+" juegos:\n"+serv.demo();
	}

	@GetMapping("/sigloxx")
	public List<Game> findSigloXX(){
		return serv.sigloxx();
	}
	
	//Updatear juegos
	@PutMapping
	public Game update(@RequestBody Game game) {
		System.out.println(game.toString());
		return this.serv.update(game).orElseThrow(GameNotFoundException::new);
	}
	
	//Eliminar juegos por Id
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable int id){
		try {
			serv.deleteById(id);
			return "El juego ha sido borrado.";
		}catch(Exception e){
			return "No existe un juego con ese código.";
		}
	}
	
	@PostMapping
	public ResponseEntity<?> addGame (@Valid @RequestBody Game game)
	{
		Game result = this.serv.addGame(game);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(result.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
