package com.sv.tripElSalvadorApp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sv.tripElSalvadorApp.model.Trip;
import com.sv.tripElSalvadorApp.service.ITripService;

@Controller
public class HomeController {

	@Autowired
	private ITripService tripService;

	@GetMapping("/")
	public String motrarHome(Model model) {
		List<Trip> lista = tripService.buscarTodos();
		model.addAttribute("trips", lista);
		
		return "home";
	}
	
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		// Uso el servicio
		List<Trip> lista = tripService.buscarTodos();
		model.addAttribute("trips", lista);
		return "tabla";
	}
	


	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("En la Montaña");
		lista.add("En la Cuidad");
		lista.add("En los pueblos");
		lista.add("En las playas");
		model.addAttribute("listadoTrips", lista);
		
		return "listado";
	}

	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Trip trip = new Trip();
		trip.setNombre("Rapel en Volcatenango");
		trip.setDescripcion("Aventa rapel en un circuito conectado en las...");
		trip.setFecha(new Date());
		trip.setCosto(10.0);
		model.addAttribute("trip" , trip);
		
		return "detalle";
	}

	private List<Trip> getTrips(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyy");
		List<Trip> lista = new LinkedList<Trip>();
		try {
			Trip trip1 = new Trip();
			trip1.setId(1);
			trip1.setNombre("Rapel en Volcatenando");
			trip1.setDescripcion("Hacer rapel en los circuitos de Volcatenango");
			trip1.setFecha(sdf.parse("10-05-2022"));
			trip1.setCosto(5.0);
			trip1.setDestacado(1);
			trip1.setImagen("trip1.png");
			
			Trip trip2 = new Trip();
			trip2.setId(2);
			trip2.setNombre("Deslizadero en El picnic");
			trip2.setDescripcion("Deslizarte en un divertido tovogan sobre la colina");
			trip2.setFecha(sdf.parse("10-05-2022"));
			trip2.setCosto(5.0);
			trip2.setDestacado(1);
			trip2.setImagen("trip2.png");

			Trip trip3 = new Trip();
			trip3.setId(3);
			trip3.setNombre("Comida y Flores");
			trip3.setDescripcion("Disfrutar de un amplio jardin el cual podras comprar");
			trip3.setFecha(sdf.parse("10-05-2022"));
			trip3.setCosto(1.0);
			trip3.setDestacado(0);
			trip3.setImagen("trip3.png");

			Trip trip4 = new Trip();
			trip4.setId(4);
			trip4.setNombre("Caminatas");
			trip4.setDescripcion("Disfruta hacer senderismo por las montañas chalatecas");
			trip4.setFecha(sdf.parse("01-02-2022"));
			trip4.setCosto(10.0);
			trip4.setDestacado(1);

			lista.add(trip1);
			lista.add(trip2);
			lista.add(trip3);
			lista.add(trip4);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}


}





