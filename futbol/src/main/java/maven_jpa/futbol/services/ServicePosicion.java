package maven_jpa.futbol.services;

import java.util.List;

import maven_jpa.futbol.dao.DaoPosicion;
import maven_jpa.futbol.entity.Posicion;

public class ServicePosicion {
	public Posicion agregarPosicion(Posicion p) {
		DaoPosicion crud = new DaoPosicion();
		
		crud.savePosicion(p);
		
		return p;

	}

	public Posicion traerPosicion(int idPosicion) {
		DaoPosicion crud = new DaoPosicion();
		return crud.findPosicion(idPosicion);
	}

	/*
	 * // trae la posicion del nombre y true public Posicion traerPosicion(String
	 * nombre, boolean adelantado) { DaoPosicion crud = new DaoPosicion();
	 * System.out.println("p1"); List<Posicion> p = crud.findTodasLasPosicion();
	 * System.out.println("p2"); return traerPosicionEnLista(p, nombre, adelantado);
	 * }
	 */
/*	// trae la posicion pero de la lista que le mandemos
	public Posicion traerPosicionEnLista(List<Posicion> listaPosicion, String nombre, boolean adelantado) {
		Posicion p = null;
		int index = 0;
		while (index < listaPosicion.size() && p == null) {
			if (listaPosicion.get(index).getNombre().equalsIgnoreCase(nombre)
					&& listaPosicion.get(index).isAtrasadoAdelantado() == adelantado) {
				p = listaPosicion.get(index);
			}
			index++;
		}
		return p;
	}
*/
	public List<Posicion> traerPosiciones() {
		DaoPosicion crud = new DaoPosicion();
		return crud.findTodasLasPosicion();

	}

	public void borrarPosicion(Posicion posicion) {
		DaoPosicion crud = new DaoPosicion();
		crud.borrarPosicion(posicion);
	}

	public void modificarPosicion(Posicion posicion) {
		DaoPosicion crud = new DaoPosicion();
		
			crud.modificarPosicion(posicion);
	
	}

}
