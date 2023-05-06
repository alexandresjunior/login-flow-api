package com.login.flow.api.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RedefinirSenhaDTO { 
    
    private String email; 
    private String senhaAtual; 
    private String novaSenha; 

    
    


    
    
}
