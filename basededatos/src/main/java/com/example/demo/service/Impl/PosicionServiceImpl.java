package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.Index;

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

		return posicionRepository.findAll();
	}

	@Override
	public Posicion addPosicion(Posicion posicion) {
		if (!posicionRepository.findById(posicion.getIdPosicion()).isEmpty()) {
			throw new PosicionExistenteException(
					"no se puede agregar esa posicion porque ya existe una posicion con ese id");

		} else {
			int index = 0;
			List<Posicion> list = posicionRepository.findAll();
			while (index < posicionRepository.findAll().size()) {
				if (list.get(index).getNombre().equalsIgnoreCase(posicion.getNombre())) {
					throw new PosicionNombreIgualException("No se puede poner un nombre con un nombre de otra posicion");
				}
				index++;
			}
		}
		return posicionRepository.save(posicion);
	}

	@Override
	public Optional<Posicion> listarId(int id) {
		return posicionRepository.findById(id);
	}

	@Override
	public void delete(int idPosicion) {
		posicionRepository.deleteById(idPosicion);

	}

	@Override
	public void setUserInfoById(String nombre, boolean activo, int id_Posicion) {
		// TODO Auto-generated method stub
		
	}

}
