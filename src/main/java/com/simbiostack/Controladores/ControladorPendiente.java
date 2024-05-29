package com.simbiostack.Controladores;

import com.simbiostack.Entidades.Pendiente;
import com.simbiostack.Entidades.Response;
import com.simbiostack.Servicios.PendienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/pendientes")
public class ControladorPendiente {
    @Autowired
    PendienteServicio pendienteServicio;

    @GetMapping(path = "/mostrar")
    public List<Pendiente> getPendientes(){
        return pendienteServicio.getPendientes();
    }

    @GetMapping(path = "/get/{id}")
    public Pendiente getPendiente(@PathVariable Integer id){
        return pendienteServicio.getPendiente(id);
    }

    @GetMapping(path = "/vista")
    public Object[] getVistaPendientes(){
        return pendienteServicio.getVistaPendientes();
    }

    @PostMapping(path = "/agregar")
    public Pendiente agregarPendiente(@RequestParam String nombre, @RequestParam(required = false) Integer cliente, @RequestParam Integer usuario, @RequestParam Integer prioridad, @RequestParam String descripcion, @RequestParam(required = false) String fechaEstimada, @RequestParam Integer estado, @RequestParam Integer tipo){

        return pendienteServicio.agregarPendiente(nombre, cliente, usuario, prioridad, descripcion, fechaEstimada, estado, tipo);
    }

    @PostMapping(path = "/editar/{id}")
    public Pendiente edtiarPendiente(@PathVariable Integer id ,@RequestParam String nombre, @RequestParam(required = false) Integer cliente, @RequestParam Integer usuario, @RequestParam Integer prioridad, @RequestParam String descripcion, @RequestParam(required = false) String fechaEstimada, @RequestParam Integer estado, @RequestParam Integer tipo){
        System.out.println(cliente);
        return pendienteServicio.editarPendiente(id, nombre, cliente, usuario, prioridad, descripcion, fechaEstimada, estado, tipo);
    }

    @PostMapping(path = "/accion/{id}")
    public Response cambiarEstado(@PathVariable Integer id, @RequestParam Integer opcion){
        Response res = new Response();
        res.setMensaje(pendienteServicio.cambiarEstado(id, opcion));
        res.setStatus(HttpStatus.OK.value());
        res.setTimestamp(LocalDateTime.now());
        return res;
    }

    @GetMapping(path = "/modificar-estado")
    public Response modificarEstado(@RequestParam Integer id ,@RequestParam Integer estado, @RequestParam Integer prioridad){
        Response res = new Response();
        res.setMensaje(pendienteServicio.modificarEstado(id, estado, prioridad));
        res.setTimestamp(LocalDateTime.now());
        res.setStatus(HttpStatus.OK.value());
        return res;
    }
}
