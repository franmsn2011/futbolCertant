package com.example.demo.controller;

import java.util.ArrayList;
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
		// HttpServletRequest request
		ModelAndView mav = new ModelAndView("list");
		List<PosicionAdapter> list= new ArrayList<PosicionAdapter>();
		List<Posicion> listPos=posicionService.listAllPosicion();
		Posicion aux= new Posicion();
		
		for (int i = 0; i < listPos.size(); i++) {
			aux = listPos.get(i);
			String e = "Ninguno";
			if(aux.isAtrasadoAdelantado()==true) {
				e="Si";
			}else {
				e="No";
			}
			
			list.add(new PosicionAdapter(aux.getIdPosicion(),aux.getNombre(),e));
		}
		
		
		mav.addObject("posiciones", list);
		mav.addObject("poss", new Posicion());
		return mav;
	}

	@GetMapping("/new/")
	public String agregar(Model model) {
		model.addAttribute("posicion", new Posicion());
		return "formPos";
	}

	@GetMapping("/new/{excepcion}")
	public String agregarex(@PathVariable String excepcion, Model model) {
		model.addAttribute("posicion", new Posicion());
		model.addAttribute("excepcion", excepcion);
		return "formPos";
	}

	@PostMapping("/seve")
	public String save(@Validated Posicion p, Model model) {
		try {
			posicionService.addPosicion(p);
		} catch (Exception e) {
			System.out.println(e.getClass().toString());
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
