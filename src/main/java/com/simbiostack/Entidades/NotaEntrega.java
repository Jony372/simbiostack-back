package com.simbiostack.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "notaentrega")
public class NotaEntrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "total")
    private float total;

    @ManyToOne
    @JoinColumn(name = "id_caja")
    private Caja caja = null;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoNota estado;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "is_efectivo")
    private Boolean isEfectivo;

    @ManyToOne
    @JoinColumn(name = "id_nota")
    private Nota nota;

    @Column(name = "cancelado")
    private Boolean cancelado = false;

    public Integer getId() {
        return id;
    }

    public Boolean getCancelado() {
        return cancelado;
    }

    public void setCancelado(Boolean cancelado) {
        this.cancelado = cancelado;
    }

    public EstadoNota getEstado() {
        return estado;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public void setEstado(EstadoNota estado) {
        this.estado = estado;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Boolean getEfectivo() {
        return isEfectivo;
    }

    public void setEfectivo(Boolean efectivo) {
        isEfectivo = efectivo;
    }
}
