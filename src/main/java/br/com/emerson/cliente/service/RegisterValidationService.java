package br.com.emerson.cliente.service;

import br.com.emerson.cliente.dto.UserValidationResponseDTO;

public interface RegisterValidationService {

    UserValidationResponseDTO validateField(String fieldName, String fieldValue);
}
