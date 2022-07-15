package edu.cursokolektor.proyectointegrador.rest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.cursokolektor.proyectointegrador.bo.Cliente;
import edu.cursokolektor.proyectointegrador.rest.dto.ClienteDTO;
import edu.cursokolektor.proyectointegrador.service.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteRestController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/hamburguesas/clientes")
	public List<ClienteDTO> recuperarTodosLosClientes() {
		List<Cliente> clientes = clienteService.recuperarClientes();
		List<ClienteDTO> clienteDTO = new ArrayList<ClienteDTO>();
		for (Cliente cliente : clientes) {
			clienteDTO.add(new ClienteDTO(cliente));
		}
		return clienteDTO;
	}
	
	@GetMapping("/hamburguesas/cliente/{id}")
	public ResponseEntity<ClienteDTO> recuperarClientePorId(@PathVariable Long id){
		Cliente cliente = clienteService.buscarClientePorId(id);
		ClienteDTO clienteDTO = new ClienteDTO(cliente);
		return ResponseEntity.ok(clienteDTO);
	}

}
