package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Curso;
import com.example.demo.entity.Profesor;
import com.example.demo.service.ICursoService;

@RestController
@RequestMapping("/api")
public class CursoRestController {

	@Autowired
	private ICursoService cursoService;
	
	@GetMapping("/cursos")
	public ResponseEntity<?> listaCursos() {
		List<Curso> listaCurso = cursoService.findAll();
		if(listaCurso != null) {
			if (listaCurso.size() > 0) {
				return new ResponseEntity<>(listaCurso, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/crear_curso")
	public ResponseEntity<?> agregarCurso(@RequestBody Curso curso) {
		cursoService.saveCurso(curso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PostMapping("/cursos_profesor")
	public ResponseEntity<?> verCursosProfesor(@RequestBody Profesor profesor) {
		List<Curso> listaCurso = cursoService.getCursosProfesor(profesor.getId());
		if (listaCurso != null && listaCurso.size() > 0) {
			return new ResponseEntity<>(listaCurso, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
