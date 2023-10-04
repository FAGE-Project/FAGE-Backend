package com.example.fage.dto;

import com.example.fage.entity.Horario;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ServicoDto {

    @NotNull
    private long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotNull
    private double preco;

    @NotBlank
    private String foto;

    private List<HorarioDto> horarios;

}
