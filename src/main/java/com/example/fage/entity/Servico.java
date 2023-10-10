package com.example.fage.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private double preco;
    @Column(nullable = false)
    private String foto;
    @Column(nullable = false)
    private double duracao;
    @OneToMany(mappedBy="servico")
    private Set<Horario> horarios;
    @OneToMany(mappedBy="servico")
    private Set<Agendamento> agendamentos;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}
