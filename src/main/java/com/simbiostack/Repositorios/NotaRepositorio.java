package com.simbiostack.Repositorios;

import com.simbiostack.Entidades.Nota;
import com.simbiostack.Entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.List;

@Repository
public interface NotaRepositorio extends JpaRepository<Nota, Integer> {
    @Query(value = "{call notas_trabajando()}", nativeQuery = true)
    public List<Integer> getNotasTrabajando();
}
