package br.com.eventosapi.eventosService;

import br.com.eventosapi.model.Eventos;
import br.com.eventosapi.repository.EventosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoServiceimpl implements EventoService {

    @Autowired
    private EventosRepository eventosRepo;


    @Override
    public List<Eventos> findAllEventos() {
        return eventosRepo.findAll();
    }

    @Override
    public Eventos saveEvento(Eventos evento) {
        return eventosRepo.save(evento);
    }

    @Override
    public Optional<Eventos> findEventoById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteEvento(Eventos evento) {
         eventosRepo.delete(evento);
    }
}
