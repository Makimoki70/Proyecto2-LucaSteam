package com.example.spring.controller;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.spring.controller.error.EstudianteNoEncontradoException;
import com.example.spring.model.Estudiante;
import com.example.spring.service.EstudianteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Validated
@RequestMapping("/students")
@Tag(name = "student", description = "the Student API")
public class EstudentController {
	
	private static final Logger logger = LoggerFactory.getLogger(EstudentController.class);
	
	@Autowired
	private EstudianteService serv;
	
	@GetMapping
	public Collection <Estudiante> readStudents(){
		return serv.findAll();
		
	}
	
	@Operation (summary= "Buscar estudiantes por ID", description = "Dado un ID, devuelve un objeto Student", tags= {"student"})
	@ApiResponses (value= {
			@ApiResponse(responseCode = "200", description = "Estudiante localizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation =  Estudiante.class)) }),
			@ApiResponse (responseCode = "400", description = "No válido (NO implementado)", content = @Content),
			@ApiResponse(responseCode = "404", description = "Studiante no encontrado (NO implementado)", content = @Content)})
	@GetMapping("/{id}")
	public Estudiante resdStudent(
			@Parameter(description = "ID del estudiante a localizar", required=true)
			@PathVariable Long id) {
		logger.info("------ readStudent (GET)");
		return serv.findById(id).orElseThrow(EstudianteNoEncontradoException::new);			
	}
		
	@PostMapping
	public ResponseEntity<?> addStudent (@Valid @RequestBody Estudiante estu) {
		
		logger.info("------ addStudent (POST)");
		Estudiante result = this.serv.save(estu);
		logger.info("------ Dato Salvado " + result);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(result.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@PutMapping
	public Estudiante updateStudent(@RequestBody Estudiante stu) {
		logger.info("------ updateStudent (PUT)");		
		return this.serv.update(stu).orElseThrow(EstudianteNoEncontradoException::new);
	}
	
	@PutMapping("/add")
	public ResponseEntity<Estudiante> updateStudent2 (@RequestBody Estudiante estu){
		Optional <Estudiante> st = this.serv.update(estu);
		if (st.isEmpty()) {
			
			return ResponseEntity.notFound().build();
			
		}
		
		return ResponseEntity.of(st);		
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		
		serv.deleteById(id);
		
	}
			
	
	
}
