package edu.cursokolektor.proyectointegrador.mvc.form;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import edu.cursokolektor.proyectointegrador.bo.Cliente;
import edu.cursokolektor.proyectointegrador.bo.Hamburguesa;

public class PedidoForm {

	private Long id;
	
	private List<Hamburguesa> hamburguesas;
	private Cliente cliente;
	
	private Boolean pagado;
	private Boolean entregado;
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime fechaAlta;
	private LocalDateTime fechaEntrega;
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
	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public LocalDateTime getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(LocalDateTime fechaEntrega) {
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
