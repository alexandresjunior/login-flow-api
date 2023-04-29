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

import com.login.flow.api.model.TipoUsuario;
import com.login.flow.api.repository.TipoUsuarioRepository;

@RestController
public class TipoUsuarioController {
    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;
    
    @GetMapping("/tipoUsuarios")
    public List<TipoUsuario> listar() {
        return tipoUsuarioRepository.findAll();
    }

    @PostMapping("/tipoUsuarios")
    public TipoUsuario criar(@RequestBody TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    @GetMapping("/tipoUsuarios/{id}")
    public Optional<TipoUsuario> obterTipoUsuarioPeloId(@PathVariable(value = "id") Long id) {
        return tipoUsuarioRepository.findById(id);
    }
    
    
    @PutMapping("/tipoUsuarios")
    public TipoUsuario atualizar(@RequestBody TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
        
        }
        @DeleteMapping("/tipoUsuarios/{id}")
    public String deletar (@PathVariable(value = "id") Long id) {
        tipoUsuarioRepository.deleteById(id);

        return "Pessoa deletada com sucesso!";

    }

    
}