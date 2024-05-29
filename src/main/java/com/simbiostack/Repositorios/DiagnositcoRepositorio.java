package com.simbiostack.Repositorios;

import com.simbiostack.Entidades.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnositcoRepositorio extends JpaRepository<Diagnostico, Integer> {
}
