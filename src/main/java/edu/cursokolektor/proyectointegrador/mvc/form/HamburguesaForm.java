package edu.cursokolektor.proyectointegrador.mvc.form;

import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import edu.cursokolektor.proyectointegrador.bo.Ingrediente;

public class HamburguesaForm {
	
	private Long id;
	@NotBlank
	private String nombre;
	
	@NotNull
	@Positive
	private Double precio;
	
	private List<Ingrediente> ingredientes;

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

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
}
