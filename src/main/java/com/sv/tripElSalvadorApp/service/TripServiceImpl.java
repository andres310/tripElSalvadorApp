package com.sv.tripElSalvadorApp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sv.tripElSalvadorApp.model.Trip;

// La anotación service vuelve a esta clase
// un Singleton, es decir, que solo tendrá una
// instancia en toda la aplicación
@Service
public class TripServiceImpl implements ITripService{

    List<Trip> lista = null;

    // Constructor sin retorno
    // Así funciona en la eyección de
    // dependencias
    public TripServiceImpl() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        lista = new LinkedList<Trip>();
        try {
            Trip trip1 = new Trip();
            trip1.setId(1);
            trip1.setNombre("Rapel en Volcatenado");
            trip1.setDescripcion("Hacer rapel en los circuitos de Volcatenango");
            trip1.setFecha(sdf.parse("10-05-2022"));
            trip1.setCosto(5.0);
            trip1.setDestacado(1);
            trip1.setImagen("trip1.png");

            Trip trip2 = new Trip();
            trip2.setId(2);
            trip2.setNombre("Deslizadero en El Picnic");
            trip2.setDescripcion("Deslizarse en el divertido tovogan sobre la colina");
            trip2.setFecha(sdf.parse("10-05-2022"));
            trip2.setCosto(5.0);
            trip2.setDestacado(1);
            trip2.setImagen("trip2.png");

            Trip trip3 = new Trip();
            trip3.setId(3);
            trip3.setNombre("Comida y Flores");
            trip3.setDescripcion("Disfrutar de un amplio jardin el cual podras comprar...");
            trip3.setFecha(sdf.parse("10-05-2022"));
            trip3.setCosto(1.0);
            trip3.setDestacado(1);
            trip3.setImagen("trip3.png");

            Trip trip4 = new Trip();
            trip4.setId(4);
            trip4.setNombre("Caminatas");
            trip4.setDescripcion("Disfrutar de hacer senderismo por las montañas de Chalatenango...");
            trip4.setFecha(sdf.parse("01-02-2022"));
            trip4.setCosto(1.0);
            trip4.setDestacado(0);

            lista.add(trip1);
            lista.add(trip2);
            lista.add(trip3);
            lista.add(trip4);

        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Trip buscarPorId(Integer idTrip) {
        for (Trip trip: lista)
            if (trip.getId() == idTrip)
                return trip;
        // Creo que esto se deberia cambiar
        // a retornar -1 o 0 pero no null
        return null;
    }

    @Override
    public List<Trip> buscarTodos() {
        return this.lista;
    }
    
    @Override
    public void guardar(Trip trip) {
        lista = buscarTodos();
        lista.add(trip);
    }
}
