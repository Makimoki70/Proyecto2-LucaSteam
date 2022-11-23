package com.example.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.model.Estudiante;
import com.example.spring.repository.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired 
	private EstudianteRepository repo;
	
	
	@Override
	public List<Estudiante> findAll() {
		// TODO Auto-generated method stub
		
		return repo.findAll();
		
	}

	@Override
	public Optional<Estudiante> findById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Estudiante save(Estudiante estu) {
		// TODO Auto-generated method stub
		
		
		return repo.save(estu);
	}

	@Override
	public Optional<Estudiante> update(Estudiante estu) {
		// TODO Auto-generated method stub
		return repo.update(estu);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);		
		
	}

}
