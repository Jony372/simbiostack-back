package com.simbiostack.Repositorios;

import com.simbiostack.Entidades.Caja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CajaRepositorio extends JpaRepository<Caja, Integer> {
}
