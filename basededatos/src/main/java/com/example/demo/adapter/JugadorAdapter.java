package com.example.demo.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.Jugador;

public class JugadorAdapter {
	private Jugador jugador;

	public JugadorAdapter(Jugador jugador) {
		super();
		this.jugador = jugador;
	}

	public JugadorAdapter() {
		super();
	}

	public int getIdjugador() {
		return jugador.getIdjugador();
	}

	public String getNombre() {
		return jugador.getNombre();
	}

	public int getDni() {
		return jugador.getDni();
	}

	public int getEdad() {
		return jugador.getEdad();
	}

	public String getPosicion() {
		return jugador.getDescripcionPosicion();
	}

	public String getEstadoCivil() {
		return jugador.getEstadoCivil();
	}

	public String getEquipo() {
		return jugador.getDescripcionEquipo();
	}

	public static List<JugadorAdapter> createListOfAdapters(List<Jugador> jugadores){
		List<JugadorAdapter> listJugadorAdapter= new ArrayList<JugadorAdapter>();
		for (int i = 0; i < jugadores.size(); i++)
		listJugadorAdapter.add(new JugadorAdapter(jugadores.get(i)));
		return listJugadorAdapter; 
	}

}
