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
	@ExceptionHandler(PosicionNombreIgualException.class)
	public ResponseEntity<?> posicionNombreIgualException(PosicionNombreIgualException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	@ExceptionHandler(PosicionInexistenteException.class)
	public ResponseEntity<?> posicionInexistenteException(PosicionInexistenteException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}
	@ExceptionHandler(EstadoCivilException.class)
	public ResponseEntity<?> estadoCivilException(EstadoCivilException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}
	@ExceptionHandler(JugadorInexistenteException.class)
	public ResponseEntity<?> jugadorInexistenteException(JugadorInexistenteException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}
	@ExceptionHandler(JugadorExistenteException.class)
	public ResponseEntity<?> jugadorExistenteException(JugadorExistenteException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}
	
	@ExceptionHandler(EquipoExistenteException.class)
	public ResponseEntity<?> equipoExistenteException(EquipoExistenteException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}
	@ExceptionHandler(EquipoErrorDatosIguales.class)
	public ResponseEntity<?> equipoErrorDatosIguales(EquipoErrorDatosIguales e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}
	
	
	
}
