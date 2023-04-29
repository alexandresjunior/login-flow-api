package com.login.flow.api.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.login.flow.api.Repository.UsuarioRepository;
import com.login.flow.api.model.Usuario;

@RestController
public class LoginUsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping(value = "/login")
    public Object login (@RequestBody Usuario usuario) {
        String email = usuario.getEmail();
        String senha = usuario.getSenha();
    

        // Verificar se existe um usuario cadastrado com email
        Optional<Usuario> usuarioBD = usuarioRepository.findByEmail(email);

        if (usuarioBD.isEmpty()){
        return "Usuario não cadastrado";
    }

    //Verificar se a senha bate com a fornecida
    Usuario usuarioBDObj = usuarioBD.get();

    String senhaUsuarioBD = usuarioBDObj.getSenha();

    if (!senha.equals(senhaUsuarioBD)) {
        return " Senha não inválida!";
    }
    return senhaUsuarioBD;


    }
}