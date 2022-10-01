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
        categoria1.setNombre("Caminatas");
        categoria1.setDescripcion("Caminar un rato");

        Categoria categoria2 = new Categoria();
        categoria2.setId(2);
        categoria2.setNombre("Categoria222222");
        categoria2.setDescripcion("Es la categoria 2");

        Categoria categoria3 = new Categoria();
        categoria3.setId(3);
        categoria3.setNombre("333categoria33");
        categoria3.setDescripcion("es la categoria 3!");
        
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
