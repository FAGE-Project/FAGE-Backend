package com.example.fage.dto;

import com.example.fage.entity.Horario;
import com.example.fage.entity.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AgendaDto {

    private Date data;
    private Time hora_inicio;
    private Time hora_fim;
    private Pessoa pessoa;
    private List<Horario> horarios;
}
