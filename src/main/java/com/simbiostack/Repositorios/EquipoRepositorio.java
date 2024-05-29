package com.simbiostack.Repositorios;

import com.simbiostack.Entidades.Equipo;
import com.simbiostack.Entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipoRepositorio extends JpaRepository<Equipo, Integer> { }
