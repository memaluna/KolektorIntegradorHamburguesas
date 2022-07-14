package edu.cursokolektor.proyectointegrador.rest.dto;

import java.time.LocalDate;
import java.util.List;
import edu.cursokolektor.proyectointegrador.bo.Cliente;
import edu.cursokolektor.proyectointegrador.bo.Hamburguesa;

public class PedidoDTO {
	
	private Long id;
	private List<Hamburguesa> hamburguesas;
	private Cliente cliente;
	private Boolean pagado;
	private Boolean entregado;
	private LocalDate fechaAlta;
	private LocalDate fechaEntrega;
	private Long totalPrecio;
	private String direccionEntrega;
	
	public PedidoDTO(Long id, List<Hamburguesa> hamburguesas, Cliente cliente, Boolean pagado, Boolean entregado,
			LocalDate fechaAlta, LocalDate fechaEntrega, Long totalPrecio, String direccionEntrega) {
		super();
		this.id = id;
		this.hamburguesas = hamburguesas;
		this.cliente = cliente;
		this.pagado = pagado;
		this.entregado = entregado;
		this.fechaAlta = fechaAlta;
		this.fechaEntrega = fechaEntrega;
		this.totalPrecio = totalPrecio;
		this.direccionEntrega = direccionEntrega;
	}

	public PedidoDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Hamburguesa> getHamburguesas() {
		return hamburguesas;
	}

	public void setHamburguesas(List<Hamburguesa> hamburguesas) {
		this.hamburguesas = hamburguesas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Boolean getPagado() {
		return pagado;
	}

	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}

	public Boolean getEntregado() {
		return entregado;
	}

	public void setEntregado(Boolean entregado) {
		this.entregado = entregado;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Long getTotalPrecio() {
		return totalPrecio;
	}

	public void setTotalPrecio(Long totalPrecio) {
		this.totalPrecio = totalPrecio;
	}

	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}
}
