package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.Index;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Posicion;
import com.example.demo.excepcion.PosicionExistenteException;
import com.example.demo.excepcion.PosicionNombreIgualException;
import com.example.demo.repository.PosicionRepository;
import com.example.demo.service.PosicionService;

@Service("PosicionService")
public class PosicionServiceImpl implements PosicionService {

	@Autowired
	@Qualifier("posicionRepository")
	private PosicionRepository posicionRepository;

	@Override
	public List<Posicion> listAllPosicion() {
		List<Posicion> list=posicionRepository.findAll();
		list.remove(new Posicion(24,"Ninguno",false));
		return list;
	}

	@Override
	public Posicion addPosicion(Posicion posicion) {
		int index = 0;
		List<Posicion> list =listAllPosicion();
		while (index < list.size()) {
			if (list.get(index).getNombre().equalsIgnoreCase(posicion.getNombre())) {
				if (list.get(index).isAtrasadoAdelantado() == posicion.isAtrasadoAdelantado()) {
					throw new PosicionNombreIgualException(
							"ya hay una posicion con esos datos, por favor intente otra ves");

				}
			}
			index++;
		}

		return posicionRepository.save(posicion);
	}

	@Override
	public Optional<Posicion> listarId(int idPosicion) {
		return posicionRepository.findById(idPosicion);
	}

	@Override
	public void delete(int idPosicion) {
		posicionRepository.deleteById(idPosicion);

	}

	@Override
	public void setUserInfoById(String nombre, boolean activo, int id_Posicion) {
		// TODO Auto-generated method stub

	}
/*
	@Override
	public Optional<Posicion> listarJugadoresPosicion(int idPosicion) {
		 Example<Posicion> example = new Example.of(new Posicion("delantero",true,1));

		    Optional<Posicion> actual = posicionRepository.findOne(example);
		return null;
	}*/

}
