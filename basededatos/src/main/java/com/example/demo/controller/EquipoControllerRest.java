package com.example.demo.controller;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Equipo;
import com.example.demo.service.EquipoService;

@RestController()
public class EquipoControllerRest {

	@Autowired
	@Qualifier("EquipoService")
	private EquipoService equipoService;

	@RequestMapping(value = "/equip", method = RequestMethod.GET)
	public String listAllEquipos() {
		JSONObject myObject = new JSONObject();
		myObject.put("equipos", equipoService.listAllEquipo());
		return myObject.toString();
	}

	@GetMapping("/traer/{idEquipo}")
	public String editar(@PathVariable int idEquipo, Model model) {
		Optional<Equipo> equipos = equipoService.listarId(idEquipo);
		return equipos.toString();
	}
}
