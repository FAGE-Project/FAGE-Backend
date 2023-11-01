package com.example.fage.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date data;

    private Time hora_inicio;

    private Time hora_fim;

    @OneToOne()
    private Pessoa pessoa;

    @Column(nullable = false)
    private int fracionamento;

    @OneToMany(mappedBy="agenda")
    private Set<Horario> horarios;


}
