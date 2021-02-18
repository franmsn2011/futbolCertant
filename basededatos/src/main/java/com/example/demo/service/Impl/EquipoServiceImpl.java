package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Equipo;
import com.example.demo.repository.EquipoRepository;
import com.example.demo.service.EquipoService;

@Service("EquipoService")
public class EquipoServiceImpl implements EquipoService {

	@Autowired
	@Qualifier("equipoRepository")
	private EquipoRepository equipoRepository;
	
	@Override
	public List<Equipo> listAllEquipo() {
		return equipoRepository.findAll();
	}

	@Override
	public Equipo addEquipo(Equipo equipo) {
		return equipoRepository.save(equipo);
	}

	@Override
	public Optional<Equipo> listarId(int id) {
		return equipoRepository.findById(id);
	}

	@Override
	public void delete(int idEquipo) {
	equipoRepository.deleteById(idEquipo);
		
	}
	
}
