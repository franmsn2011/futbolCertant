package com.example.demo.adapter;

import javax.persistence.Column;
import javax.persistence.Id;

public class JugadorAdapter {
	private int idjugador;
	private String nombre;
	private int dni;
	private int edad;
	private String posicion;
	private String estadoCivil;
	private String equipo;
	public JugadorAdapter(int idjugador, String nombre, int dni, int edad, String posicion, String estadoCivil,
			String equipo) {
		super();
		this.idjugador = idjugador;
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.posicion = posicion;
		this.estadoCivil = estadoCivil;
		this.equipo = equipo;
	}
	public JugadorAdapter() {
		super();
	}
	public int getIdjugador() {
		return idjugador;
	}
	public void setIdjugador(int idjugador) {
		this.idjugador = idjugador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dni;
		result = prime * result + edad;
		result = prime * result + ((equipo == null) ? 0 : equipo.hashCode());
		result = prime * result + ((estadoCivil == null) ? 0 : estadoCivil.hashCode());
		result = prime * result + idjugador;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JugadorAdapter other = (JugadorAdapter) obj;
		if (dni != other.dni)
			return false;
		if (edad != other.edad)
			return false;
		if (equipo == null) {
			if (other.equipo != null)
				return false;
		} else if (!equipo.equals(other.equipo))
			return false;
		if (estadoCivil == null) {
			if (other.estadoCivil != null)
				return false;
		} else if (!estadoCivil.equals(other.estadoCivil))
			return false;
		if (idjugador != other.idjugador)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (posicion == null) {
			if (other.posicion != null)
				return false;
		} else if (!posicion.equals(other.posicion))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "JugadorAdapter [idjugador=" + idjugador + ", nombre=" + nombre + ", dni=" + dni + ", edad=" + edad
				+ ", posicion=" + posicion + ", estadoCivil=" + estadoCivil + ", equipo=" + equipo + "]";
	}
	
}