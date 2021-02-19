package com.example.demo.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.PosicionService;

@RestController("/posicion")
public class PosicionControllerRest {
	
	@Autowired
	@Qualifier("PosicionService")
	private PosicionService posicionService;
	@GetMapping("/listaa")
	public JSONObject listAllPosiciones() {
		 JSONObject myObject = new JSONObject();
	        myObject.put("extra_data",posicionService.listAllPosicion() );
	        System.out.println(myObject.toString());
		/*ObjectMapper objectMapper = new ObjectMapper();
		String usuarioJson="nada";
		try {
			usuarioJson = objectMapper.writeValueAsString(new Posicion(3,"asd",true));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}*/
		return myObject;
	}
}
