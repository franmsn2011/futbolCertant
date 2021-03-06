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
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Equipo;
import com.example.demo.service.EquipoService;
import com.example.demo.service.JugadorService;

@Controller
@RequestMapping("/equipo")
public class EquipoController {
	@Autowired
	@Qualifier("EquipoService")
	private EquipoService equipoService;

	@Autowired
	@Qualifier("JugadorService")
	private JugadorService jugadorService;

	@GetMapping({ "/", "", "/list" })
	public ModelAndView listAllEquipo() {
		ModelAndView mav = new ModelAndView("listEquipo");
		mav.addObject("equipos", equipoService.listAllEquipo());
		return mav;
	}

	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("equipo", new Equipo());
		return "formEquipo";
	}

	@PostMapping("/seve")
	public String seve(@Validated Equipo e, Model model) {
		try {
			equipoService.addEquipo(e);

		} catch (Exception e2) {
			model.addAttribute("excepcion", e2.getMessage());
			return "formEquipo";
		}
		return "redirect:/equipo/list/";
	}

	@GetMapping("/editar/{idEquipo}")
	public String editar(@PathVariable int idEquipo, Model model) {
		Optional<Equipo> equipo = equipoService.listarId(idEquipo);
		model.addAttribute("equipo", equipo);
		return "formEquipo";
	}

	@GetMapping("/eliminar/{idEquipo}")
	public String delete(Model model, @PathVariable int idEquipo) {
		//elimino el equipo de todos los jugadores que tengas este equipo
		jugadorService.EliminaEquipoDeJugadores(idEquipo);
		equipoService.delete(idEquipo);
		return "redirect:/equipo/list";
	}

}
