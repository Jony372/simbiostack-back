package com.simbiostack.Servicios;

import com.simbiostack.Entidades.Proveedor;
import com.simbiostack.Repositorios.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServicio {
    @Autowired
    ProveedorRepositorio proveedorRepositorio;

    public Proveedor agregarProveedor(String nombre, String tel, String pagina){
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(nombre);
        proveedor.setTel(tel);
        proveedor.setPagina(pagina);
        proveedorRepositorio.save(proveedor);
        return proveedor;
    }

    public Proveedor obtenerProveedor(Integer id){
        return proveedorRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    }

    public String eliminarProveedor(Integer id){
        Proveedor proveedor = obtenerProveedor(id);
        proveedor.setEstado(0);
        proveedorRepositorio.save(proveedor);
        return "Proveedor eliminado";
    }

    public Proveedor editarProveedor(Integer id, String nombre, String tel, String pagina){
        Proveedor proveedor = obtenerProveedor(id);
        proveedor.setNombre(nombre);
        proveedor.setTel(tel);
        proveedor.setPagina(pagina);
        proveedorRepositorio.save(proveedor);
        return proveedor;
    }

    public List<Proveedor> proveedores(){
        return proveedorRepositorio.findAll().stream().filter(proveedor -> proveedor.getEstado() == 1).toList();
    }
}
