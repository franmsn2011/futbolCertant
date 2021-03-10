package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Equipo;
import com.example.demo.excepcion.DatosNull;
import com.example.demo.excepcion.EquipoErrorDatosIguales;
import com.example.demo.repository.EquipoRepository;
import com.example.demo.service.EquipoService;

@Service("EquipoService")
public class EquipoServiceImpl implements EquipoService {

	@Autowired
	@Qualifier("equipoRepository")
	private EquipoRepository equipoRepository;

	@Override
	public List<Equipo> listAllEquipo() {
		List<Equipo> list = equipoRepository.findAll();
		list.remove(new Equipo(15, "ninguno", "ninguna"));
		return list;
	}
	//utilizo la misma funcion para agregar y modificar
	@Override
	public Equipo addEquipo(Equipo equipo) {

		List<Equipo> list = listAllEquipo();
		int index = 0;
		boolean encontrado = false;
		//cargo una lista sin el equipo que quiero agregar/actualizar para buscar si ya esta
		while (index < list.size() && encontrado == false) {
			if (equipo.getIdEquipo() == list.get(index).getIdEquipo()) {
				list.remove(index);
				encontrado = true;
			}
			index++;
		}

		index = 0;
		//chequeo que no este en la base de datos
		while (index < list.size()) {
			if (list.get(index).getNombre().equalsIgnoreCase(equipo.getNombre())) {
				if (list.get(index).getDivision().equalsIgnoreCase(equipo.getDivision())) {
					throw new EquipoErrorDatosIguales(
							"No se puede agregar ese equipo porque ya hay un equipo con esos datos");

				}
			}
			index++;
		}
		//chequeo que no tenga datos null
		if(equipo.getDivision()==null ||equipo.getNombre()==null) {
			throw new DatosNull(
					"No se puede agregar ese equipo porque hay datos vacios");
	
		}
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
