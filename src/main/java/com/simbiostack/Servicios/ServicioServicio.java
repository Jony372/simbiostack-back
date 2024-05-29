package com.simbiostack.Servicios;

import com.simbiostack.Entidades.Servicio;
import com.simbiostack.Repositorios.ServicioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ServicioServicio {
    @Autowired
    ServicioRepositorio servicioRepositorio;

    public Servicio agregarServicio(Float precio, String nombre, String descripcion){
        Servicio ser = new Servicio();
        ser.setPrecio(precio);
        ser.setNombre(nombre);
        ser.setDescripcion(descripcion);
        servicioRepositorio.save(ser);
        return ser;
    }

    public Servicio editarServicio(Integer id, Float precio, String nombre, String descripcion){
        Servicio ser = servicioRepositorio.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el servicio"));
        ser.setNombre(nombre);
        ser.setDescripcion(descripcion);
        ser.setPrecio(precio);
        servicioRepositorio.save(ser);
        return ser;
    }

    public String eliminarServicio(Integer id){
        Servicio ser = servicioRepositorio.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el servicio"));
        ser.setEstado(0);
        servicioRepositorio.save(ser);
        return "Se elimino el servicio";
    }

    public List<Servicio> mostrarServicios(){
        return servicioRepositorio.findAll().stream().filter(servicio -> servicio.getEstado() == 1).toList();
    }

    public Object[] getProdServs(){
        return servicioRepositorio.getProdServs();
    }

    public Servicio getServicio(Integer id){
        return servicioRepositorio.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el servicio"+id));
    }

}
