package com.simbiostack.Controladores;

import com.simbiostack.Entidades.Proveedor;
import com.simbiostack.Entidades.Response;
import com.simbiostack.Servicios.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "api/proveedor")
public class ControladorProveedor {
    @Autowired
    ProveedorServicio proveedorServicio;

    @PostMapping(path = "/agregar")
    public Proveedor agregarProveedor(@RequestParam String nombre, @RequestParam(required = false) String tel,@RequestParam(required = false) String pagina){
        return proveedorServicio.agregarProveedor(nombre, tel, pagina);
    }

    @PostMapping(path = "/editar")
    public Proveedor editarProveedor(@RequestParam Integer id, @RequestParam String nombre, @RequestParam(required = false) String tel,@RequestParam(required = false) String pagina){
        return proveedorServicio.editarProveedor(id, nombre, tel, pagina);
    }

    @GetMapping(path = "/getProveedor/{id}")
    public Proveedor obtenerProveedor(@PathVariable Integer id){
        return proveedorServicio.obtenerProveedor(id);
    }

    @PostMapping(path = "/eliminar/{id}")
    public Response eliminarProveedor(@PathVariable Integer id) {
        Response res = new Response();
        res.setMensaje(proveedorServicio.eliminarProveedor(id));
        res.setTimestamp(LocalDateTime.now());
        res.setStatus(HttpStatus.OK.value());
        return res;
    }

    @GetMapping(path = "/proveedores")
    public List<Proveedor> proveedores(){
        return proveedorServicio.proveedores();
    }
}
