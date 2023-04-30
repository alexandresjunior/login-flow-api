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

    @Autowired // injetar
    private UsuarioRepository usuarioRepository;

    @GetMapping (value = "usuario/lista")// método para chamar à lista
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();

    }
    @GetMapping(value= "usuario/{id}") // Método para buscar
    public Optional<Usuario> obterUsuarioPeloId (@PathVariable long id){//@pathVariable é para chamar lá no localhost no banco h2.
        return usuarioRepository.findById(id);
    }


    @PostMapping (value = "/usuario") // metodo para cadastrar, criar ou inserir
    public Usuario save(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario); // "save" serve tanto para criar como para atualizar
    }
    

    @PutMapping(value ="usuario/{id}") //@PutMapping método para atualizar;
    public Usuario update(@RequestBody Usuario usuario){

      return usuarioRepository.save(usuario);
    }
    @DeleteMapping(value ="usuario/{id}") //@DeleteMapping método para deletar;
    public void delete(@PathVariable long id){
        usuarioRepository.deleteById(id);

    }

}
