package com.simbiostack.Servicios;

import com.simbiostack.Entidades.Venta;
import com.simbiostack.Entidades.VentaProducto;
import com.simbiostack.Repositorios.UsuarioRepositorio;
import com.simbiostack.Repositorios.VentaProductoRepositorio;
import com.simbiostack.Repositorios.VentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VentaServicio {
    @Autowired
    VentaRepositorio ventaRepositorio;
    @Autowired
    VentaProductoRepositorio ventaProductoRepositorio;
    @Autowired
    UsuarioServicio usuarioServicio;
    @Autowired
    ClienteServicio clienteServicio;
    @Autowired
    CajaServicio cajaServicio;
    @Autowired
    EstadoNotaServicio estadoNotaServicio;
    @Autowired
    ProductoServicio productoServicio;

    public List<Venta> getVentas(){
        return  ventaRepositorio.findAll().stream().toList();
    }

    public Venta getVenta(Integer id){
        return ventaRepositorio.findById(id).orElseThrow(()-> new RuntimeException("No se encontro la venta"));
    }

    public List<VentaProducto> getVentaProductos(Integer id){
//        return ventaProductoRepositorio.findAll().stream().filter(vp -> vp.getVenta().getId().equals(id)).toList();
        return ventaProductoRepositorio.findByVentaId(id);
    }

    public Venta agregarVenta(Integer usuario, Integer cliente, Float total, Integer estado, Integer isEfectivo){
        Venta venta = new Venta();
        venta.setUsuario(usuarioServicio.getUser(usuario));
        venta.setCliente(clienteServicio.getCliente(cliente));
        venta.setTotal(total);
        venta.setFecha(LocalDateTime.now().toString());
        venta.setEstado(estadoNotaServicio.getEstado(estado));
        venta.setIsEfectivo(isEfectivo);
        if(estado == 2){
            venta.setCaja(cajaServicio.getCajaActual());
        }
        ventaRepositorio.save(venta);
        return venta;
    }

    public VentaProducto agregarVentaProducto(Integer producto, Integer venta, Integer cantidad, Float subTotal, Float precio, String nombreProducto){
        VentaProducto ventaProducto = new VentaProducto();
        ventaProducto.setProducto(productoServicio.getProducto(producto));
        ventaProducto.setVenta(getVenta(venta));
        ventaProducto.setCantidad(cantidad);
        ventaProducto.setSubTotal(subTotal);
        ventaProducto.setPrecio(precio);
        ventaProducto.setProductoNombre(nombreProducto);
        ventaProductoRepositorio.save(ventaProducto);
        return ventaProducto;
    }

    public Object[] ventasPorPagar(){
        return ventaRepositorio.getPorPagar();
    }

    public String pagarVenta(Integer id, Integer isEfectivo){
        Venta venta = getVenta(id);
        venta.setEstado(estadoNotaServicio.getEstado(2));
        venta.setIsEfectivo(isEfectivo);
        venta.setCaja(cajaServicio.getCajaActual());
        ventaRepositorio.save(venta);
        return "Venta pagada";
    }

    public String cancelarVenta(Integer id){
        Venta venta = getVenta(id);
        venta.setCancelado(true);
        ventaRepositorio.save(venta);
        return "Venta cancelada";
    }

    public List<Venta> filtro(String search){
        return ventaRepositorio.findAll().stream().filter(v -> v.getCliente().getNombre().toLowerCase().contains(search.toLowerCase()) || v.getId().toString().contains(search)).toList();
    }
}
