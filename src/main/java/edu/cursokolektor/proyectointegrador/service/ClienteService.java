package edu.cursokolektor.proyectointegrador.service;

import java.util.List;
import edu.cursokolektor.proyectointegrador.bo.Cliente;

public interface ClienteService {
	
	List<Cliente> recuperarClientes();
	Cliente buscarClientePorId(Long id);
	Long guardarNuevoCliente(Cliente cliente);
	void actualizarCliente(Cliente cliente);
	void borrarClientePorId(Long id);

}
