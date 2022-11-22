package com.proyecto.spring.controller;



import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.proyecto.spring.model.Game;
import com.proyecto.spring.service.GameService;

import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@Validated
@RequestMapping("/games")
@Tag(name = "student", description = "the Games API")
public class GameController {
	
	@Autowired
	private GameService serv;
	
	@PostMapping
	public ResponseEntity<?> addGame (@Valid @RequestBody Game game)
	{
		
		Game result = this.serv.addGame(game);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(result.getNombre()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	

}
