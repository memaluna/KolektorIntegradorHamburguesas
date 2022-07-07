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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.cursokolektor.proyectointegrador.bo.*;
import edu.cursokolektor.proyectointegrador.mvc.form.HamburguesaForm;
import edu.cursokolektor.proyectointegrador.mvc.form.IngredienteForm;
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
	public String listar(Model model) {
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
}
