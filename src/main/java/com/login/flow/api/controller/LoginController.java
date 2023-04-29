package com.login.flow.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.flow.api.model.Usuario;
import com.login.flow.api.repository.UsuarioRepository;

@RestController
public class LoginController {

@Autowired 
private UsuarioRepository usuarioRepository; 

@PostMapping("/login") 
public Object login (@RequestBody Usuario usuario) {
    String email = usuario.getEmail();
    String senha = usuario.getSenha(); 

    Optional<Usuario> usuarioBD = usuarioRepository.findByEmail(email);

    if(usuarioBD.isEmpty()) {
        return "Usuario nao cadastrado";
    }
   Usuario usuarioObj = usuarioBD.get();
   String senhaUsuarioBD = usuarioObj.getSenha();

   if(!senha.equals(senhaUsuarioBD)) {
    return "Senha ou email invalidos"; 
   } 

   return usuarioObj;


}
}