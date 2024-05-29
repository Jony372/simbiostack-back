package com.simbiostack.Repositorios;

import com.simbiostack.Entidades.Notita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotitaRepositorio extends JpaRepository<Notita, Integer> {
}
