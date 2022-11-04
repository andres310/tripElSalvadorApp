package com.sv.tripElSalvadorApp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.sv.tripElSalvadorApp.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sv.tripElSalvadorApp.model.Trip;
import com.sv.tripElSalvadorApp.service.ITripService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/trips")
public class TripController {

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@Autowired
	private ITripService servicesTrip;

	// Sirve para el formulario de creación para vincular las categorias
	@Autowired
	private ICategoriaService categoriaService;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Trip> lista = servicesTrip.buscarTodos();
		model.addAttribute("trips", lista);
		return "trips/listTrips";
	}

	@GetMapping("/create")
	public String crear(Trip trip ,Model model) {
		model.addAttribute("categorias", categoriaService.buscarTodas());
		return "trips/formTrip";
	}

	@PostMapping("/save")
	public String guardar(Trip trip, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return "trips/formTrip";
		}
		servicesTrip.guardar(trip);
		System.out.println("Trip: " + trip);
		attributes.addFlashAttribute("msg", "Registro Guardado");

		return "redirect:/trips/index";
	}

	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idTrip, Model model) {
		System.out.println("idTrip es " + idTrip);
		model.addAttribute("id", idTrip);
		return "mensaje";
	}
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idTrip, Model model) {
		Trip trip = servicesTrip.buscarPorId(idTrip);
		System.out.println("Id de Trip es: " + trip);
		model.addAttribute("trip" , trip);
		
		return "trips/detalle";
		// return "detalle";
	}
}












