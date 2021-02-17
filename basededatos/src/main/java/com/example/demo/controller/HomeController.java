package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Posicion;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping({"/",""})
	public ModelAndView listAllPosicion() {
		ModelAndView mav= new ModelAndView("home");
		return mav;
	}
}
