package br.com.eventosapi.repository;

import br.com.eventosapi.model.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventosRepository extends JpaRepository<Eventos,Long> {

}
