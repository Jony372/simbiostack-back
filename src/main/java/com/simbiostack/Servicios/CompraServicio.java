package com.simbiostack.Servicios;

import com.simbiostack.Entidades.Compra;
import com.simbiostack.Entidades.CompraProducto;
import com.simbiostack.Entidades.Venta;
import com.simbiostack.Repositorios.CompraProductoRepositorio;
import com.simbiostack.Repositorios.CompraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompraServicio {
    @Autowired
    private CompraRepositorio compraRepositorio;
    @Autowired
    private CajaServicio cajaServicio;
    @Autowired
    private ProveedorServicio proveedorServicio;

    @Autowired
    private CompraProductoRepositorio compraProductoRepositorio;
    @Autowired
    private ProductoServicio productoServicio;


    public List<Compra> getCompras(){
        return compraRepositorio.findAll();
    }

    public Compra getCompra(Integer id){
        return compraRepositorio.findById(id).orElseThrow(()-> new RuntimeException("No se encontro la compra"));
    }

    public Compra agregarCompra(Float total, Integer proveedor, Integer isEfectivo){
        Compra compra = new Compra();
        compra.setCaja(cajaServicio.getCajaActual());
        compra.setTotal(total);
        compra.setProveedor(proveedorServicio.obtenerProveedor(proveedor));
        compra.setFecha(LocalDateTime.now().toString());
        compra.setIsEfectivo(isEfectivo);
        compraRepositorio.save(compra);
        return compra;
    }

    public List<CompraProducto> getCompraProductos(Integer id){
        return compraProductoRepositorio.findByCompraId(id);
    }

    public CompraProducto agregarCompraProducto(Integer producto, Integer compra, Integer cantidad, Float precio, Float subTotal, String nombre){
        CompraProducto compraProducto = new CompraProducto();
        compraProducto.setProducto(productoServicio.getProducto(producto));
        compraProducto.setCompra(getCompra(compra));
        compraProducto.setCantidad(cantidad);
        compraProducto.setSubTotal(subTotal);
        compraProducto.setPrecio(precio);
        compraProducto.setNombre(nombre);
        compraProductoRepositorio.save(compraProducto);
        return compraProducto;
    }

    public String cancelarCompra(Integer id){
        Compra c = getCompra(id);
        c.setCancelado(true);
        compraRepositorio.save(c);
        return "Se cancelo la venta";
    }

    public List<Compra> filtro(String search){
        return compraRepositorio.findAll().stream().filter(c -> c.getProveedor().getNombre().toLowerCase().contains(search.toLowerCase()) || c.getId().toString().contains(search)).toList();
    }
}
