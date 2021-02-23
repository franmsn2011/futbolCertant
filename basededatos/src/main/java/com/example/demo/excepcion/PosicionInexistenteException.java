package com.example.demo.excepcion;

public class PosicionInexistenteException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PosicionInexistenteException(String s) {
		super(s);
	}
}
