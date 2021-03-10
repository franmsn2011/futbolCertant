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
		ModelAndView mav = new ModelAndView("listJugadores");
		mav.addObject("jugadores", listAllJugador(jugadorService.listAllJugador()));
		mav.addObject("posicion", posicionService);
		return mav;
	}

	@GetMapping("/verJugadores/{idPosicion}/{idEquipo}")
	public ModelAndView verJugadores2(@PathVariable int idPosicion, @PathVariable int idEquipo, Model model) {
		List<Jugador> listJuga = jugadorService.listarJugadoresxP(idPosicion, idEquipo);
		ModelAndView mav = new ModelAndView("jugadoresXposicion");
		mav.addObject("consultoPorEquipo", idPosicion==-1);
		mav.addObject("consultoPorPosicion", idEquipo == -1);
		mav.addObject("consultaPorUnoSolo", idEquipo == -1 || idPosicion == -1);
		mav.addObject("noTieneEquipoNiPosicion", idEquipo == 15 && idPosicion == 24);
		if(idPosicion!=-1) mav.addObject("nombrePosicion", posicionService.listarId(idPosicion).get().getNombre());
		if(idEquipo!=-1) mav.addObject("nombreEquipo", EquipoService.listarId(idEquipo).get().getNombre());
		mav.addObject("jugadores", listAllJugador(listJuga));
		return mav;
	}
	//tranformo una lista de jugadores en una lista de JugadorAdapter
	public List<JugadorAdapter> listAllJugador(List<Jugador> list) {
		return JugadorAdapter.createListOfAdapters(list);
	}
	//spring.jpa.hibernate.ddl-auto=update
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("jugador", new Jugador());
		return "formJugador";
	}

	@PostMapping("/seve")
	public String seve(@Validated Jugador j, Model model) {
		try {
			jugadorService.addJugador(j);
		} catch (Exception e) {
			model.addAttribute("exception", e.getMessage());
			return "formJugador";
		}
		return "redirect:/jugador/list/";
	}

	@GetMapping("/editar/{idJugador}")
	public String editar(@PathVariable int idJugador, Model model) {
		Optional<Jugador> jugador = jugadorService.listarId(idJugador);
		model.addAttribute("jugador", jugador);
		return "formJugador";
	}

	@GetMapping("/eliminar/{idJugador}")
	public String delete(Model model, @PathVariable int idJugador) {
		jugadorService.delete(idJugador);
		return "redirect:/jugador/list";
	}

	@GetMapping("/traerJEP")
	public String agegar2(Model model) {
		model.addAttribute("jugador", new Jugador());
		return "formEP";
	}

	@PostMapping("/formEP")
	public String formEP(@Validated Jugador j) {
		return "redirect:/jugador/verJugadores/" + j.getPosicion() + "/" + j.getEquipo();
	}

}
