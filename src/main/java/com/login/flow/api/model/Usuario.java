package com.login.flow.api.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;

    @NotNull(message = "O nome deverá ser informado")
    @NotBlank(message = "O nome não poderá ser vazio")
    @Size(min = 3, max = 45, message = "O nome deverá ter entre 3 e 45 caracteres")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Informar apenas letras para o nome")
    private String nome;

    @NotNull(message = "O sobrenome deverá ser informado")
    @NotBlank(message = "O sobrenome não poderá ser vazio")
    @Size(min = 2, max = 45, message = "O sobrenome deverá ter entre 5 e 45 caracteres")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Informar apenas letras para o sobrenome")
    private String sobrenome;

    @Column(unique = true)
    private String email;

    @Past
    @NotNull
    private LocalDate dataNascimento;

    // TODO: Incluir regex
    @NotNull(message = "O campo senha deverá ser informado")
    @NotBlank(message = "O campo senha não poderá ser vazio")
    @Size(min = 6, max = 6, message = "O campo senha deverá ter 6 caracteres")
    private String senha;

    @OneToOne
    @JoinColumn(name = "idTipoUsuario")
    private TipoUsuario tipoUsuario;

}