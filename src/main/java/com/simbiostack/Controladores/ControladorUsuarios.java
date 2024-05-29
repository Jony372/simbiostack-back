package com.simbiostack.Controladores;

import com.simbiostack.Entidades.Response;
import com.simbiostack.Entidades.Usuario;
import com.simbiostack.Entidades.loginReq;
import com.simbiostack.Servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/usuarios")
public class ControladorUsuarios {

    @Autowired
    UsuarioServicio usuarioServicio;

    @PostMapping(path = "/addUsuario")
    public Usuario addUsuario(@RequestParam String nombre, @RequestParam String tel, @RequestParam String user, @RequestParam String pass, @RequestParam Integer isAdmin){
        return usuarioServicio.addUsuario(nombre, tel, user, pass, isAdmin);
    }

    @PostMapping(path = "/editUsuario")
    public Response editUsuario(@RequestParam Integer id, @RequestParam String nombre,@RequestParam String tel,@RequestParam String user,@RequestParam String pass,@RequestParam Integer isAdmin){
        Response res = new Response();
        res.setMensaje(usuarioServicio.editUser(id, nombre, tel, user, pass, isAdmin));
        res.setTimestamp(LocalDateTime.now());
        res.setStatus(HttpStatus.OK.value());
        return res;
    }

    @GetMapping(path = "/getUser/{id}")
    public Usuario getUser(@PathVariable Integer id){
        return usuarioServicio.getUser(id);
    }

    @GetMapping(path = "/dropUser/{id}")
    public Response dropUser(@PathVariable Integer id){
        Response res = new Response();
        res.setMensaje(usuarioServicio.dropUser(id));
        res.setStatus(HttpStatus.OK.value());
        res.setTimestamp(LocalDateTime.now());
        return res;
    }

    @GetMapping(path = "/getAll")
    public Stream<Usuario> getAllUsers(){
        return usuarioServicio.getAllUsers();
    }

    @GetMapping(path = "/getAdmins")
    public Stream<Usuario> getAllUsersAdmin(){
        return usuarioServicio.getAllAdminUsers();
    }

    @GetMapping(path = "/isAdmin/{id}")
    public boolean isAdmin(@PathVariable Integer id){
        return usuarioServicio.isAdmin(id);
    }

    @GetMapping(path = "/login")
    public loginReq canLogIn(@RequestParam String user, @RequestParam String pass){
        loginReq l = new loginReq();
        Usuario u = usuarioServicio.canLogIn(user, pass);
        l.setId(u.getId());
        l.setUser(u.getUser());
        l.setNombre(u.getNombre());
        l.setTel(u.getTel());
        l.setIsAdmin(u.getIsAdmin());
        return l;
    }



}

