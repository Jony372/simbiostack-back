package com.simbiostack.Servicios;

import com.simbiostack.Entidades.EstadoNota;
import com.simbiostack.Entidades.Nota;
import com.simbiostack.Entidades.Pendiente;
import com.simbiostack.Repositorios.PendienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class PendienteServicio {
    @Autowired
    PendienteRepositorio pendienteRepositorio;
    @Autowired
    ClienteServicio clienteServicio;
    @Autowired
    UsuarioServicio usuarioServicio;
    @Autowired
    EstadoNotaServicio estadoNotaServicio;
    @Autowired
    TipoPendienteServicio tipoPendienteServicio;
    @Autowired
    PrioridadServicio prioridadServicio;

    public List<Pendiente> getPendientes(){
        return pendienteRepositorio.findAll().stream().toList();
    }

    public Pendiente getPendiente(Integer id){
        return pendienteRepositorio.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el pendiente"));
    }

    public Object[] getVistaPendientes(){
        return pendienteRepositorio.getVistaPendientes();
    }

    public Pendiente agregarPendiente(String nombre, Integer cliente, Integer usuario, Integer prioridad, String descripcion, String fechaEstimada, Integer estado, Integer tipo){
        Pendiente pendiente = new Pendiente();
        pendiente.setNombre(nombre);
        if(cliente != null){
            pendiente.setCliente(clienteServicio.getCliente(cliente));
        }
        pendiente.setUsuario(usuarioServicio.getUser(usuario));
        pendiente.setDescripcion(descripcion);
        pendiente.setFecha(LocalDateTime.now().toString());
        if(fechaEstimada != null){
            pendiente.setFechaEstimada(fechaEstimada);
        }
        pendiente.setEstado(estadoNotaServicio.getEstado(estado));
        pendiente.setTipo(tipoPendienteServicio.getTipoPendiente(tipo));
        pendiente.setPrioridad(prioridadServicio.getPrioridad(prioridad));
        pendienteRepositorio.save(pendiente);
        return  pendiente;
    }

    public Pendiente editarPendiente(Integer id ,String nombre, Integer cliente, Integer usuario, Integer prioridad, String descripcion, String fechaEstimada, Integer estado, Integer tipo){
        Pendiente pendiente = getPendiente(id);
        if(pendiente.getEstado().getId() == 6 && estado != 6){
            pendiente.setFechaInicio(LocalDateTime.now().toString());
        }
        pendiente.setNombre(nombre);
        pendiente.setCliente(clienteServicio.getCliente(cliente));
        pendiente.setUsuario(usuarioServicio.getUser(usuario));
        pendiente.setDescripcion(descripcion);
        pendiente.setFechaEstimada(fechaEstimada);
        pendiente.setEstado(estadoNotaServicio.getEstado(estado));
        pendiente.setTipo(tipoPendienteServicio.getTipoPendiente(tipo));
        pendiente.setPrioridad(prioridadServicio.getPrioridad(prioridad));
        pendienteRepositorio.save(pendiente);
        return  pendiente;
    }


    public String cambiarEstado(Integer id, Integer cambio){
        Pendiente p = getPendiente(id);
        if(cambio == 1){
            p.setEstado(estadoNotaServicio.getEstado(7));
            p.setFechaInicio(LocalDateTime.now().toString());
            pendienteRepositorio.save(p);
            return "Se inicio el pendiente";
        }else{
            p.setEstado(estadoNotaServicio.getEstado(5));
            pendienteRepositorio.save(p);
            return "Se finalizo el pendiente";
        }
    }

    public String modificarEstado(Integer id ,Integer estado, Integer prioridad){
        Pendiente pendiente = pendienteRepositorio.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el pendiente"));
        pendiente.setEstado(estadoNotaServicio.getEstado(estado));
        pendiente.setPrioridad(prioridadServicio.getPrioridad(prioridad));
        if(estado != 5 && pendiente.getFechaInicio() == null){
            pendiente.setFechaInicio(LocalDateTime.now().toString());
        }
        pendienteRepositorio.save(pendiente);
        return "Se modifico el estado de la nota";
    }
}
