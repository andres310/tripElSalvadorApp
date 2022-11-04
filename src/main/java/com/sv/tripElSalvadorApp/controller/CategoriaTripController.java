package com.sv.tripElSalvadorApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sv.tripElSalvadorApp.model.Categoria;
import com.sv.tripElSalvadorApp.service.ICategoriaService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/categorias")
public class CategoriaTripController {

	@Autowired
	private ICategoriaService categoriaService;

	//@RequestMapping(value = "/index", method = RequestMethod.GET)
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Categoria> lista = categoriaService.buscarTodas();
		model.addAttribute("categorias", lista);
		return "categoriasTrip/listCategorias";
	}
	
	//@RequestMapping(value = "/create", method = RequestMethod.GET)
	@GetMapping("/create")
	public String crear() {
		
		return "categoriasTrip/formCategoria";
	}
	
	//@RequestMapping(value = "/save", method = RequestMethod.POST)
	@PostMapping("/save")
	public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return "trips/formCategoria";
		}

		System.out.println("Objeto categoria: " + categoria);
		categoriaService.guardar(categoria);
		attributes.addFlashAttribute("msg", "Registro guardado");

		return "categoriasTrip/listCategoria";
	}
}















