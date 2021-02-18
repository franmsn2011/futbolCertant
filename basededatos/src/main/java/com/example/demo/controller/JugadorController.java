package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repository.JugadorRespository;
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

}
