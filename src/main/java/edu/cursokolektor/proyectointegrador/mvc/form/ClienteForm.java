package edu.cursokolektor.proyectointegrador.mvc.form;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;

public class ClienteForm {
	
	private Long id;
	
	@NotBlank
	private String nombre;
	private String telefono;
	private String direccion;
	private String email;
	private LocalDate fechaAlta;
	
	public ClienteForm() {
		super();
		this.fechaAlta = LocalDate.now();
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
	
	@Override
	public String toString() {
		return "ClienteForm [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion
				+ ", email=" + email + ", fechaAlta=" + fechaAlta + "]";
	}
	
}
