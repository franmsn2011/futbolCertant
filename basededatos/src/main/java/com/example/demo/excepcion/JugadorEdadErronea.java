package com.example.demo.excepcion;

public class JugadorEdadErronea extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 public JugadorEdadErronea(String s) {
		super(s);
	}
}
