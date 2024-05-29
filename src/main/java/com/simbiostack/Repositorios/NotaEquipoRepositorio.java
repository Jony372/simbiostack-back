package com.simbiostack.Repositorios;

import com.simbiostack.Entidades.NotaEquipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaEquipoRepositorio extends JpaRepository<NotaEquipo, Integer> {
}
