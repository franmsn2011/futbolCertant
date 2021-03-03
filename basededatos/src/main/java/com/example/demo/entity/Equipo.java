package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Equipo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idEquipo")
	private int idEquipo;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "division")
	private String division;

	public Equipo() {
		super();
	}

	public Equipo(int idEquipo, String nombre, String division) {
		super();
		this.idEquipo = idEquipo;
		this.nombre = nombre;
		this.division = division;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String divicion) {
		this.division = divicion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((division == null) ? 0 : division.hashCode());
		result = prime * result + idEquipo;
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
		Equipo other = (Equipo) obj;
		if (division == null) {
			if (other.division != null)
				return false;
		} else if (!division.equals(other.division))
			return false;
		if (idEquipo != other.idEquipo)
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
		return "Equipo [idEquipo=" + idEquipo + ", nombre=" + nombre + ", division=" + division + "]\n";
	}

}
