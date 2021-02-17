package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Posicion;
import com.example.demo.repository.PosicionRepository;
import com.example.demo.service.PosicionService;

@Service("PosicionService")
public class PosicionServiceImpl implements PosicionService {
	
	@Autowired
	@Qualifier("posicionRepository")
	private PosicionRepository posicionRepository;
	@Override
	public List<Posicion> listAllPosicion() {
		
		return posicionRepository.findAll();
	}

	@Override
	public Posicion addPosicion(Posicion posicion) {
		
		return posicionRepository.save(posicion);
	}
	
	
	

}
