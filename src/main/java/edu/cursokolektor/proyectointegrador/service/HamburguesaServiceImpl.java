package edu.cursokolektor.proyectointegrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cursokolektor.proyectointegrador.bo.Hamburguesa;
import edu.cursokolektor.proyectointegrador.bo.Ingrediente;
import edu.cursokolektor.proyectointegrador.repository.HamburguesaRepository;
import edu.cursokolektor.proyectointegrador.repository.IngredienteRepository;

@Service
public class HamburguesaServiceImpl implements HamburguesaService{

	@Autowired
	private HamburguesaRepository hamburguesaRepository;
	
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	@Override
	public Long guardarNuevaHamburguesa(Hamburguesa hamburguesa) {
		hamburguesaRepository.save(hamburguesa);
		return hamburguesa.getId();
	}

	@Override
	public Hamburguesa buscarHamburguesaPorId(Long id) {
		Optional<Hamburguesa> hamburguesaOptional = hamburguesaRepository.findById(id);
		return hamburguesaOptional.get();
	}

	@Override
	public List<Hamburguesa> recuperarHamburguesas() {
		return hamburguesaRepository.findAllByOrderById();
	}

	@Override
	public List<Hamburguesa> buscarHamburguesas(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hamburguesa> buscarHamburguesas(String nombre, Double precio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrarHamburguesaPorId(Long id) {
		hamburguesaRepository.deleteById(id);		
	}

	@Override
	public void actualizarHamburguesa(Hamburguesa hamburguesa) {
		hamburguesaRepository.save(hamburguesa);
	}

}
