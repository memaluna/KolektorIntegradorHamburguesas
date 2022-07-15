package edu.cursokolektor.proyectointegrador.mvc;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.cursokolektor.proyectointegrador.bo.*;
import edu.cursokolektor.proyectointegrador.mvc.form.ClienteForm;
import edu.cursokolektor.proyectointegrador.mvc.form.HamburguesaForm;
import edu.cursokolektor.proyectointegrador.mvc.form.IngredienteForm;
import edu.cursokolektor.proyectointegrador.mvc.form.PedidoForm;
import edu.cursokolektor.proyectointegrador.service.ClienteService;
import edu.cursokolektor.proyectointegrador.service.HamburguesaService;
import edu.cursokolektor.proyectointegrador.service.IngredienteService;
import edu.cursokolektor.proyectointegrador.service.PedidoService;

@Controller
@RequestMapping("/hamburguesas")
public class HamburguesasController {
	
	private static  Logger log = LoggerFactory.getLogger(HamburguesasController.class);
	
	@Autowired
	private HamburguesaService hamburguesaService;
	
	@Autowired
	private IngredienteService ingredienteService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private PedidoService pedidoService;
	
	//ingredientes--------------------------------->
	
	private void cargarIngredientes(Model model) {
		List<Ingrediente> ingredientes = ingredienteService.recuperarIngredientes();
		model.addAttribute("ingredientes", ingredientes);
	}
	
	@GetMapping("/ingrediente/nuevo")
	public String nuevoIngrediente(Model model) {
		this.cargarIngredientes(model);
		model.addAttribute("ingredienteForm", new IngredienteForm());
		return "/hamburguesas/formIngrediente";
	}

	@PostMapping("/ingredientes/guardar")
	public String guardar(@Valid @ModelAttribute(name = "ingredienteForm") IngredienteForm ingredienteForm, BindingResult bindingResult, Model model) {

		
		log.info("Ejecutando el guardar: " + bindingResult.hasErrors());
		if(bindingResult.hasErrors()) {
			model.addAttribute("ingredienteForm", ingredienteForm);
			return "/hamburguesas/formIngrediente";
		}
		
		Ingrediente ingrediente = null;
		Long idIngrediente = ingredienteForm.getId();
		System.out.println("estado id " + idIngrediente);
		if(idIngrediente == null) {
			ingrediente = new Ingrediente();
		} else {
			ingrediente = ingredienteService.buscarIngredientePorId(idIngrediente);
		}
		
		ingrediente.setNombre(ingredienteForm.getNombre());
		ingrediente.setStock(ingredienteForm.getStock());

		if(idIngrediente == null) {
			try {
				ingredienteService.guardarNuevoIngrediente(ingrediente);
			} catch (Exception e) {
				log.error("Error al gurdar un nuevo ingrediente", e.getMessage());
				return "redirect:/error";
			}

		} else {
			ingredienteService.actualizarIngrediente(ingrediente);
		}

		return "redirect:/hamburguesas/ingredientes";
	}
	
	@GetMapping("/ingredientes")
	public String listarIngrediente(Model model) {
		List<Ingrediente> ingredientes = ingredienteService.recuperarIngredientes();
		model.addAttribute("ingredientes", ingredientes);
		return "/hamburguesas/listarIngredientes";
	}
	
	@GetMapping("/ingredientes/{id}/editar")
	public String editar(Model model, @PathVariable Long id) {
		Ingrediente ingrediente = ingredienteService.buscarIngredientePorId(id);
		System.out.println(ingrediente);
		IngredienteForm ingredienteForm = new IngredienteForm();
		ingredienteForm.setId(ingrediente.getId());
		ingredienteForm.setNombre(ingrediente.getNombre());
		ingredienteForm.setStock(ingrediente.getStock());

		model.addAttribute("ingredienteForm", ingredienteForm);
		return "/hamburguesas/formIngrediente";
	}
	
	@GetMapping("ingrediente/{id}/borrar")
	public String borrar(Model model, @PathVariable Long id) {
		ingredienteService.borrarIngredientePorId(id);
		return "redirect:/hamburguesas/ingredientes";
	}
	
	@GetMapping("/ingrediente/{id}")
	public String ver(Model model, @PathVariable Long id) {
		Ingrediente ingrediente = ingredienteService.buscarIngredientePorId(id);
		model.addAttribute("ingrediente", ingrediente);
		return "/hamburguesas/veringrediente";
	}
	
	//hamburguesa -------------------------->
	
