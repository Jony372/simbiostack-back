package com.simbiostack.Repositorios;

import com.simbiostack.Entidades.CompraProducto;
import com.simbiostack.Entidades.VentaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraProductoRepositorio extends JpaRepository<CompraProducto, Integer> {
    public List<CompraProducto> findByCompraId(Integer id);

}
