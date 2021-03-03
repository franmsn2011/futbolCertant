package com.example.demo.service;

import java.util.List;
import java.util.Optional;


import com.example.demo.entity.Posicion;

public interface PosicionService {
	
	
	public abstract List<Posicion> listAllPosicion();
	
	public abstract Posicion addPosicion(Posicion posicion);
	
	public abstract Optional<Posicion> listarId(int id);
	public abstract void delete(int idPosicion);

}
