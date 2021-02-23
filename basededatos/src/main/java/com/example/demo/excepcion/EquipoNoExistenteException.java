package com.example.demo.excepcion;

public class EquipoNoExistenteException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EquipoNoExistenteException(String s) {
		super(s);
	}
}
