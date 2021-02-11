package maven_jpa.futbol.dao.interfaces;

import java.util.List;

import maven_jpa.futbol.entity.Equipo;

public interface IDaoEquipo {
	public Equipo saveEquipo(Equipo equipo);
	
	public List<Equipo> findEquipo(String nombre);
}
