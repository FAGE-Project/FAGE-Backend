package com.example.fage.dto;

import com.example.fage.entity.Horario;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class ServicoDto {

    private long id;
    private String nome;
    private String descricao;
    private double preco;
    private String foto;

    private List<HorarioDto> horarios;

    private EmpresaDto empresaDto;

}
