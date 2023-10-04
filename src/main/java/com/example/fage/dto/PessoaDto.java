package com.example.fage.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaDto {
    @NotBlank
    private String nome;

    @NotBlank
    private String documento;

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
