package edu.cursokolektor.proyectointegrador.bo;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class Ingrediente {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private Long stock;
	
	//constructores 
	public Ingrediente() {
		super();
	}
	
	public Ingrediente(Long id, String nombre, Long stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.stock = stock;
	}

	//getters y setters
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

	//hashcode y equals de id
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		return Objects.equals(id, other.id);
	}

	//ToString
	@Override
	public String toString() {
		return "Ingrediente [id=" + id + ", nombre=" + nombre + ", stock=" + stock + "]";
	}	
	
}
