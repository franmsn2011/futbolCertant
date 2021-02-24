package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Equipo;
import com.example.demo.entity.Posicion;

public interface EquipoService {
	
	
	public abstract List<Equipo> listAllEquipo();
	
	public abstract Equipo addEquipo(Equipo equipo);
	public abstract Optional<Equipo> listarId(int id);
	public abstract void delete(int idEquipo);
	
	@Modifying
	@Query("update EQUIPO e set e.division='juann' ,e.nombre = 'funciona' where  e.id_equipo ='15'")
	void setUserInfoById(String nombre, String divicion, int id_equipo);
}
