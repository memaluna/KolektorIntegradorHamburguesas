package edu.cursokolektor.proyectointegrador.rest.dto;

public class IngredienteDTO {

	private Long id;
	private String nombre;
	private Long stock;
	
	public IngredienteDTO(Long id, String nombre, Long stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.stock = stock;
	}

	public IngredienteDTO() {
		super();
	}

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
