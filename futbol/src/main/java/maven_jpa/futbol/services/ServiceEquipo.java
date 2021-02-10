package maven_jpa.futbol.services;


import java.util.List;

import maven_jpa.futbol.dao.DaoEquipo;
import maven_jpa.futbol.entity.Equipo;

public class ServiceEquipo {
	public Equipo agregarEquipo(Equipo e) {
		DaoEquipo crud = new DaoEquipo();
		
		e = crud.saveEquipo(e);
			
		
		return e;
	}
	public Equipo traerEquipo(int idEquipo) {
		DaoEquipo crud = new DaoEquipo();
		return crud.findEquipo(idEquipo);
	}
	/*
	// trae la posicion del nombre y true
	public Equipo traerEquipo(String nombre) {
		DaoEquipo crud = new DaoEquipo();
		System.out.println("te1");
		List<Equipo> e = crud.findTodasLosEquipo();
		System.out.println("te2");
		return traerEquipoEnLista(e, nombre);
	}

	// trae la posicion pero de la lista que le mandemos
	public Equipo traerEquipoEnLista(List<Equipo> listaEquipo, String nombre) {
		Equipo e = null;
		int index = 0;
		while (index < listaEquipo.size() && e == null) {
			if (listaEquipo.get(index).getNombre().equalsIgnoreCase(nombre)) {
				e = listaEquipo.get(index);
			}
			index++;
		}
		return e;
	}
*/
	public List<Equipo> TraerEquipos() {
		DaoEquipo crud = new DaoEquipo();
		return crud.findTodasLosEquipo();
	}

	public void borrarEquipo(Equipo equipo) {
		DaoEquipo crud = new DaoEquipo();
		crud.borrarEquipo(equipo);
	}
	public void modificarEquipo(Equipo equipo) {
		DaoEquipo crud= new DaoEquipo();
		crud.modificarEquipo(equipo);
	}
}
