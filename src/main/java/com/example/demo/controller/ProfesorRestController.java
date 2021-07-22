package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Profesor;
import com.example.demo.mapper.Mapper;
import com.example.demo.model.MProfesor;
import com.example.demo.service.IProfesorService;

@RestController
@RequestMapping("/api")
public class ProfesorRestController {
	
	@Autowired
	private IProfesorService profesorService;
	
	@GetMapping("/profesores")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Profesor> getProfesores() {
		return profesorService.findAll();
	}
	
	@PostMapping("/find_profesor")
	public ResponseEntity<?> findProfesor(@RequestBody Profesor profesor) {
		Profesor profesorDB = profesorService.findProfesor(profesor);
		if(profesorDB != null) {
			return new ResponseEntity<>(profesorDB, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<Void> addProfesor(@RequestBody Profesor profesor) {
		if(profesorService.findProfesor(profesor) == null) {
			profesorService.save(profesor);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		
		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}
	
	@PostMapping("login")
	public ResponseEntity<?> loginProfesor(@RequestBody Profesor profesor) {
		Profesor profesorDB = profesorService.checkProfesorLogin(profesor);
		if (profesorDB != null) {
			
			/*
			List<Profesor> profesores = new ArrayList<Profesor>();
			profesores.add(profesorDB);
			List<MProfesor> mprofesores = new ArrayList<MProfesor>();
			mprofesores = Mapper.convertirLista(profesores);
			*/
			
			MProfesor mprofesores = Mapper.convertir(profesorDB);
			return new ResponseEntity<>(mprofesores, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updProfesor(@PathVariable (value = "id") Long id, @RequestBody Profesor profesor) {
		Profesor profesorDB = null;
		profesorDB = profesorService.findById(id);
		
		if (profesorDB != null) {
			profesorDB.setEmail(profesor.getEmail());
			profesorDB.setNombre(profesor.getNombre());
			profesorService.updProfesor(profesorDB);
			return new ResponseEntity<>(profesorDB, HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/update_sql")
	public ResponseEntity<?> updProfesorSql(@RequestBody Profesor profesor) {
		Profesor profesorDB = null;
		profesorDB = profesorService.findByIdSQL(profesor.getId());
		
		if (profesorDB != null) {
			profesorDB.setEmail(profesor.getEmail());
			profesorDB.setNombre(profesor.getNombre());
			profesorService.updProfesor(profesorDB);
			return new ResponseEntity<>(profesorDB, HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteProfesor(@PathVariable(value = "id") Long id) {
		profesorService.deleteProfesor(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Void> deleteAllProfesor() {
		profesorService.deleteAllProfesor();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("/delete_post")
	public ResponseEntity<Void> deleteProfesorPost(@RequestBody Profesor profesor) {
		if (profesorService.findProfesor(profesor) != null) {
			profesorService.deleteProfesor(profesor);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
