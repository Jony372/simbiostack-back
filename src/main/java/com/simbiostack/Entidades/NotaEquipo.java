package com.simbiostack.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "notasequipo")
public class NotaEquipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_nota")
    private Nota nota;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    public Integer getId() {
        return id;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
