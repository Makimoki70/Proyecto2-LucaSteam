package com.example.spring.service;

import java.util.List;
import java.util.Optional;

import com.example.spring.model.Estudiante;

public interface EstudianteService {
	
	public List<Estudiante> findAll();
	
	public Optional <Estudiante> findById(Long id);
	
	public Estudiante save (Estudiante estu);
	
	public Optional <Estudiante> update (Estudiante estu);
	
	public void deleteById(Long id);

}