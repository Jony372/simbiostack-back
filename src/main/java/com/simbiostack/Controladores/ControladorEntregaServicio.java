package com.simbiostack.Controladores;

import com.simbiostack.Entidades.EntregaServicio;
import com.simbiostack.Entidades.NotaEntrega;
import com.simbiostack.Servicios.EntregaServicioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/entregaservicio")
public class ControladorEntregaServicio {
    @Autowired
    EntregaServicioServicio entregaServicioServicio;

    @PostMapping(path = "/agregar-servicio")
    public EntregaServicio agregarEntregaServicio(@RequestParam Integer notaEntrega, @RequestParam Integer servicio, @RequestParam Integer cantidad, @RequestParam String nombre, @RequestParam Float subTotal, @RequestParam Float precio){
        return entregaServicioServicio.agregarEntregaServicio(notaEntrega, servicio, cantidad, nombre, subTotal, precio);
    }

    @PostMapping(path = "/agregar-producto")
    public EntregaServicio agregarEntregaProducto(@RequestParam Integer notaEntrega, @RequestParam Integer producto, @RequestParam Integer cantidad, @RequestParam String nombre, @RequestParam Float subTotal, @RequestParam Float precio){
        return entregaServicioServicio.agregarEntregaProducto(notaEntrega, producto, cantidad, nombre, subTotal, precio);
    }

    @GetMapping(path = "/mostrar-es/{id}")
    private List<EntregaServicio> getEntregasServicios(@PathVariable Integer id){
        return entregaServicioServicio.getEntregaServicio(id);
    }
}
