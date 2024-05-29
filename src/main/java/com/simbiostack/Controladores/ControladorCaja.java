package com.simbiostack.Controladores;

import com.simbiostack.Entidades.Caja;
import com.simbiostack.Entidades.Response;
import com.simbiostack.Servicios.CajaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/caja")
@CrossOrigin("*")
public class ControladorCaja {
    @Autowired
    CajaServicio cajaServicio;

    @PostMapping(path = "/agregar")
    public Caja agregarCaja(@RequestParam Float dinInicial){
        return cajaServicio.addCaja(dinInicial);
    }

    @GetMapping(path = "/caja-actual")
    public Caja getCajaActual(){
        return cajaServicio.getCajaActual();
    }
}
