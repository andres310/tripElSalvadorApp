package com.sv.tripElSalvadorApp.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sv.tripElSalvadorApp.model.Categoria;

@Service
public class CategoriaServiceImpl implements ICategoriaService {
    private List<Categoria> lista = null;

    public CategoriaServiceImpl() {
        lista = new LinkedList<Categoria>();

        Categoria categoria1 = new Categoria();
        categoria1.setId(1);
        categoria1.setNombre("En la playa");
        categoria1.setDescripcion("Servicios de entretenimiento en la playa");

        Categoria categoria2 = new Categoria();
        categoria2.setId(2);
        categoria2.setNombre("En la ciudad");
        categoria2.setDescripcion("Clasificacion de trips en la ciudad");

        Categoria categoria3 = new Categoria();
        categoria3.setId(3);
        categoria3.setNombre("En la montaña");
        categoria3.setDescripcion("Interesantes actividades en la montaña");
        
        lista.add(categoria1);
        lista.add(categoria2);
        lista.add(categoria3);
    }

    @Override
    public Categoria buscarPorId(Integer idCategoria) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Categoria> buscarTodas() {
        return this.lista;
    }

    @Override
    public void guardar(Categoria categoria) {
        // TODO Auto-generated method stub
        
    }
    
}
