package com.example.demo.excepcion;

public class PosicionNombreIgualException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PosicionNombreIgualException(String s){
		super(s);
	}
}
