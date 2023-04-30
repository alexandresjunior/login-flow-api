package com.login.flow.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.flow.api.model.PerfilUsuario;
import com.login.flow.api.repository.PerfilUsuarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/perfis-usuario")
public class PerfilUsuarioController {

    @GetMapping
    public List<PerfilUsuario> listarTiposUsuario() {
        return perfilUsuarioRepository.findAll();
    }

    @PostMapping
    public PerfilUsuario criarTipoUsuario(@RequestBody @Valid PerfilUsuario tipoUsuario) {
        return perfilUsuarioRepository.save(tipoUsuario);
    }

    @GetMapping(value = "/{id}")
    public Optional<PerfilUsuario> obterTipoUsuarioPeloId(@PathVariable(value = "id") Long id) {
        return perfilUsuarioRepository.findById(id);
    }

    @PutMapping
    public PerfilUsuario atualizarTipoUsuario(@RequestBody @Valid PerfilUsuario tipoUsuario) {
        return perfilUsuarioRepository.save(tipoUsuario);
    }

    @DeleteMapping(value = "/{id}")
    public String deletarTipoUsuario(@PathVariable(value = "id") Long id) {
        perfilUsuarioRepository.deleteById(id);

        return "Perfil de usuário deletado com sucesso!";
    }

    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;

}