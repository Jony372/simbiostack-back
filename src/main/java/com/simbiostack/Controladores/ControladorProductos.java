package com.simbiostack.Controladores;

import com.simbiostack.Entidades.Producto;
import com.simbiostack.Entidades.Response;
import com.simbiostack.Servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;


@CrossOrigin("*")
@RestController
@RequestMapping("api/productos")
public class ControladorProductos {

    @Autowired
    ProductoServicio productoServicio;

    @PostMapping(path = "/addProducto")
    public Producto addProducto(@RequestParam Float precio,@RequestParam Integer cantidad,@RequestParam String codigoBarra,@RequestParam String nombre,@RequestParam Integer categoria,@RequestParam Float costo,@RequestParam Float utilidad){
        return productoServicio.addProducto(precio, cantidad, codigoBarra, nombre, categoria, costo, utilidad);
    }

    @GetMapping(path = "/show")
    public Stream<Producto> showProductos(){
        return productoServicio.showProductos();
    }

    @GetMapping(path = "/delete/{id}")
    public Response eliminarProducto(@PathVariable Integer id){
        Response res = new Response();
        if (productoServicio.eliminarProducto(id)){
//            res = new Response(LocalDateTime.now(), HttpStatus.OK.value(), "Se elimino el producto");
            res.setMensaje("Se elimino el producto");
            res.setStatus(HttpStatus.OK.value());
            res.setTimestamp(LocalDateTime.now());
        }else {
            res.setMensaje("No se pudo eliminar el producto");
            res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            res.setTimestamp(LocalDateTime.now());
//            res = new Response(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "No se pudo eliminar el producto");
        }
        return res;
    }

    @GetMapping(path = "/get/{id}")
    public Producto getProducto(@PathVariable Integer id){
        return productoServicio.getProducto(id);
    }

    @PostMapping(path = "/editar")
    public Producto editarProducto(@RequestParam Integer id, @RequestParam Float precio,@RequestParam Integer cantidad,@RequestParam String codigoBarra,@RequestParam String nombre,@RequestParam Integer categoria,@RequestParam Float costo,@RequestParam Float utilidad){
        return productoServicio.editarProducto(id, precio, cantidad, codigoBarra, nombre, categoria, costo, utilidad);
    }

    @GetMapping(path = "/mas-vendidos")
    public Object[] masVendidos(@RequestParam Integer periodo){
        return productoServicio.masVendidos(periodo);
    }

    /*
    @PostMapping(path = "/addProducto")
    public String addProducto(@RequestParam String nombre, @RequestParam Float precio, @RequestParam Integer cantidad, @RequestParam String codigoBarra, @RequestParam Integer idCategoria){
        return productoServicio.addProducto(nombre, precio, cantidad, codigoBarra, idCategoria);
    }
     */
}
