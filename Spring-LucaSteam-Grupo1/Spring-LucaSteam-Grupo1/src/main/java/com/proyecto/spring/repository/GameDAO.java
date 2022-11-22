package com.proyecto.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyecto.spring.model.Game;

@Repository
public interface GameDAO extends JpaRepository<Game,Integer> {

	//Query para hacer la busqueda de nintendo
    @Query("FROM Game WHERE editor = ?1")
    List<Game> findByPublisher(String name);
}

