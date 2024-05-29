package com.simbiostack.Repositorios;

import com.simbiostack.Entidades.Pendiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.List;

@Repository
public interface PendienteRepositorio extends JpaRepository<Pendiente, Integer> {
    @Query(value = "SELECT * FROM vw_pendientes", nativeQuery = true)
    public Object[] getVistaPendientes();
}
