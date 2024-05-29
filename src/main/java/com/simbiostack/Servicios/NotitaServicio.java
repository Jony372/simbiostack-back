package com.simbiostack.Servicios;

import com.simbiostack.Entidades.Notita;
import com.simbiostack.Entidades.Response;
import com.simbiostack.Repositorios.NotitaRepositorio;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotitaServicio {
    @Autowired
    NotitaRepositorio notitaRepositorio;

    public List<Notita> obtenerNotitas(){
        return notitaRepositorio.findAll().stream().toList();
    }

    public Notita obtenerNotita(Integer id){
        return notitaRepositorio.findById(id).orElseThrow(() -> new RuntimeException("No se encontro la notita"));
    }

    public Notita agregarNotita(String descripcion){
        Notita n = new Notita();
        n.setDescripcion(descripcion);
        notitaRepositorio.save(n);
        return n;
    }

    public Notita editarNotita(Integer id, String descripcion){
        Notita n = obtenerNotita(id);
        n.setDescripcion(descripcion);
        notitaRepositorio.save(n);
        return n;
    }

    public Response eliminarNotita(Integer id){
        Response res = new Response();
        res.setTimestamp(LocalDateTime.now());
        try {
            notitaRepositorio.deleteById(id);
            res.setMensaje("Se elimino la notita");
            res.setStatus(HttpStatus.OK.value());
        }catch (Exception e){
            res.setStatus(HttpStatus.BAD_GATEWAY.value());
            res.setMensaje(e.getMessage());
        }
        return res;
    }
}
