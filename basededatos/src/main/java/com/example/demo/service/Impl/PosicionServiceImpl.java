package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Posicion;
import com.example.demo.excepcion.DatosNull;
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
		List<Posicion> list = posicionRepository.findAll();
		list.remove(new Posicion(24, "Ninguno", false));
		return list;
	}

	@Override
	public Posicion addPosicion(Posicion posicion) {
		// chequeo que el nombre no este vacio
		if (posicion.getNombre() == null) {
			throw new DatosNull("No se puede agregar esa posicion porque hay datos vacios");

		}
		List<Posicion> list = listAllPosicion();
		int index = 0;
		boolean encontrado = false;
		// cargo una lista sin la posicion que quiero agregar/actualizar para buscar si
		// ya esta
		while (index < list.size() && encontrado == false) {
			if (posicion.getIdPosicion() == list.get(index).getIdPosicion()) {
				list.remove(index);
				encontrado = true;
			}
			index++;
		}
		index = 0;
		// chequeo si esta en la lista
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

}
