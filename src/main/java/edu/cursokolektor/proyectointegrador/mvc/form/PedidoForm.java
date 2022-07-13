package edu.cursokolektor.proyectointegrador.mvc.form;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;

import edu.cursokolektor.proyectointegrador.bo.Cliente;
import edu.cursokolektor.proyectointegrador.bo.Hamburguesa;

public class PedidoForm {

	private Long id;
	
	private List<Hamburguesa> hamburguesas;
	private Cliente cliente;
	
	@NotBlank
	private Boolean pagado;
	@NotBlank
	private Boolean entregado;
	private LocalDate fechaAlta;
	private LocalDate fechaEntrega;
	private Long totalPrecio;
	private String direccionEntrega;
	
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
	@Override
	public String toString() {
		return "PedidoForm [id=" + id + ", hamburguesas=" + hamburguesas + ", cliente=" + cliente + ", pagado=" + pagado
				+ ", entregado=" + entregado + ", fechaAlta=" + fechaAlta + ", fechaEntrega=" + fechaEntrega
				+ ", totalPrecio=" + totalPrecio + ", direccionEntrega=" + direccionEntrega + "]";
	}
	
	
	
}
