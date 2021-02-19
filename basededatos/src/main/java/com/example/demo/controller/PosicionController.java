package com.example.demo.controller;

import java.util.Optional;

import org.h2.util.New;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Posicion;
import com.example.demo.service.PosicionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/posicion")
public class PosicionController {

	@Autowired
	@Qualifier("PosicionService")
	private PosicionService posicionService;
	
	@GetMapping({"/","","/list"})
	public ModelAndView listAllPosicion() {
		//HttpServletRequest request
		ModelAndView mav= new ModelAndView("list");
		mav.addObject("posiciones",posicionService.listAllPosicion());
		mav.addObject("poss", new Posicion());
		return mav;
	}
	
	
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("posicion", new Posicion());
		return "formPos";
	}
	@PostMapping("/seve")
	public String save(@Validated Posicion p ,Model model) {
		posicionService.addPosicion(p);
		return "redirect:/posicion/";
	}
	@GetMapping("/editar/{idPosicion}")
	public String editar(@PathVariable int idPosicion, Model model) {
		Optional<Posicion>posicion=posicionService.listarId(idPosicion);
		model.addAttribute("posicion", posicion);
		return "formPos";
	}
	@GetMapping("/eliminar/{idPosicion}")
	public String delete(Model model,@PathVariable int idPosicion) {
		posicionService.delete(idPosicion);
		return "redirect:/posicion/list";
	}
	
	
}
