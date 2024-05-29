package com.simbiostack.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "color")
    private String color;

    @Column(name = "password")
    private String pass;

    @Column(name = "problema")
    private String problema;

    @Column(name = "cargador")
    private boolean cargador = false;

    @Column(name = "funda")
    private boolean funda = false;

    @Column(name = "usb")
    private boolean usb = false;

    @Column(name = "cables")
    private boolean cables = false;

    @Column(name = "extras")
    private String extras = "";

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoPendiente tipoPendiente;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToMany (mappedBy = "equipos")
    @JsonBackReference
    private List<Nota> notas;

//    @ManyToMany
//    @JoinTable(
//            name = "notasequipo",
//            joinColumns = @JoinColumn(name = "id_equipo", referencedColumnName = "id"),
//            inverseJoinColumns = {@JoinColumn(name = "id_nota", referencedColumnName = "id")}
//    )
//    @JsonManagedReference
//    private List<Nota> notas;


    public TipoPendiente getTipoPendiente() {
        return tipoPendiente;
    }

    public void setTipoPendiente(TipoPendiente tipoPendiente) {
        this.tipoPendiente = tipoPendiente;
    }

    public boolean isFunda() {
        return funda;
    }

    public void setFunda(boolean funda) {
        this.funda = funda;
    }

    public boolean isUsb() {
        return usb;
    }

    public void setUsb(boolean usb) {
        this.usb = usb;
    }

    public boolean isCables() {
        return cables;
    }

    public void setCables(boolean cables) {
        this.cables = cables;
    }

    public boolean isCargador() {
        return cargador;
    }

    public void setCargador(boolean cargador) {
        this.cargador = cargador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    //
}

