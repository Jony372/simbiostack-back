package com.simbiostack.Controladores;

import com.simbiostack.Entidades.Response;
import com.simbiostack.Entidades.Servicio;
import com.simbiostack.Servicios.ProductoServicio;
import com.simbiostack.Servicios.ServicioServicio;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/* Falta en postman */

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/servicios")
public class ControladorServicio {
    @Autowired
    ServicioServicio servicioServicio;

    @PostMapping(path = "/agregar")
    public Servicio agregarServicio(@RequestParam Float precio, @RequestParam String nombre, @RequestParam String descripcion){
        return servicioServicio.agregarServicio(precio, nombre, descripcion);
    }

    @PostMapping(path = "/editar/{id}")
    public Servicio editarServicio(@PathVariable Integer id, @RequestParam Float precio, @RequestParam String nombre, @RequestParam String descripcion){
        return servicioServicio.editarServicio(id, precio, nombre, descripcion);
    }

    @PostMapping(path = "/eliminar/{id}")
    public Response eliminarServicio(@PathVariable Integer id){
        Response res = new Response();
        res.setMensaje(servicioServicio.eliminarServicio(id));
        res.setTimestamp(LocalDateTime.now());
        res.setStatus(HttpStatus.OK.value());
        return res;
    }

    @GetMapping("/servicios")
    public List<Servicio> mostrarServicios(){
        return servicioServicio.mostrarServicios();
    }

    @GetMapping("/prod-servs")
    public Object[] productosServicios(){
        return servicioServicio.getProdServs();
    }
}
