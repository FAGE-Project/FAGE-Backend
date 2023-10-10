package com.example.fage.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AgendamentoDto {

    private int id;
    private PessoaDto pessoa;
    private ServicoDto servicoDto;
    private Date dataHora;
}
