package com.sv.tripElSalvadorApp.service;

import java.util.List;

import com.sv.tripElSalvadorApp.model.Trip;

// Interfaz que hace posible el patrón de inyección de dependencias
public interface ITripService {
    List<Trip> buscarTodos();
    Trip buscarPorId(Integer idTrip);
}
