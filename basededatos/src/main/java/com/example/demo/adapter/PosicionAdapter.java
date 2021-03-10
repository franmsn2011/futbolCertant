package com.example.demo.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.Posicion;

public class PosicionAdapter {
	private int idPosicion;
	private String nombre;
	private String atrasadoAdelantado;
	
	
	
	public PosicionAdapter(Posicion posicion) {
		super();
		this.idPosicion = posicion.getIdPosicion();
		this.nombre = posicion.getNombre();
		String adelan="No";
		if(posicion.isAtrasadoAdelantado()==true)adelan="Si";
		this.atrasadoAdelantado = adelan;
	}

	@Override
	public String toString() {
		return "PosicionAdapter [idPosicion=" + idPosicion + ", nombre=" + nombre + ", atrasadoAdelantado="
				+ atrasadoAdelantado + "]";
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

	public static List<PosicionAdapter> createListOfAdapters(List<Posicion> posiciones){
		List<PosicionAdapter> listPosicionAdapter= new ArrayList<PosicionAdapter>();
		for (int i = 0; i < posiciones.size(); i++)
		listPosicionAdapter.add(new PosicionAdapter(posiciones.get(i)));
		return listPosicionAdapter; 
	}
	
}
