package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.EquipoService;

@Controller
@RequestMapping("/equipo")
public class EquipoController {
	@Autowired
	@Qualifier("EquipoService")
	private EquipoService equipoService;
	
	@GetMapping({"/","","/list"})
	public ModelAndView listAllEquipo() {
		ModelAndView mav = new ModelAndView("listEquipo");
		mav.addObject("equipos",equipoService.listAllEquipo());
		return mav;
	}
	
}
