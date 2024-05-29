package com.simbiostack.Controladores;

import com.simbiostack.Entidades.Notita;
import com.simbiostack.Entidades.Response;
import com.simbiostack.Servicios.NotitaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/notitas")
public class ControladorNotita {
    @Autowired
    NotitaServicio notitaServicio;

    @GetMapping(path = "/mostrar")
    private List<Notita> mostrarNotitas(){
        return notitaServicio.obtenerNotitas();
    }

    @PostMapping(path = "/agregar")
    private Notita agregar(@RequestParam String descripcion){
        return notitaServicio.agregarNotita(descripcion);
    }

    @PostMapping(path = "/editar/{id}")
    private Notita editar(@PathVariable Integer id, @RequestParam String descripcion){
        return notitaServicio.editarNotita(id, descripcion);
    }

    @PostMapping(path = "/eliminar/{id}")
    private Response eliminar(@PathVariable Integer id){
        return notitaServicio.eliminarNotita(id);
    }
}
