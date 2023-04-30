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

import com.login.flow.api.model.TipoUsuario;
import com.login.flow.api.repository.TipoUsuarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/tipos-usuario")
public class TipoUsuarioController {

    @GetMapping
    public List<TipoUsuario> listarTiposUsuario() {
        return tipoUsuarioRepository.findAll();
    }

    @PostMapping
    public TipoUsuario criarTipoUsuario(@RequestBody @Valid TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    @GetMapping(value = "/{id}")
    public Optional<TipoUsuario> obterTipoUsuarioPeloId(@PathVariable(value = "id") Long id) {
        return tipoUsuarioRepository.findById(id);
    }

    @PutMapping
    public TipoUsuario atualizarTipoUsuario(@RequestBody @Valid TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    @DeleteMapping(value = "/{id}")
    public String deletarTipoUsuario(@PathVariable(value = "id") Long id) {
        tipoUsuarioRepository.deleteById(id);

        return "Tipo de usuário deletado com sucesso!";
    }

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

}