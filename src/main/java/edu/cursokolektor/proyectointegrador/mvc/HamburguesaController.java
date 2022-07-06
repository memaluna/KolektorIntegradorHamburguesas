package edu.cursokolektor.proyectointegrador.mvc;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.curso.java.spring.proyectospring.bo.Producto;
import edu.cursokolektor.proyectointegrador.bo.*;
import edu.cursokolektor.proyectointegrador.mvc.form.HamburguesaForm;
import edu.cursokolektor.proyectointegrador.mvc.form.IngredienteForm;
import edu.cursokolektor.proyectointegrador.repository.IngredienteRepository;
import edu.cursokolektor.proyectointegrador.service.HamburguesaService;
import edu.cursokolektor.proyectointegrador.service.IngredienteService;

@Controller
@RequestMapping("/hamburguesas")
public class HamburguesaController {
	
	private static  Logger log = LoggerFactory.getLogger(HamburguesaController.class);
	
	@Autowired
	private HamburguesaService hamburguesaService;
	
	@Autowired
	private IngredienteService ingredienteService;
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		this.cargarIngredientes(model);
		model.addAttribute("hamburguesaForm", new HamburguesaForm());
		return "/hamburguesas/form";
	}
	
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

		/*
		 * if(bindingResult.hasErrors()) { this.cargarCategorias(model);
		 * model.addAttribute("productoForm", productoForm); return "/productos/form"; }
		 */
		
		Ingrediente ingrediente = null;
		Long idIngrediente = ingredienteForm.getId();
		
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
				log.error("Error al gurdar un nuevo producto", e.getMessage());
				return "redirect:/error";
			}

		} else {
			//productoService.actualizarProducto(producto);
		}

		return "redirect:/hamburguesas/ingrediente/nuevo";
	}
	
	@GetMapping("/listaringredientes")
	public String listar(Model model) {
		List<Ingrediente> ingredientes = ingredienteService.recuperarIngredientes();
		model.addAttribute("ingredientes", ingredientes);
		return "/hamburguesas/listarIngredientes";
	}
}
