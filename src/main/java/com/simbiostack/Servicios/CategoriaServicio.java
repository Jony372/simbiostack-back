package com.simbiostack.Servicios;

import com.simbiostack.Entidades.Categoria;
import com.simbiostack.Entidades.Producto;
import com.simbiostack.Repositorios.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServicio {

    @Autowired
    CategoriaRepositorio categoriaRepositorio;

    public Categoria addCategoria(String nombre, Integer stock){
        Categoria cat = new Categoria();
        cat.setStock(stock);
        cat.setExistencias(0);
        cat.setNombre(nombre);
        categoriaRepositorio.save(cat);
        return cat;
    }

    public List<Categoria> showCategorias(){
        return categoriaRepositorio.findAll().stream().filter(cat -> cat.getId() > 1).toList();
    }

    public Categoria editarCategoria(Integer id, String nombre, Integer stock){
        Categoria cat = getCategoria(id);
        cat.setNombre(nombre);
        cat.setStock(stock);
        categoriaRepositorio.save(cat);
        return cat;
    }

    public String eliminarCategoria(Integer id){
        categoriaRepositorio.deleteById(id);
        return "Categoria eliminada";
    }

    public Categoria getCategoria(Integer id){
        return categoriaRepositorio.findById(id).orElseThrow(()->new RuntimeException("Categoria no encontrada"));
    }

    public List<Categoria> bajoStock(){
        return categoriaRepositorio.getBajoStock();
    }
}
