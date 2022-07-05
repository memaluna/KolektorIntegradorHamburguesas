package edu.cursokolektor.proyectointegrador.bo;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Hamburguesa {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private Double precio;
	
	@ManyToMany
	@JoinTable(name="hamburguesa_ingrediente", 
	joinColumns=@JoinColumn(name="hamburguesa_id"),
	inverseJoinColumns=@JoinColumn(name="ingrediente_id"))
	private Set<Ingrediente> ingredientes;

	//Constructores
	public Hamburguesa() {
		super();
	}

	public Hamburguesa(Long id, String nombre, Double precio, Set<Ingrediente> ingredientes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.ingredientes = ingredientes;
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

	//generar hashcode y equals de id
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
		Hamburguesa other = (Hamburguesa) obj;
		return Objects.equals(id, other.id);
	}

	//toString
	@Override
	public String toString() {
		return "Hamburguesa [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", ingredientes=" + ingredientes
				+ "]";
	}  
	
	
	
}
