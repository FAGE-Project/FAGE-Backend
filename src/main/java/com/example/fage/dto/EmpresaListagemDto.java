package com.example.fage.dto;

import com.example.fage.entity.Empresa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpresaListagemDto {

    private long id;
    private String nome;

    private String documento;

    private String descricao;

    private String foto;

    private int nota;

    private boolean aberta;

}
