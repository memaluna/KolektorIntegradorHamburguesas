package edu.cursokolektor.proyectointegrador.rest.dto;

import java.time.LocalDate;

import edu.cursokolektor.proyectointegrador.bo.Cliente;

public class ClienteDTO {

	private Long id;
	private String nombre;
	private String telefono;
	private String direccion;
	private String email;
	private LocalDate fechaAlta;
	
	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nombre = cliente.getNombre();
		this.telefono = cliente.getTelefono();
		this.direccion = cliente.getDireccion();
		this.email = cliente.getEmail();
		this.fechaAlta = cliente.getFechaAlta();
	}

	public ClienteDTO() {
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
}
