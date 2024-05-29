package com.simbiostack.Repositorios;

import com.simbiostack.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    Usuario findByUserAndPassAndActivo(String user, String pass, Integer activo);
}