	@GetMapping("/hamburguesa/nuevo")
	public String nuevo(Model model) {
		this.cargarIngredientes(model);
		model.addAttribute("hamburguesaForm", new HamburguesaForm());
		return "/hamburguesas/hamburguesaform";
	}
	
	@PostMapping("/hamburguesa/guardar")
	public String guardar(@Valid @ModelAttribute(name = "hamburguesaForm") HamburguesaForm hamburguesaForm, BindingResult bindingResult, Model model) {

		
		log.info("Ejecutando el guardar: " + bindingResult.hasErrors());
		if(bindingResult.hasErrors()) {
			model.addAttribute("hamburguesaForm", hamburguesaForm);
			return "/hamburguesas/hamburguesaform";
		}
		
		Hamburguesa hamburguesa = null;
		Long idHamburguesa = hamburguesaForm.getId();
		System.out.println("estado id " + idHamburguesa);
		if(idHamburguesa == null) {
			hamburguesa = new Hamburguesa();
		} else {
			hamburguesa = hamburguesaService.buscarHamburguesaPorId(idHamburguesa);
		}
		
		hamburguesa.setNombre(hamburguesaForm.getNombre());
		hamburguesa.setPrecio(hamburguesaForm.getPrecio());
		hamburguesa.setIngredientes(hamburguesaForm.getIngredientes());
		
		
		if(idHamburguesa == null) {
			try {
				hamburguesaService.guardarNuevaHamburguesa(hamburguesa);
			} catch (Exception e) {
				log.error("Error al gurdar un nuevo ingrediente", e.getMessage());
				return "redirect:/error";
			}

		} else {
			hamburguesaService.actualizarHamburguesa(hamburguesa);
		}

		return "redirect:/hamburguesas";
	}
	
	@GetMapping()
	public String listarHamburguesas(Model model) {
		List<Hamburguesa> hamburguesas= hamburguesaService.recuperarHamburguesas();
		model.addAttribute("hamburguesas", hamburguesas);
		return "/hamburguesas/listarHamburguesas";
	}
	
	@GetMapping("hamburguesa/{id}/borrar")
	public String borrarHamburguesa(Model model, @PathVariable Long id) {
		hamburguesaService.borrarHamburguesaPorId(id);
		return "redirect:/hamburguesas";
	}
	
	@GetMapping("/hamburguesa/{id}/editar")
	public String editarHamburguesa(Model model, @PathVariable Long id) {
		Hamburguesa hamburguesa = hamburguesaService.buscarHamburguesaPorId(id);
		System.out.println(hamburguesa);
		HamburguesaForm hamburguesaForm = new HamburguesaForm();
		hamburguesaForm.setId(hamburguesa.getId());
		hamburguesaForm.setNombre(hamburguesa.getNombre());
		hamburguesaForm.setPrecio(hamburguesa.getPrecio());
		hamburguesaForm.setIngredientes(hamburguesa.getIngredientes());
		
		this.cargarIngredientes(model);
		
		model.addAttribute("hamburguesaForm", hamburguesaForm);
		return "/hamburguesas/hamburguesaform";
	}
	
	@GetMapping("/hamburguesa/{id}")
	public String verHamburguesa(Model model, @PathVariable Long id) {
		Hamburguesa hamburguesa = hamburguesaService.buscarHamburguesaPorId(id);
		model.addAttribute("hamburguesa", hamburguesa);
		return "/hamburguesas/verhamburguesa";
	}
	
	//Cliente ---------------------------------------------------->
	
	@GetMapping("/cliente/nuevo")
	public String nuevoCliente(Model model) {
		model.addAttribute("clienteForm", new ClienteForm());
		System.out.println(model);
		return "/hamburguesas/clienteform";
	}
	
	@PostMapping("/cliente/guardar")
	public String guardarCliente(@Valid @ModelAttribute(name = "clienteForm") ClienteForm clienteForm, BindingResult bindingResult, Model model) {

		
		log.info("Ejecutando el guardar: " + bindingResult.hasErrors());
		if(bindingResult.hasErrors()) {
			model.addAttribute("clienteForm", clienteForm);
			return "/hamburguesas/clienteform";
		}
		
		Cliente cliente = null;
		Long idCliente = clienteForm.getId();
		System.out.println("estado id " + idCliente);
		if(idCliente == null) {
			cliente = new Cliente();
		} else {
			cliente = clienteService.buscarClientePorId(idCliente);
		}
		
		cliente.setNombre(clienteForm.getNombre());
		cliente.setTelefono(clienteForm.getTelefono());
		cliente.setDireccion(clienteForm.getDireccion());
		cliente.setEmail(clienteForm.getEmail());
		cliente.setFechaAlta(clienteForm.getFechaAlta());
		
		
		if(idCliente == null) {
			try {
				clienteService.guardarNuevoCliente(cliente);
			} catch (Exception e) {
				log.error("Error al gurdar un nuevo ingrediente", e.getMessage());
				return "redirect:/error";
			}

		} else {
			clienteService.actualizarCliente(cliente);
		}

		return "redirect:/hamburguesas/clientes";
	}
	
