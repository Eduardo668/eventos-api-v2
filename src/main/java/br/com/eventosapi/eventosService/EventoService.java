package br.com.eventosapi.eventosService;

import br.com.eventosapi.model.Eventos;

import java.util.List;
import java.util.Optional;

public interface EventoService {

    public List<Eventos> findAllEventos();

    public Eventos saveEvento(Eventos eventos);

    public Optional<Eventos> findEventoById(Long id);

    public void deleteEvento(Eventos eventos);

}
