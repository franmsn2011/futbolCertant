package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Jugador;

public interface JugadorService {

	public abstract List<Jugador> listAllJugador();
	
	public abstract Jugador addJugador(Jugador jugador);
	
	public abstract Optional<Jugador> listarId(int dni);
	
	public abstract void delete(int dni);
}
