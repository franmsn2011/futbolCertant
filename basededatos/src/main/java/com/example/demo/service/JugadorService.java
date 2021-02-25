package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Jugador;

public interface JugadorService {

	public abstract List<Jugador> listAllJugador();
	
	public abstract Jugador addJugador(Jugador jugador);
	
	public abstract Optional<Jugador> listarId(int idJugador);
	
	@Query("select * from JUGADOR J where J.POSICION = ?26 ")
	public abstract List<Jugador> listarJugadoresxP(int idPosicion,int idEquipo);
	
	public abstract void delete(int idJugador);
	
	public void EliminaEquipoDeJugadores(int idEquipo);
}
