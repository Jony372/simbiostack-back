package com.simbiostack.Controladores;

import com.simbiostack.Entidades.Compra;
import com.simbiostack.Entidades.CompraProducto;
import com.simbiostack.Entidades.Response;
import com.simbiostack.Servicios.CompraServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/compra")
public class ControladorCompra {
    @Autowired
    private CompraServicio compraServicio;

    @GetMapping(path = "/compras")
    public List<Compra> getCompras(){
        return compraServicio.getCompras();
    }

    @PostMapping(path = "/agregar")
    public Compra agregarCompra(@RequestParam Float total, @RequestParam Integer proveedor, @RequestParam Integer isEfectivo){
        return compraServicio.agregarCompra(total, proveedor, isEfectivo);
    }

    @GetMapping(path = "/compra/{id}")
    public Compra getCompra(@PathVariable Integer id){
        return compraServicio.getCompra(id);
    }

    @GetMapping(path = "/compra-productos/{id}")
    public List<CompraProducto> getCompraProductos(@PathVariable Integer id){
        return compraServicio.getCompraProductos(id);
    }

    @PostMapping(path = "/agregar-cp")
    public CompraProducto agregarCompraProducto(@RequestParam Integer producto, @RequestParam Integer compra, @RequestParam Integer cantidad, @RequestParam Float precio, @RequestParam Float subTotal, @RequestParam String nombre){
        return compraServicio.agregarCompraProducto(producto, compra, cantidad, precio, subTotal, nombre);
    }

    @PostMapping(path = "/cancelar/{id}")
    public Response cancelarCompra(@PathVariable Integer id){
        Response res = new Response();
        res.setMensaje(compraServicio.cancelarCompra(id));
        res.setStatus(HttpStatus.OK.value());
        res.setTimestamp(LocalDateTime.now());
        return res;
    }

    @PostMapping(path = "/filtro")
    public List<Compra> filtrarCompras(@RequestParam String search){
        return compraServicio.filtro(search);
    }

}
