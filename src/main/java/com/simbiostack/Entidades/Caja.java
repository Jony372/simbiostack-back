package com.simbiostack.Entidades;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "caja")
public class Caja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dininicial")
    private Float dinInicial;

    @Column(name = "fecha")
    private String fecha = LocalDate.now().toString();

    @Column(name = "entradas")
    private Float entradas = 0f;

    @Column(name = "salidas")
    private Float salidas = 0f;

    @Column(name = "saldofinal")
    private Float saldoFinal = null;

    @Column(name = "fechafinal")
    private String fechaFinal = null;

    public Float getDinInicial() {
        return dinInicial;
    }

    public void setDinInicial(Float dinInicial) {
        this.dinInicial = dinInicial;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Float getEntradas() {
        return entradas;
    }

    public void setEntradas(Float entradas) {
        this.entradas = entradas;
    }

    public Float getSalidas() {
        return salidas;
    }

    public void setSalidas(Float salidas) {
        this.salidas = salidas;
    }

    public Float getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(Float saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public Integer getId() {
        return id;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
}
