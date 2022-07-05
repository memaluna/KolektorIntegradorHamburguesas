package edu.cursokolektor.proyectointegrador.rest.dto;

import java.util.Set;

import edu.cursokolektor.proyectointegrador.bo.Hamburguesa;
import edu.cursokolektor.proyectointegrador.bo.Ingrediente;

public class HamburguesaDTO {

	private Long id;
	private String nombre;
	private Double precio;
	private Set<Ingrediente> ingredientes;
	
	public HamburguesaDTO(Hamburguesa hamburguesa) {
		this.id = hamburguesa.getId();
		this.nombre = hamburguesa.getNombre();
		this.precio = hamburguesa.getPrecio();
		this.ingredientes = hamburguesa.getIngredientes();
	}

	public HamburguesaDTO() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Set<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Set<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	
}
