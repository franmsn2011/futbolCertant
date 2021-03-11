package com.example.demo.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.Equipo;
import com.example.demo.entity.Jugador;
import com.example.demo.entity.Posicion;

public class JugadorAdapter {
	private int idjugador;
	private String nombre;
	private int dni;	
	private int edad;	
	private String posicion;
	private String estadoCivil;
	private String equipo;
	


	public JugadorAdapter(Jugador jugador,String p,String e) {
		super();
		this.idjugador = jugador.getIdjugador();
		this.dni = jugador.getDni();
		this.edad = jugador.getEdad();
		this.nombre = jugador.getNombre();
		this.estadoCivil = jugador.getEstadoCivil();
		this.posicion = p;
		this.equipo = e;
	}

	public JugadorAdapter() {
		super();
	}

	public int getIdjugador() {
		return idjugador;
	}

	public String getNombre() {
		return nombre;
	}

	public int getDni() {
		return dni;
	}

	public int getEdad() {
		return edad;
	}

	public String getPosicion() {
		return posicion;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public String getEquipo() {
		return equipo;
	}

	public static List<JugadorAdapter> createListOfAdapters(List<Jugador> jugadores, List<Posicion> posiciones,
			List<Equipo> equipos) {
		List<JugadorAdapter> listJugadorAdapter = new ArrayList<JugadorAdapter>();

		for (int i = 0; i < jugadores.size(); i++) {
			boolean posicionEncontrada = false;
			String nombrePosicion = "Ninguna";
			String nombreEquipo = "Ninguno";
			int index = 0;
			while (index < posiciones.size() && posicionEncontrada == false) {
				if (jugadores.get(i).getPosicion() == posiciones.get(index).getIdPosicion()) {
					nombrePosicion = posiciones.get(index).getNombre();
					posicionEncontrada = true;
				}
				index++;
			}
			index = 0;
			boolean equipoEncontrado = false;
//			for (int j = 0; j < equipos.size() && !equipoEncontrado; j++)
			while (index < equipos.size() && equipoEncontrado == false) {
				if (jugadores.get(i).getEquipo() == equipos.get(index).getIdEquipo()) {
					nombreEquipo = equipos.get(index).getNombre();
					equipoEncontrado = true;
				}
				index++;
			}
				
			listJugadorAdapter.add(new JugadorAdapter(jugadores.get(i), nombrePosicion, nombreEquipo));
		}
		return listJugadorAdapter;
	}

}
