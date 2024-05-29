package com.simbiostack.Repositorios;

import com.simbiostack.Entidades.EstadoNota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoNotaRepositorio extends JpaRepository<EstadoNota, Integer> {
}
