package edu.cursokolektor.proyectointegrador.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import edu.cursokolektor.proyectointegrador.bo.Hamburguesa;
import edu.cursokolektor.proyectointegrador.rest.dto.HamburguesaDTO;
import edu.cursokolektor.proyectointegrador.service.HamburguesaService;

@RestController
@RequestMapping("/api")
public class HamburguesaRestController {

	private static  Logger log = LoggerFactory.getLogger(HamburguesaRestController.class);
	
	@Autowired
	private HamburguesaService hamburguesaService;
	
	@GetMapping("/hamburguesas")
	public List<HamburguesaDTO> recuperarTodosLasCategorias() {
		List<Hamburguesa> hamburguesas = hamburguesaService.recuperarHamburguesas();
		List<HamburguesaDTO> hamburguesasDTO = new ArrayList<HamburguesaDTO>();
		for (Hamburguesa hamburguesa : hamburguesas) {
			hamburguesasDTO.add(new HamburguesaDTO(hamburguesa));
		}
		return hamburguesasDTO;
	}
	
	@GetMapping("/hamburguesas/hamburguesa/{id}")
	public ResponseEntity<HamburguesaDTO> recuperarHamburguesaPorId(@PathVariable Long id){
		Hamburguesa hamburguesa = hamburguesaService.buscarHamburguesaPorId(id);
		HamburguesaDTO hamburguesaDTO = new HamburguesaDTO(hamburguesa);
		return ResponseEntity.ok(hamburguesaDTO);
	}
	
	@GetMapping("/hamburguesas/hamburguesa/buscar")
	public List<HamburguesaDTO> buscarHamburguesa(@RequestParam String nombre, @RequestParam(required = false) Double precio) {
		
		log.info("Param nombre: " + nombre + " Param precio: " + precio);
		List<Hamburguesa> hamburguesas = null;
		
		if(precio == null)
			hamburguesas = hamburguesaService.buscarHamburguesas(nombre);		
		else
			hamburguesas = hamburguesaService.buscarHamburguesas(nombre, precio);	

			
		List<HamburguesaDTO> hamburguesaDTO = new ArrayList<HamburguesaDTO>();
		for (Hamburguesa hamburguesa : hamburguesas) {
			hamburguesaDTO.add(new HamburguesaDTO(hamburguesa));
		}
		
		return hamburguesaDTO;
	}

}
