package com.example.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Lenguaje;

public interface ILenguajeDAO extends CrudRepository<Lenguaje, Long> {

	@Query("select l from Lenguaje l where l.id=?1")
	public Lenguaje findByIdSQL(Long id);
	
	//public Optional<Lenguaje> findById(Long id);
	
}
