package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Jugador;

public interface JugadorService {

	public abstract List<Jugador> listAllJugador();
	
	public abstract Jugador addJugador(Jugador jugador);
}
