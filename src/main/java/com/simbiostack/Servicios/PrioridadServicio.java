package com.simbiostack.Servicios;

import com.simbiostack.Entidades.Prioridad;
import com.simbiostack.Repositorios.PrioridadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrioridadServicio {
    @Autowired
    PrioridadRepositorio prioridadRepositorio;

    public Prioridad getPrioridad(Integer id){
        return prioridadRepositorio.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el tipo de prioridad"));
    }

    public List<Prioridad> getPrioridades(){
        return prioridadRepositorio.findAll().stream().toList();
    }
}
