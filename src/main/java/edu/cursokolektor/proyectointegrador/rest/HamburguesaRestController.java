package edu.cursokolektor.proyectointegrador.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cursokolektor.proyectointegrador.bo.Hamburguesa;
import edu.cursokolektor.proyectointegrador.repository.HamburguesaRepository;
import edu.cursokolektor.proyectointegrador.rest.dto.HamburguesaDTO;

@RestController
@RequestMapping("/api")
public class HamburguesaRestController {

	@Autowired
	private HamburguesaRepository hamburguesaRepository;
	
	@GetMapping("/hamburguesas")
	public List<HamburguesaDTO> recuperarTodosLasCategorias() {
		List<Hamburguesa> hamburguesas = hamburguesaRepository.findAll();
		List<HamburguesaDTO> hamburguesasDTO = new ArrayList<HamburguesaDTO>();
		for (Hamburguesa hamburguesa : hamburguesas) {
			hamburguesasDTO.add(new HamburguesaDTO(hamburguesa));
		}
		return hamburguesasDTO;
	}
	
	@GetMapping("/hamburguesas/{id}")
	public ResponseEntity<HamburguesaDTO> recuperarHamburguesaPorId(@PathVariable Long id){
		Hamburguesa hamburguesa = hamburguesaRepository.findById(id).get();
		HamburguesaDTO hamburguesaDTO = new HamburguesaDTO(hamburguesa);
		return ResponseEntity.ok(hamburguesaDTO);
	}
}
