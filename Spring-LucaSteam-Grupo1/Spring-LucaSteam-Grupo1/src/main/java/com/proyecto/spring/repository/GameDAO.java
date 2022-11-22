package com.proyecto.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyecto.spring.model.Game;

@Repository
public interface GameDAO extends JpaRepository<Game,Integer> {
	
}
