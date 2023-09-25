package br.com.emerson.cliente.repository;

import br.com.emerson.cliente.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
     boolean existsByUserLogin(String userLogin);
     boolean existsByEmail(String email);

     boolean existsByPhone (Long phone);}

