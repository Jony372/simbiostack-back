package com.simbiostack.Controladores;

import com.simbiostack.Entidades.Cliente;
import com.simbiostack.Entidades.Response;
import com.simbiostack.Servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/cliente")
public class ControladorCliente {
    @Autowired
    ClienteServicio clienteServicio;

    @PostMapping(path = "/agregar")
    public Cliente agregarCliente(@RequestParam String nombre, @RequestParam String tel, @RequestParam String direccion, @RequestParam String observacion) {
        return clienteServicio.agregarCliente(nombre, tel, direccion, observacion);
    }

    @PostMapping(path = "/editar")
    public Cliente editarCliente(@RequestParam Integer id, @RequestParam String nombre, @RequestParam String tel, @RequestParam String direccion, @RequestParam String observacion){
        return clienteServicio.editarCliente(id, nombre, tel, direccion, observacion);
    }

    @GetMapping(path = "/eliminar/{id}")
    public Response eliminarCliente(@PathVariable Integer id){
        return clienteServicio.eliminarCliente(id);
    }

    @GetMapping(path = "/mostrar")
    public Stream<Cliente> mostrarClientes(){
        return clienteServicio.mostrarClientes();
    }

    @GetMapping(path = "/next")
    public Integer getNextId(){
        return clienteServicio.getNextId();
    }

}
