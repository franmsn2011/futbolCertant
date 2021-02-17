package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import maven_jpa.futbol.entity.Posicion;

@Table
@Entity
//@IdClass(PosicionId.class)

public class Posicion implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	// @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idPosicion")
	private int idPosicion;
	// @Id
	@Column(name = "nombre")
	private String nombre;
	@Column
	private boolean atrasadoAdelantado;

	public Posicion(int idPosicion, String nombre, boolean atrasadoAdelantado) {
		super();
		this.idPosicion = idPosicion;
		this.nombre = nombre;
		this.atrasadoAdelantado = atrasadoAdelantado;
	}

	public Posicion() {
		super();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdPosicion() {
		return idPosicion;
	}

	public void setIdPosicion(int idPosicion) {
		this.idPosicion = idPosicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isAtrasadoAdelantado() {
		return atrasadoAdelantado;
	}

	public void setAtrasadoAdelantado(boolean atrasadoAdelantado) {
		this.atrasadoAdelantado = atrasadoAdelantado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (atrasadoAdelantado ? 1231 : 1237);
		result = prime * result + idPosicion;
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
		Posicion other = (Posicion) obj;
		if (atrasadoAdelantado != other.atrasadoAdelantado)
			return false;
		if (idPosicion != other.idPosicion)
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
		return "Posicion [idPosicion=" + idPosicion + ", nombre=" + nombre + ", atrasadoAdelantado="
				+ atrasadoAdelantado + "]\n";
	}

}
