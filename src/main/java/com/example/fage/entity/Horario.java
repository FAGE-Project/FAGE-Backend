package com.example.fage.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private int fracionamento;

    @Column(nullable = false)
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    
    @ManyToOne
    @JoinColumn(name = "agenda_id")
    private Agenda agenda;

}
