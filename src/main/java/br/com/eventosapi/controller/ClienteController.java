package br.com.eventosapi.controller;

import br.com.eventosapi.clienteService.ClienteServiceimpl;
import br.com.eventosapi.model.Cliente;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@CrossOrigin
public class ClienteController {

    @Autowired
    private ClienteServiceimpl clienteService;

    @GetMapping("/list")
    public List<Cliente> listaDeClientes(){
        return clienteService.findAllClientes();
    }

    @PostMapping("/add")
    public String saveCliente(@RequestBody Cliente cliente) {

        try {
            clienteService.saveCliente(cliente);
        } catch (DataIntegrityViolationException e) {
            return "Este Cpf já está cadastrado!";
        } catch (ConstraintViolationException a) {
            return "Faltou algum valor";
        }

        return "O cadastro foi um sucesso!";
    }

    @DeleteMapping("/delete{id}")
    public void deleteCliente(@PathVariable("id") long id){
        Optional<Cliente> clienteOptional = clienteService.findClienteById(id);
        if(clienteOptional.isEmpty()){
            throw new IllegalArgumentException("Essa pessoa não existe!");
        }
        clienteService.deleteCliente(clienteOptional.get());
    }

    @PutMapping("/update{id}")
    public String updateCliente(@PathVariable("id") long id, @RequestBody Cliente cliente){
        Optional<Cliente> clienteUpdate = clienteService.findClienteById(id);
        if(clienteUpdate.isEmpty()){
            throw new IllegalArgumentException("Pessoa invalida");
        }
        clienteUpdate.get().setNome(cliente.getNome());
        clienteUpdate.get().setCpf(cliente.getCpf());
        clienteUpdate.get().setEmail(cliente.getEmail());
        clienteUpdate.get().setSenha(cliente.getSenha());
        clienteUpdate.get().setTelefone(cliente.getTelefone());
        clienteService.saveCliente(clienteUpdate.get());
        return "Editado com sucesso!";
    }


}
