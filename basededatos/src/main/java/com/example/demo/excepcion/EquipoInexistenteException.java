package com.example.demo.excepcion;

public class EquipoInexistenteException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EquipoInexistenteException(String s) {
		super(s);
	}
}
