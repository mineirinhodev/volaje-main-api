package br.com.emerson.cliente.controller;

import br.com.emerson.cliente.dto.UserValidationResponseDTO;
import br.com.emerson.cliente.service.RegisterValidationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/validationsRegister")
@Api(tags = "Assinaturas de Cartão de Crédito")
public class RegisterAndValidationsController {


    @Autowired private RegisterValidationService registerValidationService;

    @ApiOperation(value = "Validate user registration")
    @GetMapping("/validate")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Validation successful."),
            @ApiResponse(code = 400, message = "Invalid Request."),
            @ApiResponse(code = 401, message = "Invalid Authentication."),
            @ApiResponse(code = 403, message = "Recurring Product Not Enabled."),
            @ApiResponse(code = 404, message = "Endpoint Not Found."),
            @ApiResponse(code = 409, message = "Already Registered."),
            @ApiResponse(code = 500, message = "Internal Server Error.")
    })
    public ResponseEntity<UserValidationResponseDTO> validate(
            @RequestParam("fieldName") String fieldName,
            @RequestParam("fieldValue") String fieldValue) {
        UserValidationResponseDTO validationResponseDTO = registerValidationService.validateField(fieldName, fieldValue);{
            return ResponseEntity.ok(validationResponseDTO);
        }
    }
}
