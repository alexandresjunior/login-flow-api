package com.login.flow.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.flow.api.dto.AutenticacaoDTO;
import com.login.flow.api.dto.TokenDTO;
import com.login.flow.api.model.Usuario;
import com.login.flow.api.service.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AutenticacaoController {

    @PostMapping("/login")
    public ResponseEntity<Object> efetuarLogin(@RequestBody @Valid AutenticacaoDTO autenticacaoDTO) {
        // Efetua a consulta no banco de dados através do AuthenticationService
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        autenticacaoDTO.getEmail(),
                        autenticacaoDTO.getSenha()));

        Usuario loggedUser = (Usuario) authentication.getPrincipal();

        String token = tokenService.generateToken(loggedUser);

        return ResponseEntity.status(HttpStatus.OK).body(new TokenDTO(token));
    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

}
