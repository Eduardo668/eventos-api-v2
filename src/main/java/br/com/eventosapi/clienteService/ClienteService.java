package br.com.eventosapi.clienteService;

import br.com.eventosapi.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    public List<Cliente> findAllClientes();

    public Cliente saveCliente(Cliente cliente);

    public Optional<Cliente> findClienteById(Long id);

//    public Optional<Cliente> findByEmail(String email);

    public void deleteCliente(Cliente cliente);

}
