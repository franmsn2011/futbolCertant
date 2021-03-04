package com.example.demo.adapter;

import javax.persistence.Column;

public class PosicionAdapter {
	private int idPosicion;
	private String nombre;
	private String atrasadoAdelantado;
	public PosicionAdapter() {
		super();
	}
	public PosicionAdapter(int idPosicion, String nombre, String atrasadoAdelantado) {
		super();
		this.idPosicion = idPosicion;
		this.nombre = nombre;
		this.atrasadoAdelantado = atrasadoAdelantado;
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
	public String getAtrasadoAdelantado() {
		return atrasadoAdelantado;
	}
	public void setAtrasadoAdelantado(String atrasadoAdelantado) {
		this.atrasadoAdelantado = atrasadoAdelantado;
	}
	@Override
	public String toString() {
		return "PosicionAdapter [idPosicion=" + idPosicion + ", nombre=" + nombre + ", atrasadoAdelantado="
				+ atrasadoAdelantado + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atrasadoAdelantado == null) ? 0 : atrasadoAdelantado.hashCode());
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
		PosicionAdapter other = (PosicionAdapter) obj;
		if (atrasadoAdelantado == null) {
			if (other.atrasadoAdelantado != null)
				return false;
		} else if (!atrasadoAdelantado.equals(other.atrasadoAdelantado))
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
	
	
}
