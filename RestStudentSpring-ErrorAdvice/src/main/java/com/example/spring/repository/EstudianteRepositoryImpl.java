package com.example.spring.repository;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.Optional;

import org.springframework.stereotype.Repository;




import com.example.spring.model.Estudiante;

@Repository
public class EstudianteRepositoryImpl implements EstudianteRepository {

	private Map<Long, Estudiante> estudiantes = new HashMap<>();
	
	private long idActual = 100;
	
	public void datosPrueba() {
		estudiantes.put(++idActual, new Estudiante (idActual, "Antonio", "Santos", "master"));
		estudiantes.put(++idActual, new Estudiante(idActual, "Luis", "Sanz", "lechon"));
		estudiantes.put(++idActual, new Estudiante(idActual, "Joel", "Pascual", "Senior"));
		
	}
	
	
	
	public EstudianteRepositoryImpl() {
		super();
		this.datosPrueba();
	}



	@Override
	public List<Estudiante> findAll() {
		// TODO Auto-generated method stub		
		List<Estudiante> list = new ArrayList<>(estudiantes.values());
		return list;		
	}

	@Override
	public Optional<Estudiante> findById(Long id) {
		// TODO Auto-generated method stub
		Estudiante estu = null;
		
		if (estudiantes.containsKey(id)) {
			estu = estudiantes.get(id);			
		}
		
		return Optional.ofNullable(estu);
		
	}

	@Override
	public Estudiante save(Estudiante estu) {
		estu.setId(++idActual);
		estudiantes.put(estu.getId(), estu);
		return estu;
	}

	@Override
	public Optional<Estudiante> update(Estudiante estu) {
		Estudiante estudianteActual = estudiantes.get(estu.getId());
		
		if (estudianteActual != null) {
			estudiantes.put(estu.getId(), estu);
			estudianteActual = estudiantes.get(estu.getId());	
			
		}		
		
		return Optional.ofNullable(estudianteActual);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		Estudiante estudianteActual = estudiantes.get(id);
		System.out.println("------------ " + estudianteActual);
		
		if (estudianteActual != null) {
			estudiantes.remove(id);			
		}
		
		System.out.println("------------ " + estudiantes);
		
	}

}
