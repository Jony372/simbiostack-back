package com.simbiostack.Servicios;

import com.simbiostack.Entidades.Caja;
import com.simbiostack.Repositorios.CajaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CajaServicio {

    @Autowired
    CajaRepositorio cajaRepositorio;

    public Caja addCaja(Float dinInicial){
        Caja ca = getCajaActual();
        Caja caja = new Caja();
        caja.setDinInicial(dinInicial);
        cajaRepositorio.save(caja);
        ca.setSaldoFinal(ca.getDinInicial() + ca.getEntradas() - ca.getSalidas());
        ca.setFechaFinal(LocalDateTime.now().toString());
        cajaRepositorio.save(ca);

        return caja;
    }

    public Caja getCaja(Integer id){
        return cajaRepositorio.findById(id).orElseThrow(()-> new RuntimeException("No se encontro la caja"));
    }

    public Caja getCajaActual(){
        return cajaRepositorio.findAll().stream().filter(caja -> caja.getFechaFinal() == null).toList().getFirst();
    }

}
