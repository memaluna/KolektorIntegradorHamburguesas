package edu.cursokolektor.proyectointegrador.service;

import java.util.List;
import edu.cursokolektor.proyectointegrador.bo.Pedido;

public interface PedidoService {

	List<Pedido> recuperarPedido();
	Pedido buscarPedidoPorId(Long id);
	Long guardarNuevoPedido(Pedido pedido);
	void actualizarPedido(Pedido pedido);
	void borrarPedidoPorId(Long id);
}
