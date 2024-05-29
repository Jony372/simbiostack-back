package com.simbiostack.Repositorios;

import com.simbiostack.Entidades.Producto;
import com.simbiostack.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
    @Query(value = "CALL mas_vendidos(:periodo)", nativeQuery = true)
    public Object[] masVendidos(Integer periodo);
}
