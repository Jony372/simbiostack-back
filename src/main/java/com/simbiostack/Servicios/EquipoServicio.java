package com.simbiostack.Servicios;

import com.simbiostack.Entidades.Equipo;
import com.simbiostack.Repositorios.EquipoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class EquipoServicio {
    @Autowired
    EquipoRepositorio equipoRepositorio;
    @Autowired
    ClienteServicio clienteServicio;
    @Autowired
    TipoPendienteServicio tipoPendienteServicio;

    public Equipo agregarEquipo(String tipo, String marca, String modelo, String color, String pass, String problema, String extras, Boolean cargador, Boolean funda, Boolean usb, Boolean cables, Integer cliente, Integer tipoPendiente){
        Equipo equipo = new Equipo();
        equipo.setTipo(tipo);
        equipo.setMarca(marca);
        equipo.setModelo(modelo);
        equipo.setColor(color);
        equipo.setPass(pass);
        equipo.setProblema(problema);
        equipo.setCargador(cargador);
        equipo.setFunda(funda);
        equipo.setUsb(usb);
        equipo.setCables(cables);
        equipo.setTipoPendiente(tipoPendienteServicio.getTipoPendiente(tipoPendiente));
        equipo.setCliente(clienteServicio.getCliente(cliente));
        equipo.setExtras(extras);
        equipoRepositorio.save(equipo);
        return equipo;
    }

    public Stream<Equipo> mostrarEquipos(){
        return equipoRepositorio.findAll().stream();
    }

    public Equipo getEquipo(Integer id){
        return equipoRepositorio.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el equipo"));
    }

}
