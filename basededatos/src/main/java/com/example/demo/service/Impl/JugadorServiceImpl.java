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
		int index = 0;
		List<Jugador> list = jugadorRepository.findAll();
		while (index < jugadorRepository.findAll().size()) {
			if (list.get(index).getIdjugador() == jugador.getIdjugador()) {
				throw new JugadorExistenteException(
						"No se puede agregar este jugador porque ya hay otro con el id " + jugador.getIdjugador());
			}
			index++;
		}*/
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
	//@Query("select * from JUGADOR J where J.POSICION = ?26 ")
 	
	public List<Jugador> listarJugadoresxP(int idPosicion,int idEquipo){
 		Jugador jugador= new Jugador();
 		Example<Jugador> example;
 		if(idEquipo==0) {
 		jugador.setPosicion(idPosicion);
 		 ExampleMatcher ignoringExampleMatcher = ExampleMatcher.matchingAny()
 			      .withIgnorePaths("id_jugador","nombre","estadoCivil","dni","edad","equipo");
 		example = Example.of(jugador,ignoringExampleMatcher);
 		}else {
 			jugador.setEquipo(idEquipo);
 	 		 ExampleMatcher ignoringExampleMatcher = ExampleMatcher.matchingAny()
 	 			 .withIgnorePaths("id_jugador","nombre","estadoCivil","dni","edad","posicion");
 	 	example = Example.of(jugador,ignoringExampleMatcher);
 		}
 		
 		return jugadorRepository.findAll(example);	
 	}

	@Override
	public void EliminaEquipoDeJugadores(int idEquipo) {
		List<Jugador> listJugadores= listAllJugador();
		List<Jugador> listJugadoresAMdificar=new ArrayList<Jugador>();
		for (int i =0; i<listJugadores.size(); i++) {
				if(listJugadores.get(i).getEquipo()==idEquipo) {
					listJugadoresAMdificar.add(listJugadores.get(i));
				}
			}
		Jugador aux;
		for (int j = 0; j < listJugadoresAMdificar.size(); j++) {
			aux=listJugadoresAMdificar.get(j);
			aux.setEquipo(15);
			addJugador(aux);
		}
		
	}
}
