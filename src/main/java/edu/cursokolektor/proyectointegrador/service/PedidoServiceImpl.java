package edu.cursokolektor.proyectointegrador.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.cursokolektor.proyectointegrador.bo.Pedido;
import edu.cursokolektor.proyectointegrador.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService{

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public List<Pedido> recuperarPedido() {
		return pedidoRepository.findAllByOrderById();
	}

	@Override
	public Pedido buscarPedidoPorId(Long id) {
		Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
		return pedidoOptional.get();
	}

	@Override
	public Long guardarNuevoPedido(Pedido pedido) {
		pedidoRepository.save(pedido);
		return pedido.getId();
	}

	@Override
	public void actualizarPedido(Pedido pedido) {
		pedidoRepository.save(pedido);	
	}

	@Override
	public void borrarPedidoPorId(Long id) {
		pedidoRepository.deleteById(id);
	}

}
