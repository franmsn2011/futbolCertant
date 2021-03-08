package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Jugador;

@Repository("jugadorRepository")
public interface JugadorRespository extends JpaRepository<Jugador, Serializable>{

	public List<Jugador> findByPosicionAndEquipo(int posicion, int equipo);
	public List<Jugador> findByPosicion(int posicion);
	public List<Jugador> findByEquipo(int equipo);
	public List<Jugador> findByDni(int dni);
}
