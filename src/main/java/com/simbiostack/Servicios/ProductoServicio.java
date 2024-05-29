package com.simbiostack.Servicios;

import com.simbiostack.Entidades.Producto;
import com.simbiostack.Repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class ProductoServicio {

    @Autowired
    ProductoRepositorio productoRepositorio;
    @Autowired
    CategoriaServicio cs;

    public Producto addProducto(Float precio, Integer cantidad, String codigoBarra, String nombre, Integer categoria, Float costo, Float utilidad){
        try {
            Producto prod = new Producto();
            prod.setPrecio(precio);
            prod.setCantidad(cantidad);
            prod.setCodigobarra(codigoBarra);
            prod.setNombre(nombre);
            prod.setCategoria(cs.getCategoria(categoria));
            prod.setCosto(costo);
            prod.setUtilidad(utilidad);

            productoRepositorio.save(prod);
            return prod;
        }catch (Exception e){
            System.err.println("Error al agregar producto"+e);
            return null;
        }
    }

    public Stream<Producto> showProductos(){
        return productoRepositorio.findAll().stream().filter(prod -> prod.getIsActive() == 1);
    }

    public Boolean eliminarProducto(Integer id){
        try {
            Producto prod = productoRepositorio.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el producto" ));
            prod.setIsActive(0);
            productoRepositorio.save(prod);
            return true;
        }catch(Exception e){
            System.err.println("Error al eliminar el producto: "+e);
            return false;
        }
    }

    public Producto getProducto(Integer id){
        return productoRepositorio.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el producto"));
    }

    public Producto editarProducto(Integer id, Float precio, Integer cantidad, String codigoBarra, String nombre, Integer categoria, Float costo, Float utilidad){
        Producto prod = getProducto(id);
        prod.setPrecio(precio);
        prod.setCantidad(cantidad);
        prod.setCodigobarra(codigoBarra);
        prod.setNombre(nombre);
        prod.setCategoria(cs.getCategoria(categoria));
        prod.setCosto(costo);
        prod.setUtilidad(utilidad);
        productoRepositorio.save(prod);
        return prod;
    }

    public Object[] masVendidos(Integer periodo){
        return productoRepositorio.masVendidos(periodo);
    }

    /*
    public String addProducto(String nombre, Float precio, Integer cantidad, String codigoBarra, Integer idCategoria){
        try {
            Producto prod = new Producto();
            prod.setPrecio(precio);
            prod.setCantidad(cantidad);
            prod.setCodigoBarra(codigoBarra);
            prod.setNombre(nombre);
            prod.setIdCategoria(idCategoria);

            productoRepositorio.save(prod);
            return "Se agregó el producto";
        }catch (Exception e){
            System.err.println("Error al agregar producto: "+e);
            return "ERROR, Revise los datos";
        }

    }
     */
}
