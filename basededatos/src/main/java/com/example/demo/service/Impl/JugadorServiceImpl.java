package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Jugador;
import com.example.demo.excepcion.EstadoCivilException;
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

		return jugadorRepository.findAll();
	}

	@Override
	public Jugador addJugador(Jugador jugador) {
		/*
		 * int index = 0; List<Jugador> list = jugadorRepository.findAll(); while (index
		 * < jugadorRepository.findAll().size()) { if (list.get(index).getIdjugador() ==
		 * jugador.getIdjugador()) { throw new JugadorExistenteException(
		 * "No se puede agregar este jugador porque ya hay otro con el id " +
		 * jugador.getIdjugador()); } index++; }
		 */
		if (jugador.getEstadoCivil().equalsIgnoreCase("Viudo") == true
				|| jugador.getEstadoCivil().equalsIgnoreCase("Divorciado") == true
				|| jugador.getEstadoCivil().equalsIgnoreCase("Soltero") == true
				|| jugador.getEstadoCivil().equalsIgnoreCase("Casado") == true) {
		} else {
			throw new EstadoCivilException("ERROR: El estado civil es invalido");

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
	// @Query("select * from JUGADOR J where J.POSICION = ?26 ")

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
//		Jugador jugador = new Jugador();
//		Example<Jugador> example;
//		ExampleMatcher ignoringExampleMatcher;
//
//		if (idEquipo == -1 || idPosicion == -1) {
//			if (idEquipo == -1) {
//				jugador.setPosicion(idPosicion);
//				ignoringExampleMatcher = ExampleMatcher.matchingAny().withIgnorePaths("id_jugador", "nombre", "dni",
//						"edad", "estadoCivil", "equipo");
//				example = Example.of(jugador, ignoringExampleMatcher);
//
//			} else {
//				jugador.setEquipo(idEquipo);
//
//				ignoringExampleMatcher = ExampleMatcher.matchingAny().withIgnorePaths("id_jugador", "nombre",
//						"estadoCivil", "dni", "edad", "posicion");
//				example = Example.of(jugador, ignoringExampleMatcher);
//
//			}
//		} else {
//
//			if (idPosicion == 0 && idEquipo == 0 || idPosicion != 0 && idEquipo != 0) {
//				if (idPosicion == 0 && idEquipo == 0) {
//
//					// jugador.setEquipo(15);
//					jugador.setPosicion(24);
//					ignoringExampleMatcher = ExampleMatcher.matchingAny().withIgnorePaths("id_jugador", "nombre", "dni",
//							"edad", "estadoCivil", "equipo");
//					example = Example.of(jugador, ignoringExampleMatcher);
//					System.out.println(jugadorRepository.findAll());
//					System.out.println(jugadorRepository.findAll(example));
//					System.out.println("-------------------");
//
//				} else {
//					jugador.setPosicion(idPosicion);
//					jugador.setEquipo(idEquipo);
//					ignoringExampleMatcher = ExampleMatcher.matchingAny().withIgnorePaths("idJugador", "nombre",
//							"estadoCivil", "dni", "edad");
//					System.out.println(ignoringExampleMatcher.getIgnoredPaths());
//					example = Example.of(jugador, ignoringExampleMatcher);
//
//				}
//
//			} else {
//				if (idEquipo != 0 && idPosicion == 0) {
//					jugador.setEquipo(idEquipo);
//					jugador.setPosicion(24);
//					ignoringExampleMatcher = ExampleMatcher.matchingAny().withIgnorePaths("id_jugador", "nombre",
//							"estadoCivil", "dni", "edad");
//					example = Example.of(jugador, ignoringExampleMatcher);
//				} else {
//					jugador.setEquipo(15);
//					jugador.setPosicion(idPosicion);
//					ignoringExampleMatcher = ExampleMatcher.matchingAny().withIgnorePaths("id_jugador", "nombre",
//							"estadoCivil", "dni", "edad");
//					example = Example.of(jugador, ignoringExampleMatcher);
//				}
//			}
//		}
//		return jugadorRepository.findAll(example);
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
