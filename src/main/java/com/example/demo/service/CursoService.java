package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ICursoDAO;
import com.example.demo.entity.Curso;

@Service
public class CursoService implements ICursoService{

	@Autowired
	private ICursoDAO cursoDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Curso> findAll() {
		return (List<Curso>) cursoDAO.findAll();
	}

	@Override
	public void saveCurso(Curso curso) {
		cursoDAO.save(curso);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Curso> getCursosProfesor(Long id) {
		return (List<Curso>) cursoDAO.findByProfesorId(id);
	}

}
