package edu.cursokolektor.proyectointegrador.service;

import java.util.List;

import edu.cursokolektor.proyectointegrador.bo.Ingrediente;

public interface IngredienteService {

	List<Ingrediente> recuperarIngredientes();
	Ingrediente buscarIngredientePorId(Long id);
	Long guardarNuevoIngrediente(Ingrediente ingrediente);
	void actualizarIngrediente(Ingrediente ingrediente);
	void borrarIngredientePorId(Long id);
}