	@GetMapping("/clientes")
	public String listarClientes(Model model) {
		List<Cliente> clientes= clienteService.recuperarClientes();
		model.addAttribute("clientes", clientes);
		return "/hamburguesas/listarclientes";
	}
	
	@GetMapping("cliente/{id}/borrar")
	public String borrarCliente(Model model, @PathVariable Long id) {
		clienteService.borrarClientePorId(id);
		return "redirect:/hamburguesas/clientes";
	}
	
	@GetMapping("/cliente/{id}/editar")
	public String editarCliente(Model model, @PathVariable Long id) {
		Cliente cliente = clienteService.buscarClientePorId(id);
		System.out.println(cliente);
		ClienteForm clienteForm = new ClienteForm();
		clienteForm.setId(cliente.getId());
		clienteForm.setNombre(cliente.getNombre());
		clienteForm.setTelefono(cliente.getTelefono());
		clienteForm.setDireccion(cliente.getDireccion());
		clienteForm.setEmail(cliente.getEmail());
		clienteForm.setFechaAlta(cliente.getFechaAlta());
				
		model.addAttribute("clienteForm", clienteForm);
		return "/hamburguesas/clienteform";
	}
	
	@GetMapping("/cliente/{id}")
	public String verCliente(Model model, @PathVariable Long id) {
		Cliente cliente = clienteService.buscarClientePorId(id);
		model.addAttribute("cliente", cliente);
		return "/hamburguesas/vercliente";
	}
	
	// Pedido ------------------------------------------------------------------------>
	
	private void cargarHamburguesas(Model model) {
		List<Hamburguesa> hamburguesas = hamburguesaService.recuperarHamburguesas();
		model.addAttribute("hamburguesas", hamburguesas);
	}
	private void cargarClientes(Model model) {
		List<Cliente> clientes = clienteService.recuperarClientes();
		model.addAttribute("clientes", clientes);
	}
	
	@GetMapping("/pedido/nuevo")
	public String nuevoPedido(Model model) {
		this.cargarClientes(model);
		this.cargarHamburguesas(model);
		model.addAttribute("pedidoForm", new PedidoForm());
		System.out.println(model);
		return "/hamburguesas/pedidoform";
	}
	
	@PostMapping("/pedido/guardar")
	public String guardarPedido(@Valid @ModelAttribute(name = "pedidoForm") PedidoForm pedidoForm, BindingResult bindingResult, Model model) {
		
		System.out.println(pedidoForm);
		
		log.info("Ejecutando el guardar: " + bindingResult.hasErrors());
		if(bindingResult.hasErrors()) {
			model.addAttribute("pedidoForm", pedidoForm);
			return "/hamburguesas/pedidoform";
		}
		
		Pedido pedido = null;
		Long idPedido = pedidoForm.getId();
		System.out.println("estado id " + idPedido);
		if(idPedido == null) {
			pedido = new Pedido();
		} else {
			pedido = pedidoService.buscarPedidoPorId(idPedido);
		}
		
		pedido.setHamburguesas(pedidoForm.getHamburguesas());
		pedido.setCliente(pedidoForm.getCliente());
		pedido.setPagado(pedidoForm.getPagado());
		pedido.setEntregado(pedidoForm.getEntregado());
		pedido.setFechaAlta(pedidoForm.getFechaAlta());
		pedido.setFechaEntrega(pedidoForm.getFechaEntrega());
		pedido.setTotalPrecio(pedidoForm.getTotalPrecio());
		pedido.setDireccionEntrega(pedidoForm.getDireccionEntrega());
		
		
		
		if(idPedido == null) {
			try {
				pedidoService.guardarNuevoPedido(pedido);
			} catch (Exception e) {
				log.error("Error al gurdar un nuevo pedido", e.getMessage());
				return "redirect:/error";
			}

		} else {
			pedidoService.actualizarPedido(pedido);
		}

		return "redirect:/hamburguesas/clientes";
	}
}
