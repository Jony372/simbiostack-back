package com.simbiostack.Controladores;

import com.simbiostack.Entidades.NotaEntrega;
import com.simbiostack.Entidades.Response;
import com.simbiostack.Servicios.NotaEntregaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/nota-entrega")
public class ControladorNotaEntrega {
    @Autowired
    NotaEntregaServicio notaEntregaServicio;

    @PostMapping(path = "/agregar")
    public NotaEntrega agregarNotaEntrega(@RequestParam Integer usuario, @RequestParam Integer cliente, @RequestParam Float total, @RequestParam Integer estado, @RequestParam Boolean isEfectivo, @RequestParam Integer nota){
        return notaEntregaServicio.agregarNotaEntrega(usuario, cliente, total, estado, isEfectivo, nota);
    }

    @GetMapping(path = "/pagar/{id}")
    public Response pagarNotaEntrega(@PathVariable Integer id, @RequestParam boolean isEfectivo){
        Response res = new Response();
        res.setMensaje(notaEntregaServicio.pagarNotaEntrega(id, isEfectivo));
        res.setStatus(HttpStatus.OK.value());
        res.setTimestamp(LocalDateTime.now());
        return res;
    }

    @GetMapping(path = "/get/{id}")
    private NotaEntrega getNota(@PathVariable Integer id){
        return notaEntregaServicio.getNota(id);
    }

    @GetMapping(path = "/notas")
    public List<NotaEntrega> getNotasEntrega(){
        return notaEntregaServicio.getNotasEntrega();
    }

    @PostMapping(path = "/cancelar/{id}")
    public Response cancelarNota(@PathVariable Integer id){
        Response res = new Response();
        res.setMensaje(notaEntregaServicio.cancelarNota(id));
        res.setTimestamp(LocalDateTime.now());
        res.setStatus(HttpStatus.OK.value());
        return res;
    }

    @PostMapping(path = "/filtrar")
    public List<NotaEntrega> filtrarNotas(@RequestParam String search){
        return notaEntregaServicio.filtro(search);
    }
}
