package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Posicion;

public interface PosicionService {
	
	
	public abstract List<Posicion> listAllPosicion();
	
	public abstract Posicion addPosicion(Posicion posicion);

}
