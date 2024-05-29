package com.simbiostack.Controladores;

import com.simbiostack.Entidades.Prioridad;
import com.simbiostack.Servicios.PrioridadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/prioridades")
public class ControladorPrioridad {
    @Autowired
    PrioridadServicio prioridadServicio;

    @GetMapping(path = "/mostrar")
    public List<Prioridad> getPrioridades(){
        return prioridadServicio.getPrioridades();
    }

    @GetMapping(path = "/get/{id}")
    public Prioridad getPrioridad(@PathVariable Integer id){
        return prioridadServicio.getPrioridad(id);
    }
}
