package br.com.eventosapi.controller;

import br.com.eventosapi.eventosService.EventoServiceimpl;
import br.com.eventosapi.model.Eventos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoServiceimpl eventoService;


    @GetMapping("/Eventos")
    public List<Eventos> listaDeEventos(){
        return eventoService.findAllEventos();
    }

    @PostMapping("/addEvento")
    public String addEvento(@RequestBody Eventos eventos){
        try {
            eventoService.saveEvento(eventos);
        }catch (ConstraintViolationException e){
            return "Faltou algum valor";
        }
        return "Evento cadastrado com sucesso";
    }

    @DeleteMapping("/deleteEvento{id}")
    public void deleteEvento(@PathVariable("id") long id){
        Optional<Eventos> eventosOpt = eventoService.findEventoById(id);
        if(eventosOpt.isEmpty()){
            throw new IllegalArgumentException("Pessoa invalida");
        }
        eventoService.deleteEvento(eventosOpt.get());
    }

    @PutMapping("/updateEvento{id}")
    public String updateEvento(@RequestBody Eventos eventos, @PathVariable("id") long id){
        Optional<Eventos> eventosOpt = eventoService.findEventoById(id);
        if(eventosOpt.isEmpty()){
            throw new IllegalArgumentException("Pessoa invalida");
        }
        eventosOpt.get().setNome_evento(eventos.getNome_evento());
        eventosOpt.get().setLocal(eventos.getLocal());
        eventosOpt.get().setPreco(eventos.getPreco());
        eventosOpt.get().setDataEvento(eventos.getDataEvento());
        return "Evento editado com sucesso";
    }

}
