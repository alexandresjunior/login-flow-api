package com.login.flow.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.flow.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    
}