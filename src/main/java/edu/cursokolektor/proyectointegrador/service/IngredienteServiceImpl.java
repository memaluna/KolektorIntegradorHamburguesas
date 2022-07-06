package edu.cursokolektor.proyectointegrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cursokolektor.proyectointegrador.bo.Ingrediente;
import edu.cursokolektor.proyectointegrador.repository.IngredienteRepository;

@Service
public class IngredienteServiceImpl implements IngredienteService{

	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	
	@Override
	public List<Ingrediente> recuperarIngredientes() {
		return ingredienteRepository.findAll();
	}

	@Override
	public Ingrediente buscarIngredientePorId(Long id) {
		Optional<Ingrediente> productoOptional = ingredienteRepository.findById(id);
		return productoOptional.get();
	}

	@Override
	public Long guardarNuevoIngrediente(Ingrediente ingrediente) {
		ingredienteRepository.save(ingrediente);
		return ingrediente.getId();
	}
	
}
