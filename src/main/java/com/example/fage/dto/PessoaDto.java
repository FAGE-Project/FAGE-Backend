package com.example.fage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaDto {
    private String nome;
    private String documento;
    private String email;
    private String password;
}
