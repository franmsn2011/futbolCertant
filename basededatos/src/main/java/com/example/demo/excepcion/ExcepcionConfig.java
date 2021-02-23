package com.example.demo.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(annotations = Controller.class)
public class ExcepcionConfig {
	
	@ExceptionHandler(PosicionExistenteException.class)
	public ResponseEntity<?> posicionExistenteException(PosicionExistenteException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}

}
