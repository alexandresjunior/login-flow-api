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
import org.springframework.web.bind.annotation.RestController;

import com.login.flow.api.model.Usuario;
import com.login.flow.api.repository.UsuarioRepository;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @PostMapping("/usuarios")
    public Usuario criar(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/usuarios/{id}")
    public Optional<Usuario> obterUsuarioPeloId(@PathVariable(value = "id") Long id) {
        return usuarioRepository.findById(id);
    }

    @PutMapping("/usuarios")
    public Usuario atualizar(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    @DeleteMapping("/usuarios/{id}")
    public String deletar(@PathVariable(value = "id") Long id) {
        usuarioRepository.deleteById(id);

        return "Pessoa deletada com sucesso!";
    }

    @GetMapping("/email/{email}") 
    public Optional<Usuario> buscarPorEmail(@PathVariable(value = "email") String email) {
        return usuarioRepository.findByEmail(email);
}
}
