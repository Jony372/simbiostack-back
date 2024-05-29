package com.simbiostack.Repositorios;

import com.simbiostack.Entidades.NotaEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaEntregaRepositorio extends JpaRepository<NotaEntrega, Integer> {
}
