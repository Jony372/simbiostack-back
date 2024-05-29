package com.simbiostack.Servicios;

import com.simbiostack.Entidades.EntregaServicio;
import com.simbiostack.Repositorios.EntregaServicioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaServicioServicio {
    @Autowired
    EntregaServicioRepositorio entregaServicioRepositorio;
    @Autowired
    NotaEntregaServicio notaEntregaServicio;
    @Autowired
    ServicioServicio servicioServicio;
    @Autowired
    ProductoServicio productoServicio;

    public EntregaServicio agregarEntregaServicio(Integer notaEntrega, Integer servicio, Integer cantidad, String nombre, Float subTotal, Float precio){
        EntregaServicio es = new EntregaServicio();
        es.setNotaEntrega(notaEntregaServicio.getNota(notaEntrega));
        es.setServicio(servicioServicio.getServicio(servicio));
        es.setCantidad(cantidad);
        es.setNombre(nombre);
        es.setSubTotal(subTotal);
        es.setPrecio(precio);
        entregaServicioRepositorio.save(es);
        return es;
    }

    public EntregaServicio agregarEntregaProducto(Integer notaEntrega, Integer producto, Integer cantidad, String nombre, Float subTotal, Float precio){
        EntregaServicio es = new EntregaServicio();
        es.setNotaEntrega(notaEntregaServicio.getNota(notaEntrega));
        es.setProducto(productoServicio.getProducto(producto));
        es.setCantidad(cantidad);
        es.setNombre(nombre);
        es.setSubTotal(subTotal);
        es.setPrecio(precio);
        entregaServicioRepositorio.save(es);
        return es;
    }

    public List<EntregaServicio> getEntregaServicio(Integer id){
        return entregaServicioRepositorio.findByNotaEntregaId(id);
    }
}
