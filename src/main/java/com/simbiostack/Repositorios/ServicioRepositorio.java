package com.simbiostack.Repositorios;

import com.simbiostack.Entidades.Producto;
import com.simbiostack.Entidades.Servicio;
import com.simbiostack.Servicios.ProductoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepositorio extends JpaRepository<Servicio, Integer> {
    @Query(value = "SELECT * FROM prod_serv", nativeQuery = true)
    public Object[] getProdServs();
}
