package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Jugador;
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
		
		return jugadorRepository.save(jugador);
	}

	
	
}