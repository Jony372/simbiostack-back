package com.simbiostack.Servicios;

import com.simbiostack.Entidades.Diagnostico;
import com.simbiostack.Repositorios.DiagnositcoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosticoServicio {
    @Autowired
    DiagnositcoRepositorio diagnositcoRepositorio;
    @Autowired
    EquipoServicio equipoServicio;

    public Diagnostico agregarDiagnostico(String diagnostico, Integer equipo, Boolean pantalla, Boolean cargador, Boolean enciende, Boolean bisagras, Integer ram, String almacenamiento){
        Diagnostico diagn = new Diagnostico();
        diagn.setDiagnostico(diagnostico);
        diagn.setEquipo(equipoServicio.getEquipo(equipo));
        diagn.setPantallaRota(pantalla);
        diagn.setCargador(cargador);
        diagn.setEnciende(enciende);
        diagn.setBisagras(bisagras);
        diagn.setRam(ram);
        diagn.setAlmacenamiento(almacenamiento);
        diagnositcoRepositorio.save(diagn);
        return diagn;
    }

    public List<Diagnostico> obtenerDiagnosticoEquipo(Integer id){
        return diagnositcoRepositorio.findAll().stream().filter(diag -> diag.getEquipo().getId().equals(id)).toList();
    }
}
