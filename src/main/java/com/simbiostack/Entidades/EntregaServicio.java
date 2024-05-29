package com.simbiostack.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "entregaservicios")
public class EntregaServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_nota_entrega")
    private NotaEntrega notaEntrega;

    @ManyToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;

    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto = null;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "sub_total")
    private Float subTotal;

    @Column(name = "precio")
    private Float precio;

    public Integer getId() {
        return id;
    }

    public NotaEntrega getNotaEntrega() {
        return notaEntrega;
    }

    public void setNotaEntrega(NotaEntrega notaEntrega) {
        this.notaEntrega = notaEntrega;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Float subTotal) {
        this.subTotal = subTotal;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
