package com.example.fage.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpresaDto {

    private long id;
    private String nome;

    private String documento;

    private String descricao;

    private String foto;

    private int nota;

    private boolean aberta;

    private List<FuncionarioListagemDto> funcionarios;
}
