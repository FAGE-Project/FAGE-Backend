package com.example.fage.dto;

import com.example.fage.entity.Pessoa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpresaDto {
    private String nome;
    private String documento;
    private Pessoa pessoa;
}
