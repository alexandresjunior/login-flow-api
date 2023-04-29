package com.login.flow.api.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;
    private String nome;
    private String sobrenome;
    @Column (unique = true)
    private String email;
    private LocalDate dataNascimento;
    private String senha;
    @ManyToOne TipoUsuario tipoUsuario;

    public List<Usuario> findAll() {
        return null;
    }

    public Optional<Usuario> findById(long id) {
        return null;
    }

    public Usuario save(Usuario usuario) {
        return null;
    }

    public Usuario UpDate(long id, Usuario usuario) {
        return null;
    }

    public void delete(long id) {
    }
    
}
