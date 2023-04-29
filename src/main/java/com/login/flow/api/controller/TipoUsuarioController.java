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
@RestController
@RequestMapping ("/TipoUsuario")
public class TipoUsuarioController {
    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @GetMapping 
    public List<TipoUsuario> findAll() {
        return tipoUsuarioRepository.findAll();
   
    }
    
    @GetMapping("/{id}") 
    public Optional<TipoUsuario> getById(@PathVariable long id){
        return tipoUsuarioRepository.findById(id);
    }


    @PostMapping (value = "/TipoUsuario") 
    public TipoUsuario save(@RequestBody TipoUsuario TipoUsuario){
        return tipoUsuarioRepository.save(TipoUsuario);
    }
    

    @PutMapping("/") 
    public TipoUsuario upDate(@RequestBody TipoUsuario tipoUsuario){
      return tipoUsuarioRepository.save(tipoUsuario);
    }
    @DeleteMapping("/{id}") 
    public void delete(@PathVariable long id){
        TipoUsuario.delete(id);

    }
    
}
