package com.example.demo.excepcion;

public class PosicionExistenteException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PosicionExistenteException(String s) {
		super(s);
	}
}
