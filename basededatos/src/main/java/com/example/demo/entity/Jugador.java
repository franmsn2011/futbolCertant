package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Jugador implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idJugador")
	private int idjugador;
	@Column
	private String nombre;
	@Column
	private int dni;
	@Column
	private int edad;
	@Column
	private int posicion;
	@Column
	private String estadoCivil;
	@Column
	private int equipo;

	public Jugador(int idjugador, String nombre, int dni, int edad, int posicion, String estadoCivil) {
		super();
		this.idjugador = idjugador;
		this.nombre = nombre.trim();
		this.dni = dni;
		this.edad = edad;
		this.posicion = posicion;
		this.estadoCivil = estadoCivil;

	}

	public Jugador(int idjugador, String nombre, int dni, int edad, int posicion, String estadoCivil, int equipo) {
		super();
		this.idjugador = idjugador;
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.posicion = posicion;
		this.estadoCivil = estadoCivil;
		this.equipo = equipo;
	}

	public Jugador() {
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

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public int getEquipo() {
		return equipo;
	}

	public void setEquipo(int equipo) {
		this.equipo = equipo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dni;
		result = prime * result + edad;
		result = prime * result + ((estadoCivil == null) ? 0 : estadoCivil.hashCode());
		result = prime * result + idjugador;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Jugador other = (Jugador) obj;
		if (dni != other.dni)
			return false;
		if (edad != other.edad)
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

		return true;
	}

	@Override
	public String toString() {
		return "Jugador [idjugador=" + idjugador + ", nombre=" + nombre + ", dni=" + dni + ", edad=" + edad
				+ ", posicion=" + posicion + ", estadoCivil=" + estadoCivil + ", Equipo=" + equipo + "]\n";
	}


}