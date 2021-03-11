package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Jugador;
import com.example.demo.excepcion.DatosNull;
import com.example.demo.excepcion.EstadoCivilException;
import com.example.demo.excepcion.JugadorDniErroneo;
import com.example.demo.excepcion.JugadorEdadErronea;
import com.example.demo.excepcion.JugadorExistenteException;
import com.example.demo.repository.JugadorRespository;
import com.example.demo.service.JugadorService;

@Service("JugadorService")
public class JugadorServiceImpl implements JugadorService {

	@Autowired
	@Qualifier("jugadorRepository")
	private JugadorRespository jugadorRepository;

	@Override
	public List<Jugador> listAllJugador() {

		List<Jugador> list = jugadorRepository.findAll();
		return list;
	}

	@Override
	public Jugador addJugador(Jugador jugador) {
		//chequeo que no tenga datos null
		if(jugador.getEstadoCivil()==null ||jugador.getNombre()==null) {
			throw new DatosNull(
					"No se puede agregar ese jugador porque hay datos vacios");
	
		}
		//chequeo que entren bien desde el fronten
		if (jugador.getEstadoCivil().equalsIgnoreCase("Viudo") == true
				|| jugador.getEstadoCivil().equalsIgnoreCase("Divorciado") == true
				|| jugador.getEstadoCivil().equalsIgnoreCase("Soltero") == true
				|| jugador.getEstadoCivil().equalsIgnoreCase("Casado") == true) {
		} else {
			throw new EstadoCivilException("ERROR: El estado civil es invalido");

		}
		List<Jugador> listJugador=listAllJugador();
		int index=0;
		boolean encontrado=false;
		//creo una lista sin este jugador para poder corroborar el dni
		while(index<listJugador.size() && encontrado==false) {
		if(jugador.getIdjugador()==listJugador.get(index).getIdjugador()) {
				listJugador.remove(index);
				encontrado=true;
			}
		index++;
		}
		//tira excepcion si el dni de otro jugador esta en la lista
		for (int i = 0; i < listJugador.size(); i++) {
			if(jugador.getDni()==listJugador.get(i).getDni()) {
				throw new JugadorExistenteException("ERROR: El jugador con ese dni ya existe");
			}
		}
		//corroboro datos
		if(jugador.getEdad()<14 || jugador.getEdad()>100) {
			throw new JugadorEdadErronea("ERROR: El jugador con esa edad erronea");
		}
		if(jugador.getDni()>100000000 || jugador.getDni()<9999999) {
			throw new JugadorDniErroneo("ERROR: El jugador con esa edad erronea");
		}
		return jugadorRepository.save(jugador);
	}

	@Override
	public Optional<Jugador> listarId(int idJugador) {
		return jugadorRepository.findById(idJugador);
	}

	@Override
	public void delete(int idJugador) {
		jugadorRepository.deleteById(idJugador);

	}

	@Override
	public List<Jugador> listarJugadoresxP(int idPosicion, int idEquipo) {
		List<Jugador> list = new ArrayList<Jugador>();
		if (idPosicion != -1 && idEquipo != -1) {
			list = jugadorRepository.findByPosicionAndEquipo(idPosicion, idEquipo);
		} else {
			if (idPosicion == -1 && idEquipo != -1) {
				list = jugadorRepository.findByEquipo(idEquipo);
			} else if (idPosicion != -1 && idEquipo == -1) {
				list = jugadorRepository.findByPosicion(idPosicion);
			}
		}
		return list;
	}

	@Override
	public void EliminaEquipoDeJugadores(int idEquipo) {
		List<Jugador> listJugadores = listAllJugador();
		List<Jugador> listJugadoresAMdificar = new ArrayList<Jugador>();
		for (int i = 0; i < listJugadores.size(); i++) {
			if (listJugadores.get(i).getEquipo() == idEquipo) {
				listJugadoresAMdificar.add(listJugadores.get(i));
			}
		}
		Jugador aux;
		for (int j = 0; j < listJugadoresAMdificar.size(); j++) {
			aux = listJugadoresAMdificar.get(j);
			aux.setEquipo(15);
			addJugador(aux);
		}

	}

	@Override
	public void EliminaPosicionDeJugadores(int idPosicion) {
		List<Jugador> listJugadores = listAllJugador();
		List<Jugador> listJugadoresAMdificar = new ArrayList<Jugador>();
		for (int i = 0; i < listJugadores.size(); i++) {
			if (listJugadores.get(i).getPosicion() == idPosicion) {
				listJugadoresAMdificar.add(listJugadores.get(i));
			}
		}
		Jugador aux;
		for (int j = 0; j < listJugadoresAMdificar.size(); j++) {
			aux = listJugadoresAMdificar.get(j);
			// seteo la posicion del jugador a el id de de la posicion null
			aux.setPosicion(24);
			addJugador(aux);
		}

	}
}
