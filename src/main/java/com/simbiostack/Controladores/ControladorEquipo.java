package com.simbiostack.Controladores;

import com.simbiostack.Entidades.Equipo;
import com.simbiostack.Entidades.Response;
import com.simbiostack.Servicios.EquipoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/equipos")
public class ControladorEquipo {
    @Autowired
    EquipoServicio equipoServicio;

    @PostMapping(path = "/agregar")
    public Equipo agregarEquipo(@RequestParam String tipo, @RequestParam String marca, @RequestParam String modelo, @RequestParam String color, @RequestParam String pass, @RequestParam String problema, @RequestParam String extras, @RequestParam Boolean cargador, @RequestParam Boolean funda, @RequestParam Boolean usb, @RequestParam Boolean cables, @RequestParam Integer cliente, @RequestParam Integer tipoPendiente){
        return equipoServicio.agregarEquipo(tipo, marca, modelo, color, pass, problema, extras, cargador, funda, usb, cables,cliente, tipoPendiente);
    }

    @GetMapping(path = "/mostrar")
    public Stream<Equipo> mostrarEquipos(){
        return equipoServicio.mostrarEquipos();
    }
}
