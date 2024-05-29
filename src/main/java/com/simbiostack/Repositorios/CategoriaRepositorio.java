package com.simbiostack.Repositorios;

import com.simbiostack.Entidades.Categoria;
import com.simbiostack.Entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {
    @Query(value = "{ call bajo_stock()}", nativeQuery = true)
    public List<Categoria> getBajoStock();
}
