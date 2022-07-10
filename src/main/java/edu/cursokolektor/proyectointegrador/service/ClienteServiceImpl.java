package edu.cursokolektor.proyectointegrador.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.cursokolektor.proyectointegrador.bo.Cliente;
import edu.cursokolektor.proyectointegrador.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> recuperarClientes() {
		return clienteRepository.findAllByOrderById();
	}

	@Override
	public Cliente buscarClientePorId(Long id) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		return clienteOptional.get();
	}

	@Override
	public Long guardarNuevoCliente(Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente.getId();
	}

	@Override
	public void actualizarCliente(Cliente cliente) {
		clienteRepository.save(cliente);		
	}

	@Override
	public void borrarClientePorId(Long id) {
		clienteRepository.deleteById(id);	
	}

}
