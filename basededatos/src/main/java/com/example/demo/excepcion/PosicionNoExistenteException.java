package com.example.demo.excepcion;

public class PosicionNoExistenteException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PosicionNoExistenteException(String s){
		super(s);
	}
}
