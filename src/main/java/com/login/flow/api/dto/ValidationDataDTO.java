package com.login.flow.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationDataDTO {

    private String field;
    private String message;

    public ValidationDataDTO(String message) {
        this.message = message;
    }
    
}
