package com.simbiostack.Servicios;

import com.simbiostack.Entidades.TipoPendiente;
import com.simbiostack.Repositorios.TipoPendienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoPendienteServicio {
    @Autowired
    TipoPendienteRepositorio tipoPendienteRepositorio;

    public TipoPendiente getTipoPendiente(Integer id){
        return tipoPendienteRepositorio.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el tipo de pendiente"));
    }

    public List<TipoPendiente> mostrarTiposPendiente(){
        return tipoPendienteRepositorio.findAll().stream().toList();
    }
}
