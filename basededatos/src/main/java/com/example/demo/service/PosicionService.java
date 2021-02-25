package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Posicion;

public interface PosicionService {
	
	
	public abstract List<Posicion> listAllPosicion();
	
	public abstract Posicion addPosicion(Posicion posicion);
	
	public abstract Optional<Posicion> listarId(int id);
	public abstract void delete(int idPosicion);
	
	//public abstract Optional<Posicion> listarJugadoresPosicion(int idPosicion);
	
	@Modifying
	@Query("update Posicion p set p.nombre = ?1, u.ATRASADO_ADELANTADO = ?2 where u.ID_POSICION = ?3")
	void setUserInfoById(String nombre, boolean activo, int id_Posicion);
}
