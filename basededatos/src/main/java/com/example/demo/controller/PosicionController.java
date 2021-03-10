package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.demo.adapter.PosicionAdapter;
import com.example.demo.entity.Posicion;
import com.example.demo.service.JugadorService;
import com.example.demo.service.PosicionService;

@Controller
@RequestMapping("/posicion")
public class PosicionController {

	@Autowired
	@Qualifier("PosicionService")
	private PosicionService posicionService;
	@Autowired
	@Qualifier("JugadorService")
	private JugadorService jugadorService;

	@GetMapping({ "/", "", "/list" })
	public ModelAndView listAllPosicion() {
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("posiciones", listAllPosicion(posicionService.listAllPosicion()));
		mav.addObject("poss", new Posicion());
		return mav;
	}
	public List<PosicionAdapter> listAllPosicion(List<Posicion> list){
		return PosicionAdapter.createListOfAdapters(list);
	}
	
	@GetMapping("/new/")
	public String agregar(Model model) {
		model.addAttribute("posicion", new Posicion());
		return "formPos";
	}

	@PostMapping("/seve")
	public String save(@Validated Posicion p, Model model) {
		try {
			posicionService.addPosicion(p);
		} catch (Exception e) {
			model.addAttribute("excepcion", e.getMessage());
			return "formPos";
		}
		return "redirect:/posicion/";
	}

	@GetMapping("/editar/{idPosicion}")
	public String editar(@PathVariable int idPosicion, Model model) {
		Optional<Posicion> posicion = posicionService.listarId(idPosicion);
		model.addAttribute("posicion", posicion);
		return "formPos";
	}

	@GetMapping("/eliminar/{idPosicion}")
	public String delete(Model model, @PathVariable int idPosicion) {
		jugadorService.EliminaPosicionDeJugadores(idPosicion);
		posicionService.delete(idPosicion);
		return "redirect:/posicion/list";
	}

}
