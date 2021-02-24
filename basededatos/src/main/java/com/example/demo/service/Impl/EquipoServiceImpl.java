package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Equipo;
import com.example.demo.excepcion.EquipoErrorDatosIguales;
import com.example.demo.excepcion.EquipoExistenteException;
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
		if (!equipoRepository.findById(equipo.getIdEquipo()).isEmpty()) {
			throw new EquipoExistenteException(
					"no se puede agregar esa equipo porque ya existe un equipo con ese id");

		}else {
			int index = 0;
			List<Equipo> list = equipoRepository.findAll();
			while (index < equipoRepository.findAll().size()) {
				if (list.get(index).getNombre().equalsIgnoreCase(equipo.getNombre())) {
					if (list.get(index).getDivision().equalsIgnoreCase(equipo.getDivision())) {					
					throw new EquipoErrorDatosIguales("No se puede agregar ese equipo porque ya hay un equipo con esos datos");
				
					}	
				}
				index++;
			}
		}
		return equipoRepository.saveAndFlush(equipo);
	}

	@Override
	public Optional<Equipo> listarId(int id) {
		return equipoRepository.findById(id);
	}

	@Override
	public void delete(int idEquipo) {
	equipoRepository.deleteById(idEquipo);
		
	}
	
	@Override
	@Modifying
	@Query("update EQUIPO e set e.division='juann' ,e.nombre = 'funciona' where  e.id_equipo ='15'")
	public void setUserInfoById(String nombre, String divicion, int id_equipo) {
	
		
	}
	
}
