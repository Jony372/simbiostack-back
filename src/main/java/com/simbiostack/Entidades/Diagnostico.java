package com.simbiostack.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "diagnostico")
public class Diagnostico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "diagnostico")
    private String diagnostico;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    @Column(name = "pantalla_rota")
    private Boolean pantallaRota;

    @Column(name = "cargador")
    private Boolean cargador;

    @Column(name = "enciende")
    private Boolean enciende;

    @Column(name = "bisagras")
    private Boolean bisagras;

    @Column(name = "ram")
    private Integer ram;

    @Column(name = "almacenamiento")
    private String almacenamiento;

    public Integer getId() {
        return id;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Boolean getPantallaRota() {
        return pantallaRota;
    }

    public void setPantallaRota(Boolean pantallaRota) {
        this.pantallaRota = pantallaRota;
    }

    public Boolean getCargador() {
        return cargador;
    }

    public void setCargador(Boolean cargador) {
        this.cargador = cargador;
    }

    public Boolean getEnciende() {
        return enciende;
    }

    public void setEnciende(Boolean enciende) {
        this.enciende = enciende;
    }

    public Boolean getBisagras() {
        return bisagras;
    }

    public void setBisagras(Boolean bisagras) {
        this.bisagras = bisagras;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }
}
