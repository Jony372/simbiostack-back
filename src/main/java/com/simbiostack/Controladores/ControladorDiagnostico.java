package com.simbiostack.Controladores;

import com.simbiostack.Entidades.Diagnostico;
import com.simbiostack.Servicios.DiagnosticoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "api/diagnostico")
public class ControladorDiagnostico {
    @Autowired
    DiagnosticoServicio diagnosticoServicio;

    @PostMapping(path = "/agregar")
    public Diagnostico agregarDiagnostico(@RequestParam String diagnostico, @RequestParam Integer equipo, @RequestParam Boolean pantallaRota, @RequestParam Boolean cargador, @RequestParam Boolean enciende, @RequestParam Boolean bisagras, @RequestParam  Integer ram, @RequestParam  String almacenamiento){
        return diagnosticoServicio.agregarDiagnostico(diagnostico, equipo, pantallaRota, cargador, enciende, bisagras, ram, almacenamiento);
    }

    @GetMapping(path = "/diagnosticos/{id}")
    public List<Diagnostico> obtenerDiagnosticosEquipo(@PathVariable Integer id){
        return diagnosticoServicio.obtenerDiagnosticoEquipo(id);
    }
}
