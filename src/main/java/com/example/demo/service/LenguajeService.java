package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ILenguajeDAO;
import com.example.demo.entity.Lenguaje;

@Service
public class LenguajeService implements ILenguajeService{

	@Autowired
	private ILenguajeDAO lenguajeDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Lenguaje> findAll() {
		return (List<Lenguaje>) lenguajeDAO.findAll();
	}

	@Override
	@Transactional
	public void saveLenguaje(Lenguaje lenguaje) {
		lenguajeDAO.save(lenguaje);		
	}

	@Override
	public Lenguaje findLenguajeByID(Long id) {
		return lenguajeDAO.findByIdSQL(id);
	}

}
