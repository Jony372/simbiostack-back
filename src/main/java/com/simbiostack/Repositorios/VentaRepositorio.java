package com.simbiostack.Repositorios;

import com.simbiostack.Entidades.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepositorio extends JpaRepository<Venta, Integer> {
    @Query(value = "SELECT * FROM por_pagar", nativeQuery = true)
    public Object[] getPorPagar();
}
