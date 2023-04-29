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

import com.login.flow.api.model.Usuario;

public class UsuarioController {
    @Autowired // injetar
    private Usuario usuario;

    @GetMapping // método para chamar à lista
    public List<Usuario> findAll() {
        return usuario.findAll();

    }
    @GetMapping("/{id}") // Método para buscar
    public Optional<Usuario> getById(@PathVariable long id){//@pathVariable é para chamar lá no localhost no banco h2.
        return usuario.findById(id);
    }


    @PostMapping (value = "/usuario") // metodo para cadastrar, criar ou inserir
    public Usuario save(@RequestBody Usuario usuario){
        return usuario.save(usuario); // "save" serve tanto para criar como para atualizar
    }
    

    @PutMapping("/{id}") //@PutMapping método para atualizar;
    public Usuario upDate(@PathVariable long id, @RequestBody Usuario usuario){
      return usuario.UpDate(id, usuario);
    }
    @DeleteMapping("/{id}") //@DeleteMapping método para deletar;
    public void delete(@PathVariable long id){
        usuario.delete(id);

    }

}
