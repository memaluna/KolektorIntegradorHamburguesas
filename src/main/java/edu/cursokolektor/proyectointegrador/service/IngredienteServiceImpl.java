package edu.cursokolektor.proyectointegrador.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.cursokolektor.proyectointegrador.bo.Ingrediente;
import edu.cursokolektor.proyectointegrador.repository.IngredienteRepository;

@Service
@Transactional
public class IngredienteServiceImpl implements IngredienteService{

	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	
	@Override
	public List<Ingrediente> recuperarIngredientes() {
		return ingredienteRepository.findAllByOrderById();
	}

	@Override
	public Ingrediente buscarIngredientePorId(Long id) {
		Optional<Ingrediente> ingredienteOptional = ingredienteRepository.findById(id);
		return ingredienteOptional.get();
	}

	@Override
	public Long guardarNuevoIngrediente(Ingrediente ingrediente) {
		ingredienteRepository.save(ingrediente);
		return ingrediente.getId();
	}
	
	@Override
	public void actualizarIngrediente(Ingrediente ingrediente) {
		ingredienteRepository.save(ingrediente);	
	}

	@Override
	public void borrarIngredientePorId(Long id) {
		ingredienteRepository.deleteById(id);	
	}
}
