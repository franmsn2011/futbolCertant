package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Equipo;
import com.example.demo.entity.Jugador;
import com.example.demo.service.JugadorService;

@Controller
@RequestMapping("/jugador")
public class JugadorController {
	@Autowired
	@Qualifier("JugadorService")
	private JugadorService jugadorService;
	
	
	@GetMapping("/list")
	public ModelAndView listAllJugador() {
		ModelAndView mav =new ModelAndView("listJugadores");
		mav.addObject("jugadores",jugadorService.listAllJugador());
		
		return mav;
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {		
		model.addAttribute("jugador", new Jugador());
		return "formJugador";
	}
	@PostMapping("/seve")
	public String seve(@Validated Jugador j,Model model) {
		jugadorService.addJugador(j);
		return "redirect:/jugador/list/";
	}
	@GetMapping("/editar/{dni}")
	public String editar(@PathVariable int dni,Model model) {
		Optional<Jugador> jugador=jugadorService.listarId(dni);
		model.addAttribute("jugador", jugador);
		return "formJugador";
	}
	@GetMapping("/eliminar/{dni}")
	public String delete(Model model,@PathVariable int dni) {
		jugadorService.delete(dni);
		return "redirect:/jugador/list";
	}
	
	
	
}
