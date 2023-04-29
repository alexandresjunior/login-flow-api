package com.login.flow.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.flow.api.model.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository <TipoUsuario,Long> {
    TipoUsuario save(Long Id);    
}
