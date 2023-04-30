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

import com.login.flow.api.model.Usuario;
import com.login.flow.api.repository.UsuarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/usuarios")
public class UsuarioController {

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public Usuario criarUsuario(@RequestBody @Valid Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping(value = "/{id}")
    public Optional<Usuario> obterUsuarioPeloId(@PathVariable(value = "id") Long id) {
        return usuarioRepository.findById(id);
    }

    @PutMapping
    public Usuario atualizarUsuario(@RequestBody @Valid Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping(value = "/{id}")
    public String deletarUsuario(@PathVariable(value = "id") Long id) {
        usuarioRepository.deleteById(id);

        return "Usuário deletado com sucesso!";
    }

    // @GetMapping(value = "/email/{email}")
    // public Optional<Usuario> buscarUsuarioPorEmail(@PathVariable(value = "email") String email) {
    //     return usuarioRepository.findByEmail(email);
    // }

    @Autowired
    private UsuarioRepository usuarioRepository;
}
