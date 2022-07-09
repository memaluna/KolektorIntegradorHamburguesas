package edu.cursokolektor.proyectointegrador.bo;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pedido {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany
	private List<Hamburguesa> hamburguesas;
	
	@OneToOne
	private Cliente cliente;
	
	private Boolean pagado;
	private Boolean entregado;
	
	public Pedido() {
		super();
	}

	public Pedido(Long id, List<Hamburguesa> hamburguesas, Cliente cliente, Boolean pagado, Boolean entregado) {
		super();
		this.id = id;
		this.hamburguesas = hamburguesas;
		this.cliente = cliente;
		this.pagado = pagado;
		this.entregado = entregado;
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

	@Override
	public int hashCode() {
		return Objects.hash(cliente, entregado, hamburguesas, id, pagado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(entregado, other.entregado)
				&& Objects.equals(hamburguesas, other.hamburguesas) && Objects.equals(id, other.id)
				&& Objects.equals(pagado, other.pagado);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", hamburguesas=" + hamburguesas + ", cliente=" + cliente + ", pagado=" + pagado
				+ ", entregado=" + entregado + "]";
	}
	
}
