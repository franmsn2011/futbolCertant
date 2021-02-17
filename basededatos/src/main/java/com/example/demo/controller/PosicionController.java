package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Posicion;
import com.example.demo.service.PosicionService;

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
		//request.setAttribute("posiciones", posicionService.listAllPosicion());
		//request.setAttribute("pos",new Posicion());
		return mav;
	}

	@PostMapping("/addpos")
	public String addPosicion(@ModelAttribute (name="pos")Posicion posicion) {
		posicionService.addPosicion(posicion);
		return "redirect:posicion/list";
	}
	
	
	
	
}
