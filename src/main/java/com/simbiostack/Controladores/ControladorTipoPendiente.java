package com.simbiostack.Controladores;

import com.simbiostack.Entidades.TipoPendiente;
import com.simbiostack.Servicios.TipoPendienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/tipos-pendientes")
public class ControladorTipoPendiente {
    @Autowired
    TipoPendienteServicio tipoPendienteServicio;

    @GetMapping(path = "/mostrar")
    public List<TipoPendiente> mostrar(){
        return tipoPendienteServicio.mostrarTiposPendiente();
    }
}
