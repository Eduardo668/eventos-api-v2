package br.com.eventosapi.repository;

import br.com.eventosapi.model.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventosRepository extends JpaRepository<Eventos,Long> {

}
