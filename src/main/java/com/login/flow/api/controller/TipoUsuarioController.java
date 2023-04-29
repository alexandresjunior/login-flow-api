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

import com.login.flow.api.Repository.TipoUsuarioRepository;
import com.login.flow.api.model.TipoUsuario;

@RestController

public class TipoUsuarioController {

    //cadastrar tipo de usuario
    @PostMapping(value  = "/tipousuarios") 
    public TipoUsuario criarNovoTipoUsuario(@RequestBody TipoUsuario tipousuario) {
        return tipousuarioRepository.save(tipousuario);
    }

    @GetMapping(value = "tipousuarios/lista")
    public List<TipoUsuario> listarUsuarios() {
        return (List<TipoUsuario>) tipousuarioRepository.findAll();
        } 

    //lista tipo de usuario
    @GetMapping(value = "tipousuarios/{id}")
    public Optional<TipoUsuario> obterTipoPeloId (@PathVariable (value = "id") Long idTipoUsuario) {
        return tipousuarioRepository.findById(idTipoUsuario);
    }

    //Atualizar usuario     
    @PutMapping(value = "/tipousuarios/{id}")
    public TipoUsuario atualizarUsuario (
        @PathVariable (value = "id") Long idTipoUsuario, 
        @RequestBody TipoUsuario tipousuariobody) {
        Optional <TipoUsuario> tipousuarioOpt = tipousuarioRepository.findById(idTipoUsuario);
        if (tipousuarioOpt != null) {
            return tipousuarioRepository.save(tipousuariobody);
        }
        return null;

    }


    //Deletar tipo de usario
    @DeleteMapping(value = "tipousuarios/{id}")
    public String deletarTipoUsuarioPeloId (@PathVariable(value = "id") Long idTipoUsuario) {
    tipousuarioRepository.deleteById(idTipoUsuario);
    return "Tipo de Usuário deletado com sucesso!";
    }

    @Autowired
    private TipoUsuarioRepository tipousuarioRepository;
    
}
