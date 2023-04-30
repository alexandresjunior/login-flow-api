package com.login.flow.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.login.flow.api.repository.UsuarioRepository;

@Service
public class AuthenticationService implements UserDetailsService {

    /**
     * Tendo em vista que a classe AuthenticationService implementa 
     * o service UserDetailsService, o Spring irá recorrer a ela toda
     * vez que um usuário realizar a sua autenticação.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Neste exemplo o nome de usuário/login é o e-mail cadastrado (unique)
        return usuarioRepository.findByEmail(username);
    }

    @Autowired
    private UsuarioRepository usuarioRepository;
    
}
