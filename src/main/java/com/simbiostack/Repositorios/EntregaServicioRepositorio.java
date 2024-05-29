package com.simbiostack.Repositorios;

import com.simbiostack.Entidades.EntregaServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntregaServicioRepositorio extends JpaRepository<EntregaServicio, Integer> {
    public List<EntregaServicio> findByNotaEntregaId(Integer id);
}
