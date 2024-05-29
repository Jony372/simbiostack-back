package com.simbiostack.Repositorios;

import com.simbiostack.Entidades.TipoPendiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPendienteRepositorio extends JpaRepository<TipoPendiente, Integer> {
}
