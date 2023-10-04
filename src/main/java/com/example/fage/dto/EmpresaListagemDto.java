package com.example.fage.dto;

import com.example.fage.entity.Empresa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpresaListagemDto {
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

}
