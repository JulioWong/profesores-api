package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Profesor;
import com.example.demo.service.IProfesorService;
// import com.example.demo.service.ProfesorServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProfesorRestControllerTests {
	
	// IProfesorService profesorServiceMock = Mockito.mock(IProfesorService.class);
	@Mock
	IProfesorService profesorService;
	
	@InjectMocks
	ProfesorRestController profesorRestController;
	
	@BeforeEach
	void setUp() {
		/*Profesor profesorRequest = new Profesor();
		profesorRequest.setEmail("julioo.wong@gmail.com");
		
		Profesor profesorResponse = new Profesor();
		profesorResponse.setId(1L);
		profesorResponse.setNombre("Julio");
		
		when(profesorService.findProfesor(profesorRequest)).thenReturn(profesorResponse);*/
		System.out.println("Antes de la prueba");
	}
	
	@Test
	void findProfesor() {
		
		Profesor profesorRequest = new Profesor();
		profesorRequest.setEmail("julioo.wong@gmail.com");
		
		Profesor profesorResponse = new Profesor();
		profesorResponse.setId(1L);
		profesorResponse.setNombre("Julio");
		
		when(profesorService.findProfesor(profesorRequest)).thenReturn(profesorResponse);
		
		ResponseEntity<?> responseService;
		responseService = profesorRestController.findProfesor(profesorRequest);
		assertThat(responseService.getStatusCodeValue()).isEqualTo(200);
		assertEquals(1, 1);
	}


}
