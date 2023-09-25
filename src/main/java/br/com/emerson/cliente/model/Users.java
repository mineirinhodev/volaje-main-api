package br.com.emerson.cliente.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "USER_LOGIN", nullable = false)
    private String userLogin;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "USER_PASSWORD", nullable = false)
    private String password;

    @Column(name = "PHONE", nullable = false)
    private Long phone;
}
