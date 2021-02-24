package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
		if (!jugadorRepository.findById(jugador.getDni()).isEmpty()) {
			throw new JugadorExistenteException(
					"no se puede agregar ese jugador porque ya hay un jugador con ese dni");

		} else {
			int index = 0;
			List<Jugador> list = jugadorRepository.findAll();
			while (index < jugadorRepository.findAll().size()) {
				if (list.get(index).getIdjugador()==jugador.getIdjugador()) {
					throw new JugadorExistenteException("No se puede agregar este jugador porque ya hay otro con el id "+jugador.getIdjugador());
				}
				index++;
			}
			if (jugador.getEstadoCivil().equalsIgnoreCase("Viudo") == true
					|| jugador.getEstadoCivil().equalsIgnoreCase("Divorciado") == true
					|| jugador.getEstadoCivil().equalsIgnoreCase("Soltero") == true
					|| jugador.getEstadoCivil().equalsIgnoreCase("Casado") == true) {
			} else {
				throw new EstadoCivilException("ERROR: El estado civil es invalido");

			}
		}
		return jugadorRepository.save(jugador);
	}

	@Override
	public Optional<Jugador> listarId(int dni) {
		return jugadorRepository.findById(dni);
	}

	@Override
	public void delete(int dni) {
		jugadorRepository.deleteById(dni);
		
	}

	
	
}
