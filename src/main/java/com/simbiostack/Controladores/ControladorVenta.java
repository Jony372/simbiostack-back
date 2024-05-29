package com.simbiostack.Controladores;

import com.simbiostack.Entidades.Response;
import com.simbiostack.Entidades.Venta;
import com.simbiostack.Entidades.VentaProducto;
import com.simbiostack.Servicios.VentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin("*")
@RequestMapping(path = "/api/ventas")
@RestController
public class ControladorVenta {
    @Autowired
    VentaServicio ventaServicio;

    @GetMapping(path = "/mostrar")
    public List<Venta> getVentas(){
        return ventaServicio.getVentas();
    }

    @GetMapping(path = "/get-venta/{id}")
    public Venta getVenta(@PathVariable Integer id){
        return ventaServicio.getVenta(id);
    }

    @GetMapping(path = "/mostrar-vp/{id}")
    public List<VentaProducto> getVentaProductos(@PathVariable Integer id){
        return ventaServicio.getVentaProductos(id);
    }

    @PostMapping(path = "/agregar")
    public Venta agregarVenta(@RequestParam Integer usuario, @RequestParam Integer cliente, @RequestParam Float total, @RequestParam Integer estado, @RequestParam Integer isEfectivo){
        return ventaServicio.agregarVenta(usuario, cliente, total, estado, isEfectivo);
    }

    @PostMapping(path = "/agregar-vp")
    public VentaProducto agregarVentaProducto(@RequestParam(required = false, defaultValue = "1") Integer producto, @RequestParam Integer venta, @RequestParam Integer cantidad, @RequestParam Float subTotal, @RequestParam Float precio, @RequestParam String nombreProducto){
        return ventaServicio.agregarVentaProducto(producto, venta, cantidad, subTotal, precio, nombreProducto);
    }

    @GetMapping(path = "/por-pagar")
    public Object[] getVentasPorPagar(){
        return ventaServicio.ventasPorPagar();
    }

    @GetMapping(path = "/pagar/{id}")
    public Response pagarVenta(@PathVariable Integer id, @RequestParam Integer isEfectivo){
        Response res = new Response();
        res.setStatus(HttpStatus.OK.value());
        res.setMensaje(ventaServicio.pagarVenta(id, isEfectivo));
        res.setTimestamp(LocalDateTime.now());
        return res;
    }

    @PostMapping(path = "/cancelar/{id}")
    public Response cancelarVenta(@PathVariable Integer id){
        Response res = new Response();
        res.setStatus(HttpStatus.OK.value());
        res.setMensaje(ventaServicio.cancelarVenta(id));
        res.setTimestamp(LocalDateTime.now());
        return res;
    }

    @GetMapping(path = "/filtro")
    public List<Venta> getVentasFiltradas(@RequestParam String search){
        return ventaServicio.filtro(search);
    }
}
