package com.simbiostack.Entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "total")
    private Float total;

    @ManyToOne
    @JoinColumn(name = "id_caja")
    private Caja caja;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "is_efectivo")
    private Integer isEfectivo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "compraproducto",
            joinColumns = @JoinColumn(name = "id_compra", referencedColumnName = "id"),
            inverseJoinColumns = {@JoinColumn(name = "id_producto", referencedColumnName = "id")}
    )
    @JsonManagedReference
    private List<Producto> cproductos;

    @Column(name = "cancelado")
    private Boolean cancelado = false;

    public Boolean getCancelado() {
        return cancelado;
    }

    public void setCancelado(Boolean cancelado) {
        this.cancelado = cancelado;
    }

    public Integer getIsEfectivo() {
        return isEfectivo;
    }

    public void setIsEfectivo(Integer isEfectivo) {
        this.isEfectivo = isEfectivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Integer getId() {
        return id;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public List<Producto> getCproductos() {
        return cproductos;
    }

    public void setCproductos(List<Producto> cproductos) {
        this.cproductos = cproductos;
    }
}
