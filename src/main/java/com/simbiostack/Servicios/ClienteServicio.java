package com.simbiostack.Servicios;

import com.simbiostack.Entidades.Cliente;
import com.simbiostack.Entidades.Response;
import com.simbiostack.Repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.stream.Stream;

@Service
public class ClienteServicio {
    @Autowired
    ClienteRepositorio clienteRepositorio;

    public Cliente getCliente(Integer id){
        return clienteRepositorio.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el cliente"));
    }
    public Cliente agregarCliente(String nombre, String tel, String direccion, String observacion){
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setTel(tel);
        cliente.setDireccion(direccion);
        cliente.setObservacion(observacion);
        clienteRepositorio.save(cliente);
        return cliente;
    };

    public Cliente editarCliente(Integer id, String nombre, String tel, String direccion, String observacion){
        Cliente cliente = clienteRepositorio.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el cliente"));
        cliente.setDireccion(direccion);
        cliente.setNombre(nombre);
        cliente.setTel(tel);
        cliente.setObservacion(observacion);
        clienteRepositorio.save(cliente);

        return cliente;
    }

    public Response eliminarCliente(Integer id){
        Response res = new Response();
        try{
            if(id == 1){
                throw new RuntimeException("No se puede eliminar la venta de mostrador");
            }
            Cliente cliente = clienteRepositorio.findById(id).orElseThrow(()-> new RuntimeException("No se enocntro el cliente"));
            cliente.setActivo(0);
            clienteRepositorio.save(cliente);
            res.setMensaje("Se elimino el cliente");
            res.setStatus(HttpStatus.OK.value());
        }catch (Exception e){
            res.setMensaje(e.getMessage());
            res.setStatus(HttpStatus.BAD_GATEWAY.value());
        }
        res.setTimestamp(LocalDateTime.now());
        return res;
    }

    public Stream<Cliente> mostrarClientes(){
        return clienteRepositorio.findAll().stream().filter(cliente -> cliente.getActivo() == 1);
    }

    public Integer getNextId(){
        return clienteRepositorio.getNextId();
    }
}

