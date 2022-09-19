package com.sv.tripElSalvadorApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sv.tripElSalvadorApp.model.Trip;
import com.sv.tripElSalvadorApp.service.ITripService;

@Controller
@RequestMapping("/trips")
public class TripController {

	@Autowired
	private ITripService servicesTrip;

	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idTrip, Model model) {
		System.out.println("idTrip es " + idTrip);
		model.addAttribute("id", idTrip);
		return "mensaje";
	}
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idTrip, Model model) {
		Trip trip = servicesTrip.buscarPorId(idTrip);
		System.out.println("Trip: " + trip);
		model.addAttribute("Trips" , trip);
		
		return "trips/detalle";
	}
}












