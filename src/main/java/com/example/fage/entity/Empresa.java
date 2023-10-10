package com.example.fage.entity;

import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.web.bind.annotation.CrossOrigin;

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
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nome;

    private String documento;

    private String descricao;

    private String foto;

    private int nota;

    @Column(columnDefinition = "tinyint(1) default 1")
    private boolean aberta;

    @OneToMany(mappedBy = "empresa")
    private Set<Funcionario> funcionarios;
    @OneToMany(mappedBy="empresa")
    private Set<Servico> servicos;
}
