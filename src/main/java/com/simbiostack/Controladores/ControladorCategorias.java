package com.simbiostack.Controladores;

import com.simbiostack.Entidades.Categoria;
import com.simbiostack.Entidades.Producto;
import com.simbiostack.Entidades.Response;
import com.simbiostack.Servicios.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/categorias")
public class ControladorCategorias {

    @Autowired
    CategoriaServicio categoriaServicio;

    @PostMapping(path = "/addCategoria")
    private Categoria addCategoria(@RequestParam String nombre, @RequestParam Integer stock){
        return categoriaServicio.addCategoria(nombre, stock);
    }

    @GetMapping(path = "/show")
    private List<Categoria> showCategorias(){
        return categoriaServicio.showCategorias();
    }

    @PostMapping(path = "/delete/{id}")
    private Response eliminarCategoria(@PathVariable Integer id){
        Response res = new Response();
        res.setMensaje(categoriaServicio.eliminarCategoria(id));
        res.setTimestamp(LocalDateTime.now());
        res.setStatus(HttpStatus.OK.value());
        return res;
    }

    @PostMapping(path = "/editar/{id}")
    private Categoria editarCategoria(@PathVariable Integer id, @RequestParam String nombre, @RequestParam Integer stock){
        return categoriaServicio.editarCategoria(id, nombre, stock);
    }

    @GetMapping(path = "/bajoStock")
    public List<Categoria> bajoStock(){
        return categoriaServicio.bajoStock();
    }
}
