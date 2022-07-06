package edu.cursokolektor.proyectointegrador.service;

import java.util.List;
import edu.cursokolektor.proyectointegrador.bo.Hamburguesa;
import edu.cursokolektor.proyectointegrador.bo.Ingrediente;

public interface HamburguesaService {

	Long guardarNuevaHamburguesa(Hamburguesa hamburguesa, Long idCategoria); //aca van a ir exepciones

	Hamburguesa buscarHamburguesaPorId(Long id);

	List<Hamburguesa> recuperarHamburguesas();

	List<Hamburguesa> buscarHamburguesas(String nombre);

	List<Hamburguesa> buscarHamburguesas(String nombre, Double precio);

	void borrarHamburguesaPorId(Long id);
	
	void actualizarHamburguesa(Hamburguesa Hamburguesa);
	
	//List<Ingrediente> recuperarIngredientes();
	
	//CategoriaHamburguesa buscarCategoriaHamburguesaPorId(Long id);

	//List<Hamburguesa> recuperarHamburguesasPorCategoria(Long id);
	
}
