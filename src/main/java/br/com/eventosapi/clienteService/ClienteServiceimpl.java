package br.com.eventosapi.clienteService;

import br.com.eventosapi.model.Cliente;
import br.com.eventosapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceimpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepo;


    @Override
    public List<Cliente> findAllClientes() {
        return clienteRepo.findAll();
    }



    @Override
    public Cliente saveCliente(Cliente cliente) {

        return clienteRepo.save(cliente);

    }

    @Override
    public Optional<Cliente> findClienteById(Long id) {
        return clienteRepo.findById(id);
    }



    @Override
    public void deleteCliente(Cliente cliente) {
        clienteRepo.delete(cliente);
    }



}
