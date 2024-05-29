package com.simbiostack.Repositorios;

import com.simbiostack.Entidades.VentaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaProductoRepositorio extends JpaRepository<VentaProducto, Integer> {
    public List<VentaProducto> findByVentaId(Integer id);
}
