package maven_jpa.futbol.services;

import java.util.List;

import exception.JugadorExistenteException;
import maven_jpa.futbol.dao.DaoJugador;
import maven_jpa.futbol.entity.Jugador;

public class ServiceJugador {
	public Jugador agregarJugador(Jugador j) {
		DaoJugador crud = new DaoJugador();
		
			j=crud.saveJugador(j);
			
		return j;
	}

	public Jugador traerJugador(int dni) {
		DaoJugador crud = new DaoJugador();
		return crud.findUnJugador(dni);
	}
	
	public List<Jugador> traerJugadores() {
		DaoJugador crud = new DaoJugador();
		return crud.findTodasLosJugadores();
	}
	public void borrarJugador(Jugador jugador) {
		
		DaoJugador crud = new DaoJugador();
		crud.borrarJugador(jugador);
	}
	public void modificarJugador(Jugador jugador) {
		DaoJugador crud= new DaoJugador();
			crud.modificarJugador(jugador);
		
	}

}
