package com.simbiostack.Controladores;

import com.simbiostack.Entidades.Response;
import com.simbiostack.Servicios.NotaEquipoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/nota-equipo")
public class ControladorNotaEquipo {
    @Autowired
    NotaEquipoServicio notaEquipoServicio;

    @PostMapping(path = "agregar")
    public Response agregarNotaEquipo(@RequestParam Integer nota, @RequestParam Integer equipo){
        Response res = new Response();
        res.setMensaje(notaEquipoServicio.agregarNotaEquipo(nota, equipo));
        res.setTimestamp(LocalDateTime.now());
        res.setStatus(HttpStatus.OK.value());
        return res;
    }
}
