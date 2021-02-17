package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Equipo;

public interface EquipoService {
	
	
	public abstract List<Equipo> listAllEquipo();
	
	public abstract Equipo addEquipo(Equipo equipo);
	
	
}
