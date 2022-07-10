package edu.cursokolektor.proyectointegrador.mvc.form;

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
	
}
