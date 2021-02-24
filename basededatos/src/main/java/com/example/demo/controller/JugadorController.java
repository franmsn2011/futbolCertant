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

import com.example.demo.adapter.JugadorAdapter;
import com.example.demo.entity.Jugador;
import com.example.demo.service.EquipoService;
import com.example.demo.service.JugadorService;
import com.example.demo.service.PosicionService;

@Controller
@RequestMapping("/jugador")
public class JugadorController {
	@Autowired
	@Qualifier("JugadorService")
	private JugadorService jugadorService;

	@Autowired
	@Qualifier("PosicionService")
	private PosicionService posicionService;
	
	@Autowired
	@Qualifier("EquipoService")
	private EquipoService EquipoService;
	
	
	@GetMapping("/list")
	public ModelAndView listAllJugador() {
		List<JugadorAdapter> listJugadorAdapter=new ArrayList<JugadorAdapter>();
		List<Jugador> listJugador=jugadorService.listAllJugador();
		Jugador aux=new Jugador();
		for(int i=0; i < listJugador.size() ; i++) {
			 aux=listJugador.get(i);
			 String e="Ninguno";
			 if(aux.getEquipo()!=0) {
				 e=EquipoService.listarId(aux.getEquipo()).get().getNombre();
			 }
			 String p="Ninguna";
			 if(aux.getPosicion()!=0) {
				 p=posicionService.listarId(aux.getPosicion()).get().getNombre();
			 }
			 listJugadorAdapter.add(new JugadorAdapter(aux.getIdjugador(),
					 aux.getNombre(),aux.getDni(),aux.getEdad(),
					 p,
					 aux.getEstadoCivil(),
					 e));
		}
		ModelAndView mav =new ModelAndView("listJugadores");
		mav.addObject("jugadores",listJugadorAdapter);
		mav.addObject("posicion", posicionService);
		return mav;
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {		
		model.addAttribute("jugador", new Jugador());
		return "formJugador";
	}
	@PostMapping("/seve")
	public String seve(@Validated Jugador j,Model model) {
		try {
			jugadorService.addJugador(j);
		} catch (Exception e) {
			model.addAttribute("exception", e.getMessage());
			return "formJugador";
		}
		
		return "redirect:/jugador/list/";
	}
	@GetMapping("/editar/{dni}")
	public String editar(@PathVariable int dni,Model model) {
		Optional<Jugador> jugador=jugadorService.listarId(dni);
		jugadorService.delete(dni);
		model.addAttribute("jugador", jugador);
		return "formJugador";
	}
	@GetMapping("/eliminar/{dni}")
	public String delete(Model model,@PathVariable int dni) {
		jugadorService.delete(dni);
		return "redirect:/jugador/list";
	}
	
	
	
}
