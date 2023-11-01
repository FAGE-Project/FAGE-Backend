package com.example.fage.entity;

import java.sql.Time;
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

    private Time hora_inicio;

    private Time hora_fim;


    @Column(nullable = false)
    private boolean status;
    
    @ManyToOne
    @JoinColumn(name = "agenda_id")
    private Agenda agenda;

}
