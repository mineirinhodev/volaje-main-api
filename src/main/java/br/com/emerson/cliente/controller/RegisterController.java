package br.com.emerson.cliente.controller;

import br.com.emerson.cliente.model.Users;
import br.com.emerson.cliente.service.impl.ClienteServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/operationsLoginRegister")
public class RegisterController {
    @Autowired
    private ClienteServiceImpl clienteService;

    @Autowired
    ModelMapper modelMapper;

    /*@PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterUser salvar(@RequestBody RegisterUser registerUser) {
        return clienteService.registerUser(registerUser);
    }*/

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Users> listaClientes() {
        return clienteService.listaClientes();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Users listaClientePorId(@PathVariable("id") Long id) {
        return clienteService.listaClientePorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerClientePorId(@PathVariable("id") Long id) {
        clienteService.listaClientePorId(id).map(users -> {
            clienteService.deletarClientePorId(id);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarCliente(@PathVariable("id")Long id , @RequestBody Users users) {
        clienteService.listaClientePorId(id).map(usersBase -> {
                    modelMapper.map(users, usersBase);
                    return Void.TYPE;
                }).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

    }}
