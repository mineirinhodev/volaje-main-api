package br.com.emerson.cliente.service.impl;

import br.com.emerson.cliente.repository.UsersRepository;
import br.com.emerson.cliente.service.RegisterValidationService;
import br.com.emerson.cliente.dto.UserValidationResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterAndValidationsServiceImpl implements RegisterValidationService {


    private final UsersRepository usersRepository;

    @Autowired
    public RegisterAndValidationsServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserValidationResponseDTO validateField(String fieldName, String fieldValue) {
        if (fieldValue == null || fieldValue.trim().isEmpty()) {
            return new UserValidationResponseDTO(false); // Campo vazio, retorna falso
        }

        fieldValue = fieldValue.toLowerCase();
        boolean exists = switch (fieldName) {
            case "userlogin" -> usersRepository.existsByUserLogin(fieldValue);
            case "phone" -> usersRepository.existsByPhone(Long.valueOf(fieldValue));
            case "email" -> usersRepository.existsByEmail(fieldValue);
            default -> throw new IllegalStateException("Unexpected value: " + fieldName);
        };

        return new UserValidationResponseDTO(exists);
    }
}