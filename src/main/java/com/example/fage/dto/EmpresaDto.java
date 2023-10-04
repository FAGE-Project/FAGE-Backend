package com.example.fage.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpresaDto {

    @NotNull
    private long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String documento;

    @NotBlank
    private String descricao;

    @NotBlank
    private String foto;

    @NotNull
    private int nota;

    @NotNull
    private boolean aberta;

    private List<FuncionarioListagemDto> funcionarios;
}
