package com.sv.tripElSalvadorApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sv.tripElSalvadorApp.model.Categoria;
import com.sv.tripElSalvadorApp.service.ICategoriaService;

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
	public String guardar(@RequestParam("nombre") String nombre
						, @RequestParam("descripcion") String descripcion) {
		System.out.println("Nombre Categoria: " + nombre);
		System.out.println("Descripcion: " + descripcion);
		return "categoriasTrip/listCategoria";
	}
}















