package com.example.fage.dto;

import com.example.fage.entity.Empresa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpresaListagemDto {
    private String nome;

    private boolean aberta;

}
