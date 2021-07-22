package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Profesor;
import com.example.demo.model.MProfesor;

@Component("mapper")
public class Mapper {

	public static List<MProfesor> convertirLista(List<Profesor> profesores) {
		List<MProfesor> mProfesores = new ArrayList<MProfesor>();
		for(Profesor profesor: profesores) {
			mProfesores.add(new MProfesor(profesor));
		}
		return mProfesores;
	}
	
	public static MProfesor convertir(Profesor profesor) {
		MProfesor mProfesor = new MProfesor(profesor);
		return mProfesor;
	}
}
