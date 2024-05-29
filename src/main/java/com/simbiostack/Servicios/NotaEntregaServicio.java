package com.simbiostack.Servicios;

import com.simbiostack.Entidades.Compra;
import com.simbiostack.Entidades.NotaEntrega;
import com.simbiostack.Repositorios.NotaEntregaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotaEntregaServicio {
    @Autowired
    NotaEntregaRepositorio notaEntregaRepositorio;
    @Autowired
    UsuarioServicio usuarioServicio;
    @Autowired
    ClienteServicio clienteServicio;
    @Autowired
    EstadoNotaServicio estadoNotaServicio;
    @Autowired
    NotaServicio notaServicio;
    @Autowired
    CajaServicio cajaServicio;

    public NotaEntrega agregarNotaEntrega(Integer usuario, Integer cliente, Float total, Integer estado, Boolean isEfectivo, Integer nota){
        NotaEntrega ne = new NotaEntrega();
        ne.setUsuario(usuarioServicio.getUser(usuario));
        ne.setCliente(clienteServicio.getCliente(cliente));
        ne.setTotal(total);
        ne.setEstado(estadoNotaServicio.getEstado(estado));
        ne.setEfectivo(isEfectivo);
        ne.setFecha(LocalDateTime.now().toString());
        ne.setNota(notaServicio.getNota(nota));
        if(estado == 2){
            ne.setCaja(cajaServicio.getCajaActual());
        }
        notaEntregaRepositorio.save(ne);
        return ne;
    }

    public NotaEntrega getNota(Integer id){
        return notaEntregaRepositorio.findById(id).orElseThrow(() -> new RuntimeException("No se encontro la nota"));
    }

    public String pagarNotaEntrega(Integer id, Boolean isEfectivo){
        NotaEntrega ne = getNota(id);
        ne.setEstado(estadoNotaServicio.getEstado(2));
        ne.setCaja(cajaServicio.getCajaActual());
        ne.setEfectivo(isEfectivo);
        notaEntregaRepositorio.save(ne);
        return "Nota pagada";
    }

    public List<NotaEntrega> getNotasEntrega(){
        return notaEntregaRepositorio.findAll().stream().toList();
    }

    public String cancelarNota(Integer id){
        NotaEntrega ne = getNota(id);
        ne.setCancelado(true);
        notaEntregaRepositorio.save(ne);
        return "Nota cancelada";
    }

    public List<NotaEntrega> filtro(String search){
        return notaEntregaRepositorio.findAll().stream().filter(n -> n.getCliente().getNombre().toLowerCase().contains(search.toLowerCase()) || n.getId().toString().contains(search)).toList();
    }
}
