package com.simbiostack.Repositorios;

import com.simbiostack.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
    @Query(value = "{ call next_id('clientes')}", nativeQuery = true)
    public Integer getNextId();
}
