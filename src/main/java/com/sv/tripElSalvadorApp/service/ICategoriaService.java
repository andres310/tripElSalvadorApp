package com.sv.tripElSalvadorApp.service;

import java.util.List;

import com.sv.tripElSalvadorApp.model.Categoria;

public interface ICategoriaService {
    List<Categoria> buscarTodas();
    Categoria buscarPorId(Integer idCategoria);
    void guardar(Categoria categoria);
}
