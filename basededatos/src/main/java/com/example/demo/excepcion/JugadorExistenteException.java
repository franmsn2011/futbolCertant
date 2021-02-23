package com.example.demo.excepcion;

public class JugadorExistenteException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JugadorExistenteException(String s) {
		super(s);
	}
}
