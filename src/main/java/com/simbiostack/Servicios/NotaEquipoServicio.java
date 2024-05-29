package com.simbiostack.Servicios;

import com.simbiostack.Entidades.NotaEquipo;
import com.simbiostack.Repositorios.NotaEquipoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaEquipoServicio {
    @Autowired
    NotaEquipoRepositorio notaEquipoRepositorio;

    @Autowired
    EquipoServicio equipoServicio;
    @Autowired
    NotaServicio notaServicio;

    public String agregarNotaEquipo(Integer nota, Integer equipo){
        NotaEquipo notaEquipo = new NotaEquipo();
        notaEquipo.setEquipo(equipoServicio.getEquipo(equipo));
        notaEquipo.setNota(notaServicio.getNota(nota));
        notaEquipoRepositorio.save(notaEquipo);
        return "Se agrego la relacion";
    }

}
