package com.simbiostack.Servicios;

import com.simbiostack.Entidades.Usuario;
import com.simbiostack.Repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class UsuarioServicio {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public Usuario addUsuario(String nombre, String tel, String user, String pass, Integer isAdmin){
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setTel(tel);
        usuario.setUser(user);
        usuario.setPass(pass);
        usuario.setIsAdmin(isAdmin);
        usuarioRepositorio.save(usuario);
        return usuario;
    }

    public Usuario getUser(Integer id){
        return usuarioRepositorio.findById(id).orElseThrow(()->new RuntimeException("Usuario no encontrado"));
    }

    public String dropUser(Integer id){
        Usuario user = getUser(id);
        user.setActivo(0);
        usuarioRepositorio.save(user);
        return "Se elimino el usuario";
    }

    public Stream<Usuario> getAllUsers(){
        return usuarioRepositorio.findAll().stream().filter(usuario -> usuario.getActivo() == 1);
    }

    public Stream<Usuario> getAllAdminUsers(){

        return getAllUsers().filter(usuario -> usuario.getIsAdmin() == 1);
    }

    public boolean isAdmin(Integer id){

        return usuarioRepositorio.findById(id).orElseThrow(()-> new RuntimeException("Usuario no Encontrado")).getIsAdmin() == 1;
    }

    public String editUser(Integer id, String nombre, String tel, String user, String pass, Integer isAdmin){
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setNombre(nombre);
        usuario.setTel(tel);
        usuario.setUser(user);
        usuario.setPass(pass);
        usuario.setIsAdmin(isAdmin);
        usuarioRepositorio.save(usuario);
        return "Se edito el usuario";
    }

    public Usuario canLogIn(String user, String pass){
        return usuarioRepositorio.findByUserAndPassAndActivo(user,pass,1);
    }

}

