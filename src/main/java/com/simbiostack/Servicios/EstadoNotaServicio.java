package com.simbiostack.Servicios;

import com.simbiostack.Entidades.EstadoNota;
import com.simbiostack.Repositorios.EstadoNotaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoNotaServicio {
    @Autowired
    EstadoNotaRepositorio estadoNotaRepositorio;

    public EstadoNota getEstado(Integer id){
        return estadoNotaRepositorio.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el producto"));
    }

    public List<EstadoNota> mostrarEstados(){
        return estadoNotaRepositorio.findAll().stream().filter(estadoNota -> estadoNota.getId() > 2).toList();
    }

}
