package com.simbiostack.Servicios;

import com.simbiostack.Entidades.Equipo;
import com.simbiostack.Entidades.Nota;
import com.simbiostack.Repositorios.NotaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@Service
public class NotaServicio {
    @Autowired
    NotaRepositorio notaRepositorio;
    @Autowired
    PrioridadServicio prioridadServicio;
    @Autowired
    ClienteServicio clienteServicio;
    @Autowired
    UsuarioServicio usuarioServicio;
    @Autowired
    EstadoNotaServicio estadoNotaServicio;
    @Autowired
    TipoPendienteServicio tipoPendienteServicio;

    public Nota agregarNota(Integer prioridad, Integer cliente, Integer usuario){
        Nota nota = new Nota();
        nota.setPrioridad(prioridadServicio.getPrioridad(prioridad));
        nota.setCliente(clienteServicio.getCliente(cliente));
        nota.setUsuario(usuarioServicio.getUser(usuario));
        nota.setFecha(LocalDateTime.now().toString());
        nota.setEstado(estadoNotaServicio.getEstado(6));
        notaRepositorio.save(nota);
        return nota;
    }

    public Stream<Nota> mostrarNotas(){
        return notaRepositorio.findAll().stream();
    }

    public Nota getNota(Integer id){
        return notaRepositorio.findById(id).orElseThrow(()-> new RuntimeException("No se encontro la nota"));
    }

    public String modificarEstado(Integer id ,Integer estado, Integer prioridad){
        Nota nota = notaRepositorio.findById(id).orElseThrow(()-> new RuntimeException("No se encontro la nota"));
        nota.setEstado(estadoNotaServicio.getEstado(estado));
        nota.setPrioridad(prioridadServicio.getPrioridad(prioridad));
        notaRepositorio.save(nota);
        return "Se modifico el estado de la nota";
    }

    public List<Integer> getNotasTrabajando(){
        return notaRepositorio.getNotasTrabajando();
    }

    public String cambiarEstado(Integer id, Integer opcion) {
        Nota n = getNota(id);
        if(opcion == 1){
            n.setEstado(estadoNotaServicio.getEstado(7));
            notaRepositorio.save(n);
            return "Se inicio el pendiente";
        }else{
            n.setEstado(estadoNotaServicio.getEstado(5));
            notaRepositorio.save(n);
            return "Se finalizo el pendiente";
        }
    }
}
