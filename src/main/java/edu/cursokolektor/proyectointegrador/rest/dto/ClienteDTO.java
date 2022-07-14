package edu.cursokolektor.proyectointegrador.rest.dto;

import java.time.LocalDate;

public class ClienteDTO {

	private Long id;
	private String nombre;
	private String telefono;
	private String direccion;
	private String email;
	private LocalDate fechaAlta;
	
	public ClienteDTO(Long id, String nombre, String telefono, String direccion, String email, LocalDate fechaAlta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
		this.fechaAlta = fechaAlta;
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
