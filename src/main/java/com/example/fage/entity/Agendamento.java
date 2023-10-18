package com.example.fage.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date data;

    private Time hora_inicio;

    private Time hora_fim;

    @OneToOne()
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;
}
