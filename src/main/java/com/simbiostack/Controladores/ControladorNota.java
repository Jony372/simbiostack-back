package com.simbiostack.Controladores;

import com.simbiostack.Entidades.Equipo;
import com.simbiostack.Entidades.Nota;
import com.simbiostack.Entidades.Response;
import com.simbiostack.Servicios.NotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/notas")
public class ControladorNota {

    @Autowired
    NotaServicio notaServicio;

    @PostMapping(path = "/agregar")
    public Nota agregarNota(@RequestParam Integer prioridad, @RequestParam Integer cliente, @RequestParam Integer usuario){
        return notaServicio.agregarNota(prioridad, cliente, usuario);
    }

    @GetMapping(path = "/mostrar")
    public Stream<Nota> mostrarNotas(){
        return notaServicio.mostrarNotas();
    }
    
    @GetMapping(path = "/get-nota/{id}")
    public Nota getNota(@PathVariable Integer id){
        return notaServicio.getNota(id);
    }

    @GetMapping(path = "/modificar-estado")
    public Response modificarEstado(@RequestParam Integer id ,@RequestParam Integer estado, @RequestParam Integer prioridad){
        Response res = new Response();
        res.setMensaje(notaServicio.modificarEstado(id, estado, prioridad));
        res.setTimestamp(LocalDateTime.now());
        res.setStatus(HttpStatus.OK.value());
        return res;
    }
    @GetMapping(path = "/notas-trabajando")
    public List<Integer> getNotasTrabajando(){
        return notaServicio.getNotasTrabajando();
    }

    @PostMapping(path = "/accion/{id}")
    public Response cambiarEstado(@PathVariable Integer id, @RequestParam Integer opcion){
        Response res = new Response();
        res.setMensaje(notaServicio.cambiarEstado(id, opcion));
        res.setStatus(HttpStatus.OK.value());
        res.setTimestamp(LocalDateTime.now());
        return res;
    }

}
