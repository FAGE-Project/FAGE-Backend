package com.example.fage.dto;

import com.example.fage.entity.Servico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FuncionarioListagemDto {

    @NotNull
    private long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String foto;

    private ServicoDto servico;
}
