package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IProfesorDAO;
import com.example.demo.entity.Profesor;

@Service
public class ProfesorServiceImpl implements IProfesorService {

	@Autowired
	private IProfesorDAO profesorDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Profesor> findAll() {
		return (List<Profesor>) profesorDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor findProfesor(Profesor profesor) {
		return (Profesor) profesorDAO.findByEmail(profesor.getEmail());
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor checkProfesorLogin(Profesor profesor) {
		return (Profesor) profesorDAO.findByEmailAndPassword(
				profesor.getEmail(), profesor.getPassword());
	}

	@Override
	@Transactional
	public void deleteProfesor(Profesor profesor) {
		profesorDAO.deleteById(profesor.getId());
	}

	@Override
	@Transactional
	public Profesor updProfesor(Profesor profesor) {
		return (Profesor) profesorDAO.save(profesor);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Profesor> findProfesorById(Long profersor_id) {
		return (Optional<Profesor>) profesorDAO.findById(profersor_id);
	}

	@Override
	@Transactional
	public void deleteProfesor(Long id) {
		profesorDAO.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor findById(Long id) {
		return profesorDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor findByIdSQL(Long id) {
		return profesorDAO.findByIdSQL(id);
	}

	@Override
	@Transactional
	public void save(Profesor profesor) {
		profesorDAO.save(profesor);
	}

	@Override
	public void deleteAllProfesor() {
		profesorDAO.deleteAll();
	}

}
