package com.simbiostack.Repositorios;

import com.simbiostack.Entidades.Prioridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrioridadRepositorio extends JpaRepository<Prioridad, Integer> {
}
