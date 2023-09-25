package br.com.emerson.cliente.service.impl;

import br.com.emerson.cliente.model.Users;
import br.com.emerson.cliente.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl {

    @Autowired
    private UsersRepository usersRepository;

   /* public RegisterUser registerUser(RegisterUser registerUser) {

        RegisterUser registerUserBase = registerUserRepository
                .findByUserLoginAndEmailAndAndPhone(registerUser.getUserLogin());

        return registerUserRepository.save(registerUser);
    }*/

    public List<Users> listaClientes() {
        return usersRepository.findAll();

    }

    public Optional<Users> listaClientePorId(Long id) {
        return usersRepository.findById(id);
    }

    public void deletarClientePorId(Long id) {
        usersRepository.deleteById(id);
    }
}
