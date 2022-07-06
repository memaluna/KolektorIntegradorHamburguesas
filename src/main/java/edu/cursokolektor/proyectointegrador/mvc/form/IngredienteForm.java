package edu.cursokolektor.proyectointegrador.mvc.form;

import javax.validation.constraints.NotBlank;

public class IngredienteForm {

	private Long id;
	@NotBlank
	private String nombre;
	private Long stock;
	
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
	public Long getStock() {
		return stock;
	}
	public void setStock(Long stock) {
		this.stock = stock;
	}
	
	
}
