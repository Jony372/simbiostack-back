package com.simbiostack.Controladores;

import com.simbiostack.Entidades.EstadoNota;
import com.simbiostack.Servicios.EstadoNotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/estados-nota")
public class ControladorEstadoNota {
    @Autowired
    private EstadoNotaServicio estadoNotaServicio;

    @GetMapping(path = "/mostrar")
    public List<EstadoNota> mostrarEstadosNota() {
        return estadoNotaServicio.mostrarEstados();
    }
}
