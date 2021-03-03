package com.example.demo.service;

import java.util.List;
import java.util.Optional;


import com.example.demo.entity.Equipo;

public interface EquipoService {
	
	
	public abstract List<Equipo> listAllEquipo();
	
	public abstract Equipo addEquipo(Equipo equipo);
	public abstract Optional<Equipo> listarId(int id);
	public abstract void delete(int idEquipo);
}
