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

import com.example.demo.entity.Posicion;
import com.example.demo.service.PosicionService;

@RestController()
public class PosicionControllerRest {
	
	@Autowired
	@Qualifier("PosicionService")
	private PosicionService posicionService;
	@RequestMapping(value = "/posis", method = RequestMethod.GET)
	public String listAllPosiciones() {
		 JSONObject myObject = new JSONObject();
		 System.out.println("aaaaaaaaaaaaaaaaaaaaaa");
	        myObject.put("posiciones",posicionService.listAllPosicion() );
	        System.out.println(myObject.toString());
	        
	        
	   
		return myObject.toString();
	}
	
	@GetMapping("/traer/{idPosicion}")
	public Optional<Posicion> editar(@PathVariable int idPosicion, Model model) {
		Optional<Posicion>po=posicionService.listarId(idPosicion);
		return po;
	}
}
